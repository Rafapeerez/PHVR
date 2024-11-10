package com.english.phvr.domain.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.Builder;

@Builder
public class Verb {
    
    UUID id;
    String verb;
    String meaning;
    LocalDateTime creationDateTime;
    List<String> examples;

}
