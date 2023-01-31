package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportMechanicsDTO;
import softuni.exam.models.dto.ImportPartsDTO;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.MechanicRepository;
import softuni.exam.service.MechanicService;
import softuni.exam.util.PathFiles;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MechanicServiceImpl implements MechanicService {

    private final MechanicRepository mechanicRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final Validator validator;

    @Autowired
    public MechanicServiceImpl(MechanicRepository mechanicRepository, ModelMapper modelMapper, Gson gson, Validator validator) {
        this.mechanicRepository = mechanicRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.mechanicRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(PathFiles.MECHANICS_PATH);
    }

    @Override
    public String importMechanics() throws IOException {
        String json = this.readMechanicsFromFile();

        ImportMechanicsDTO[] importMechanicsDTOS = gson.fromJson(json, ImportMechanicsDTO[].class);

        return Arrays.stream(importMechanicsDTOS)
                .map(this::importMechanic)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importMechanic(ImportMechanicsDTO dto) {
        Set<ConstraintViolation<ImportMechanicsDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid mechanic";
        }

        Optional<Mechanic> optMechanic = this.mechanicRepository.findByEmail(dto.getEmail());

        if (optMechanic.isPresent()) {
            return "Invalid mechanic";
        }

        Mechanic mechanic = this.modelMapper.map(dto, Mechanic.class);

        this.mechanicRepository.save(mechanic);

        return "Successfully imported mechanic " + mechanic.getFirstName() + " " + mechanic.getLastName();
    }
}
