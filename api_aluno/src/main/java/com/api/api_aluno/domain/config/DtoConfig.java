package com.api.api_aluno.domain.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.api.api_aluno.domain.dto.ResponseDto;

@Configuration
public class DtoConfig {
    
    @Bean
    public ResponseDto responseDto(){
        return new ResponseDto();
    }
}
