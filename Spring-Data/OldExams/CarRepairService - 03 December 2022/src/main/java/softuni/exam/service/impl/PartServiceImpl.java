package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportPartsDTO;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartRepository;
import softuni.exam.service.PartService;
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
public class PartServiceImpl implements PartService {

    private final PartRepository partRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final Validator validator;

    @Autowired
    public PartServiceImpl(PartRepository partRepository, ModelMapper modelMapper, Gson gson, Validator validator) {
        this.partRepository = partRepository;

        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.partRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(PathFiles.PARTS_PATH);
    }

    @Override
    public String importParts() throws IOException {
        String json = this.readPartsFileContent();

        ImportPartsDTO[] importPartsDTOS = this.gson.fromJson(json, ImportPartsDTO[].class);

        return Arrays.stream(importPartsDTOS)
                .map(this::importPart)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String importPart(ImportPartsDTO dto) {
        Set<ConstraintViolation<ImportPartsDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid part";
        }

        Optional<Part> optPart = this.partRepository.findByPartName(dto.getPartName());

        if (optPart.isPresent()) {
            return "Invalid part";
        }

        Part part = this.modelMapper.map(dto, Part.class);

        this.partRepository.save(part);

        return "Successfully imported part " + part.getPartName() + " - " + part.getPrice();
    }
}
