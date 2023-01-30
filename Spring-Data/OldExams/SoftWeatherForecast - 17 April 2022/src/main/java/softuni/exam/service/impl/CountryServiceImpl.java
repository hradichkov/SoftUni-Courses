package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCountriesDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static softuni.exam.util.PathFiles.COUNTRIES_PATH;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    private final Validator validator;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public CountryServiceImpl(CountryRepository countryRepository, Validator validator, ModelMapper modelMapper, Gson gson) {
        this.countryRepository = countryRepository;
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(COUNTRIES_PATH);
    }

    @Override
    public String importCountries() throws IOException {
        String json = this.readCountriesFromFile();

        ImportCountriesDTO[] importCountriesDTOs = this.gson.fromJson(json, ImportCountriesDTO[].class);

        return Arrays.stream(importCountriesDTOs)
                .map(this::importCountry)
                .collect(Collectors.joining("\n"));
    }

    private String importCountry(ImportCountriesDTO dto) {
        Set<ConstraintViolation<ImportCountriesDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid country";
        }

        Optional<Country> optCountry = this.countryRepository.findByCountryName(dto.getCountryName());

        if (optCountry.isPresent()) {
            return "Invalid country";
        }

        Country country = this.modelMapper.map(dto, Country.class);
        this.countryRepository.save(country);

        return "Successfully imported country " + country.getCountryName() + " - " + country.getCurrency();
    }
}
