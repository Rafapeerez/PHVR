package com.english.phvr.domain.models;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import com.english.phvr.domain.models.enums.ImportStatusEnum;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
@Getter
public class Import {

    UUID id;
    String fileName;
    ImportStatusEnum status;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;
    Integer totalRows;
    Map<String, String> summary;

}
