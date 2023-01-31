package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCarDTO;
import softuni.exam.models.dto.ImportCarRootDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.PathFiles;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    private final ModelMapper modelMapper;
    private final Validator validator;
    private final Unmarshaller unmarshaller;


    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, Validator validator) throws JAXBException {
        this.carRepository = carRepository;

        this.modelMapper = modelMapper;
        this.validator = validator;

        JAXBContext context = JAXBContext.newInstance(ImportCarRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(PathFiles.CARS_PATH);
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        ImportCarRootDTO importCarRootDTO = (ImportCarRootDTO) this.unmarshaller
                .unmarshal(new FileReader(PathFiles.CARS_PATH.toAbsolutePath().toString()));

        return importCarRootDTO.getCars()
                .stream()
                .map(this::importCar)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importCar(ImportCarDTO dto) {
        Set<ConstraintViolation<ImportCarDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid car";
        }

        Optional<Car> optCar =
                this.carRepository.findByPlateNumber(dto.getPlateNumber());

        if (optCar.isPresent()) {
            return "Invalid car";
        }

        Car car = this.modelMapper.map(dto, Car.class);
        this.carRepository.save(car);

        return "Successfully imported car " + car.getCarMake() + " - " + car.getCarModel();
    }
}
