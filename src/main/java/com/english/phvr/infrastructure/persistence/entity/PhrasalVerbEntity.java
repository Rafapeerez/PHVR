package com.english.phvr.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collection = "verb")
public class PhrasalVerbEntity {

    @Id
    private String id;

    private String verb;

    private String meaning;

    private LocalDateTime creationDateTime;

    private List<String> examples;
}
