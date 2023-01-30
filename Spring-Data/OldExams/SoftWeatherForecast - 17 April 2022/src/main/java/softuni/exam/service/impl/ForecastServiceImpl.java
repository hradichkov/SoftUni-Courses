package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ImportForecastDTO;
import softuni.exam.models.dto.ImportForecastRootDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DayOfWeek;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static softuni.exam.util.PathFiles.FORECASTS_PATH;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final Unmarshaller unmarshaller;
    private final ModelMapper modelMapper;
    private final Validator validator;

    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, ModelMapper modelMapper, Validator validator) throws JAXBException {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;

        JAXBContext context = JAXBContext.newInstance(ImportForecastRootDTO.class);
        this.unmarshaller = context.createUnmarshaller();
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(FORECASTS_PATH);
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        ImportForecastRootDTO forecastDTOs = (ImportForecastRootDTO) this.unmarshaller
                .unmarshal(new FileReader(FORECASTS_PATH.toAbsolutePath().toString()));

        return forecastDTOs.getForecasts()
                .stream()
                .map(this::importForecast)
                .collect(Collectors.joining("\n"));
    }

    private String importForecast(ImportForecastDTO dto) {
        Set<ConstraintViolation<ImportForecastDTO>> errors =
                this.validator.validate(dto);

        if (!errors.isEmpty()) {
            return "Invalid forecast";
        }

        Optional<Forecast> optForecast =
                this.forecastRepository.findByCity_IdAndDayOfWeek(dto.getCity(), dto.getDayOfWeek());

        if (optForecast.isPresent()) {
            return "Invalid forecast";
        }

        Forecast forecast = this.modelMapper.map(dto, Forecast.class);
        Optional<City> city = this.cityRepository.findById(dto.getCity());

        forecast.setCity(city.get());

        this.forecastRepository.save(forecast);

        return "Successfully import forecast " + forecast.getDayOfWeek() + " - " + forecast.getMaxTemperature();
    }

    @Override
    public String exportForecasts() {
        List<Forecast> forecasts =
                this.forecastRepository
                        .findByDayOfWeekAndCityPopulationLessThanOrderByMaxTemperatureDescIdAsc(DayOfWeek.SUNDAY, 150000);

        return forecasts
                .stream()
                .map(Forecast::toString)
                .collect(Collectors.joining("\n"));
    }
}
