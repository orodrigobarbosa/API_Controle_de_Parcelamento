package com.AppControleParcelamento.AppControleParcelamentoapi.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean  //Indica que esse método será gerenciado pelo Spring com o uso desse bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
