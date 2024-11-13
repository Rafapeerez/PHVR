package com.english.phvr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.english.phvr.application.GetPhrasalVerbsToTestUseCase;
import com.english.phvr.domain.repository.PhrasalVerbPort;

@Configuration
public class ApplicationConfig {

    @Autowired
    PhrasalVerbPort phrasalVerbRepository;

    @Bean
    public GetPhrasalVerbsToTestUseCase getPhrasalVerbsToTestUseCase() {
        return new GetPhrasalVerbsToTestUseCase(phrasalVerbRepository);
    }
}
