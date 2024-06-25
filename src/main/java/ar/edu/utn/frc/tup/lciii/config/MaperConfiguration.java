package ar.edu.utn.frc.tup.lciii.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //Indica que la clase tiene metodos que levantan beans

public class MaperConfiguration {

//    @Bean("modelMapper")
//    public ModelMapper modelMaper(){
//        return new ModelMapper();
//    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean("Merge Mapper")
    public ModelMapper mergeMaper(){
        ModelMapper mapper = new ModelMapper();

        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());

        return mapper;
    }

    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
