package com.english.phvr.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.english.phvr.domain.models.enums.ImportStatusEnum;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collection = "import")
public class ImportEntity {
    
    @Id
    private String id;

    String filename;

    ImportStatusEnum status;

    LocalDateTime startDateTime;
    
    LocalDateTime endDateTime;
    
    Integer totalRows;
    
    Map<String, String> summary;
}
