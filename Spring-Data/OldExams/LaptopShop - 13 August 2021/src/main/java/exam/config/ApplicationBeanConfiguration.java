package exam.config;

import com.google.gson.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper createModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Validator createValidator() {
        return Validation
                .buildDefaultValidatorFactory()
                .getValidator();
    }

    @Bean
    public Gson createGson() {
        final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        JsonDeserializer<LocalDate> toLocalTime =
                (json, t, c) -> LocalDate.parse(json.getAsString(), dateFormat);

        JsonSerializer<String> fromLocalTime =
                (date, t, c) -> new JsonPrimitive(date);

        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, toLocalTime)
                .registerTypeAdapter(LocalDate.class, fromLocalTime)
                .create();
    }
}
