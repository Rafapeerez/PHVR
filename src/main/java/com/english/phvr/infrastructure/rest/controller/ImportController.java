package com.english.phvr.infrastructure.rest.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

import javax.management.RuntimeErrorException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.english.phvr.application.SaveImportUseCase;
import com.english.phvr.application.service.AsyncImportService;
import com.english.phvr.domain.models.Import;
import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.infrastructure.rest.api.ImportsControllerApi;
import com.english.phvr.infrastructure.rest.csv.ReadCsvFile;
import com.english.phvr.infrastructure.rest.csv.helpers.CreateImport;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ImportController implements ImportsControllerApi {

    private final SaveImportUseCase saveImportUseCase;

    private final AsyncImportService asyncImportService;

    @Override
    public ResponseEntity<String> uploadPhrasalVerbs(MultipartFile file) {
        Stream<PhrasalVerb> verbs = Stream.empty();
        Import importObject = CreateImport.createImport(file);

        saveImportUseCase.execute(importObject);

        try (InputStream inputStream = file.getInputStream()) {
            verbs = ReadCsvFile.readInformation(inputStream, importObject);
        } catch (IOException e) {
            log.error("ERROR: {}", e.getMessage());
            throw new RuntimeErrorException(null);
        }
        asyncImportService.asyncProcess(verbs, importObject);

        return ResponseEntity.accepted().body(importObject.getId().toString());
    }
}
