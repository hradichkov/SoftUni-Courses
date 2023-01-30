package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportCitiesDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static softuni.exam.util.PathFiles.CITIES_PATH;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    private final Validator validator;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, Validator validator, ModelMapper modelMapper, Gson gson) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;

        this.validator = validator;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(CITIES_PATH);
    }

    @Override
    public String importCities() throws IOException {
        String json = this.readCitiesFileContent();

        ImportCitiesDTO[] importCitiesDTOs = this.gson.fromJson(json, ImportCitiesDTO[].class);

        return Arrays.stream(importCitiesDTOs)
                .map(this::importCity)
                .collect(Collectors.joining("\n"));
    }

    private String importCity(ImportCitiesDTO dto) {
        Set<ConstraintViolation<ImportCitiesDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid city";
        }

        Optional<City> optCity = this.cityRepository.findByCityName(dto.getCityName());

        if (optCity.isPresent()) {
            return "Invalid city";
        }

        Optional<Country> country = this.countryRepository.findById(dto.getCountry());

        City city = this.modelMapper.map(dto, City.class);

        city.setCountry(country.get());
        this.cityRepository.save(city);

        return "Successfully imported city " + city.getCityName() + " - " + city.getPopulation();
    }
}
