package com.english.phvr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.english.phvr.application.GetPhrasalVerbsToTestUseCase;
import com.english.phvr.application.SaveImportUseCase;
import com.english.phvr.application.SavePhrasalVerbUseCase;
import com.english.phvr.domain.repository.ImportPort;
import com.english.phvr.domain.repository.PhrasalVerbPort;

@Configuration
public class ApplicationConfig {

    @Autowired
    PhrasalVerbPort phrasalVerbRepository;

    @Autowired
    ImportPort importRepository;

    @Bean
    public GetPhrasalVerbsToTestUseCase getPhrasalVerbsToTestUseCase() {
        return new GetPhrasalVerbsToTestUseCase(phrasalVerbRepository);
    }

    @Bean
    public SavePhrasalVerbUseCase savePhrasalVerbUseCase() {
        return new SavePhrasalVerbUseCase(phrasalVerbRepository);
    }

    @Bean
    public SaveImportUseCase saveImportUseCase() {
        return new SaveImportUseCase(importRepository);
    }
}
