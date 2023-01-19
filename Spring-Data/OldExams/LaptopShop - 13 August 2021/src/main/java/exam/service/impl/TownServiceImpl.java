package exam.service.impl;

import exam.model.dto.ImportTownDTO;
import exam.model.dto.ImportTownRootDTO;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.PathFiles;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;

    private final ModelMapper modelMapper;
    private final Validator validator;
    private final Unmarshaller unmarshaller;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, Validator validator) throws JAXBException {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;

        JAXBContext context = JAXBContext.newInstance(ImportTownRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(PathFiles.TOWNS_PATH);
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {
        ImportTownRootDTO importTownRootDTO = (ImportTownRootDTO) this.unmarshaller
                .unmarshal(new FileReader(PathFiles.TOWNS_PATH.toAbsolutePath().toFile()));

        return importTownRootDTO.getTowns()
                .stream()
                .map(this::importTown)
                .collect(Collectors.joining("\n"));
    }

    private String importTown(ImportTownDTO dto) {
        Set<ConstraintViolation<ImportTownDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid town";
        }

        Optional<Town> optTown = this.townRepository.findByName(dto.getName());

        if (optTown.isPresent()) {
            return "Invalid town";
        }

        Town town = this.modelMapper.map(dto, Town.class);
        this.townRepository.save(town);

        return "Successfully imported Town " + town.getName();
    }
}
