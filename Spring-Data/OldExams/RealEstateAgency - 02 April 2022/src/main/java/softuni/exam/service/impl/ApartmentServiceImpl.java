package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportApartmentDTO;
import softuni.exam.models.dto.ImportApartmentRootDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;

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

import static softuni.exam.util.PathFiles.APARTMENTS_PATH;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;

    private final ModelMapper modelMapper;
    private final Validator validator;
    private final Unmarshaller unmarshaller;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository, TownRepository townRepository, ModelMapper modelMapper, Validator validator) throws JAXBException {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;

        this.modelMapper = modelMapper;
        this.validator = validator;

        JAXBContext context = JAXBContext.newInstance(ImportApartmentRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(APARTMENTS_PATH);
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        ImportApartmentRootDTO importApartmentRootDTO = (ImportApartmentRootDTO) this.unmarshaller
                .unmarshal(new FileReader(APARTMENTS_PATH.toAbsolutePath().toString()));

        return importApartmentRootDTO.getApartments()
                .stream()
                .map(this::importApartment)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importApartment(ImportApartmentDTO dto) {
        Set<ConstraintViolation<ImportApartmentDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid apartment";
        }

        Optional<Apartment> optApartment =
                this.apartmentRepository.findByTown_TownNameAndArea(dto.getTownName(), dto.getArea());

        if (optApartment.isPresent()) {
            return "Invalid apartment";
        }

        Optional<Town> town = this.townRepository.findByTownName(dto.getTownName());

        Apartment apartment = this.modelMapper.map(dto, Apartment.class);
        apartment.setTown(town.get());

        this.apartmentRepository.save(apartment);
        return "Successfully imported apartment " + apartment.getApartmentType() + " - " + apartment.getArea();

    }
}
