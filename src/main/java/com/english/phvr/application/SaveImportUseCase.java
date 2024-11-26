package com.english.phvr.application;

import com.english.phvr.domain.models.Import;
import com.english.phvr.domain.repository.ImportPort;

public class SaveImportUseCase {
    
    private ImportPort repository;

    public SaveImportUseCase(ImportPort importRepository) {
        this.repository = importRepository;
    }

    public Import execute(Import importObject) {
        return repository.saveImport(importObject);
    }
}
