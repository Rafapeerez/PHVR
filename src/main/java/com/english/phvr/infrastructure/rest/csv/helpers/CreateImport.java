package com.english.phvr.infrastructure.rest.csv.helpers;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.english.phvr.domain.models.Import;
import com.english.phvr.domain.models.enums.ImportStatusEnum;

public class CreateImport {
    
    public static Import createImport(MultipartFile file) {
        return Import.builder()
            .id(UUID.randomUUID())
            .fileName(file.getOriginalFilename())
            .status(ImportStatusEnum.IN_PROGRESS)
            .startDateTime(LocalDateTime.now())
            .endDateTime(null)
            .summary(null)
        .build();
    }
}