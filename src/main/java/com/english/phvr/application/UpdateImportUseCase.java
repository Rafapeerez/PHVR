package com.english.phvr.application;

import com.english.phvr.domain.models.Import;
import com.english.phvr.domain.repository.ImportPort;

public class UpdateImportUseCase {
    
    private ImportPort repository;

    public UpdateImportUseCase(ImportPort importRepository) {
        this.repository = importRepository;
    }

    public Import execute(Import importObject) {
        return repository.updateImport(importObject);
    }
}
