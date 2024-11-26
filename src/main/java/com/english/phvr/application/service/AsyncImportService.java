package com.english.phvr.application.service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.english.phvr.application.SavePhrasalVerbUseCase;
import com.english.phvr.application.UpdateImportUseCase;
import com.english.phvr.domain.models.Import;
import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.domain.models.enums.ImportStatusEnum;

@Service
@Slf4j
@RequiredArgsConstructor
public class AsyncImportService {

    private final SavePhrasalVerbUseCase savePhrasalVerbUseCase;

    private final UpdateImportUseCase updateImportUseCase;

    @Async
    public CompletableFuture<Void> asyncProcess(Stream<PhrasalVerb> verbs, Import importObject) {
        return CompletableFuture.runAsync(() -> {

            verbs.forEach(savePhrasalVerbUseCase::execute);
            log.info("SavePhrasalVerbUseCase: {} verbs saved", verbs.toList().size());

            Map<String, String> importErrors = importObject.getSummary();
            final int totalRows = verbs.toList().size();
            ImportStatusEnum status = decideImportStatus(importErrors, totalRows);

            Import importToUpdate = Import.builder()
                .id(importObject.getId())
                .startDateTime(importObject.getStartDateTime())
                .endDateTime(LocalDateTime.now())
                .status(status)
                .summary(importErrors)
                .build();

            updateImportUseCase.execute(importToUpdate);
        });
    }

    private ImportStatusEnum decideImportStatus(Map<String, String> map, int totalRows) {
        ImportStatusEnum status;
        if (map.isEmpty()) {
            status = ImportStatusEnum.OK;
        } else if (map.size() < totalRows) {
            status = ImportStatusEnum.PARTIAL_OK;
        } else {
            status = ImportStatusEnum.CANCEL;
        }
        return status;
    }
}
