package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportTaskDTO;
import softuni.exam.models.dto.ImportTaskRootDTO;
import softuni.exam.models.entity.*;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.repository.PartRepository;
import softuni.exam.repository.TaskRepository;
import softuni.exam.service.TaskService;
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

import static softuni.exam.util.PathFiles.TASKS_PATH;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final CarRepository carRepository;
    private final MechanicRepository mechanicRepository;
    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;
    private final Unmarshaller unmarshaller;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, CarRepository carRepository, MechanicRepository mechanicRepository, PartRepository partRepository, ModelMapper modelMapper, Validator validator) throws JAXBException {
        this.taskRepository = taskRepository;
        this.carRepository = carRepository;
        this.mechanicRepository = mechanicRepository;
        this.partRepository = partRepository;

        this.modelMapper = modelMapper;
        this.validator = validator;

        JAXBContext context = JAXBContext.newInstance(ImportTaskRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.taskRepository.count() > 0;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(PathFiles.TASKS_PATH);
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        ImportTaskRootDTO importTaskRootDTO = (ImportTaskRootDTO) this.unmarshaller
                .unmarshal(new FileReader(PathFiles.TASKS_PATH.toAbsolutePath().toString()));

        return importTaskRootDTO.getTasks()
                .stream()
                .map(this::importTask)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        return this.taskRepository
                .findByCar_CarTypeOrderByPriceDesc(CarType.coupe)
                .stream()
                .map(Task::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importTask(ImportTaskDTO dto) {
        Set<ConstraintViolation<ImportTaskDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid task";
        }

        Optional<Mechanic> mechanic =
                this.mechanicRepository.findByFirstName(dto.getMechanic().getFirstName());

        if (mechanic.isEmpty()) {
            return "Invalid task";
        }

        Optional<Car> car = this.carRepository.findById(dto.getCar().getId());
        Optional<Part> part = this.partRepository.findById(dto.getPart().getId());

        Task task = this.modelMapper.map(dto, Task.class);
        task.setCar(car.get());
        task.setMechanic(mechanic.get());
        task.setPart(part.get());

        this.taskRepository.save(task);

        return String.format("Successfully imported task %.2f", task.getPrice());
    }
}
