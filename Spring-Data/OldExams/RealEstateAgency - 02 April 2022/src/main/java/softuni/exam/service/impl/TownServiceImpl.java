package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportTownsDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static softuni.exam.util.PathFiles.TOWNS_PATH;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;
    private final Gson gson;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, Validator validator, Gson gson) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(TOWNS_PATH);
    }

    @Override
    public String importTowns() throws IOException {
        String json = this.readTownsFileContent();

        ImportTownsDTO[] importTownsDTOS = gson.fromJson(json, ImportTownsDTO[].class);

        return Arrays.stream(importTownsDTOS)
                .map(this::ImportTown)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String ImportTown(ImportTownsDTO dto) {
        Set<ConstraintViolation<ImportTownsDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid town";
        }

        Optional<Town> optTown = this.townRepository.findByTownName(dto.getTownName());

        if (optTown.isPresent()) {
            return "Invalid Town";
        }

        Town town = this.modelMapper.map(dto, Town.class);
        this.townRepository.save(town);

        return "Successfully imported town " + town.getTownName() + " - " + town.getPopulation();
    }
}
