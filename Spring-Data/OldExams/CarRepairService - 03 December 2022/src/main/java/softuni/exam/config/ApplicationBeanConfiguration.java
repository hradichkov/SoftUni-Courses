package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ApplicationBeanConfiguration {
    @Bean
    public Gson createGson() {
        return new GsonBuilder().create();
    }

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
}
