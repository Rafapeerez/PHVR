package com.english.phvr.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;

@Builder
@Document(collection = "verb")
public class VerbEntity {
    
    @Id
    private String id;

    private String verb;
    
    private String meaning;
    
    private LocalDateTime creationDateTime;
    
    private List<String> examples;
}
