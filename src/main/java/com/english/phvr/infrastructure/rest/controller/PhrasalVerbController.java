package com.english.phvr.infrastructure.rest.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.english.phvr.application.GetPhrasalVerbsToTestUseCase;
import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.infrastructure.rest.api.VerbsControllerApi;
import com.english.phvr.infrastructure.rest.dto.VerbDTO;
import com.english.phvr.infrastructure.rest.mapper.VerbDTOMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PhrasalVerbController implements VerbsControllerApi {

    private final GetPhrasalVerbsToTestUseCase getPhrasalVerbsToTestUseCase;

    @Override
    public ResponseEntity<List<VerbDTO>> getVerbs() {

        Stream<PhrasalVerb> verbsStream = getPhrasalVerbsToTestUseCase.execute(20).stream();
        List<VerbDTO> verbs = verbsStream.map(VerbDTOMapper::toVerbDTO).toList();

        return ResponseEntity.ok().body(verbs);
    }
}
