package e_voting_app.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class BeanConfig {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

}
