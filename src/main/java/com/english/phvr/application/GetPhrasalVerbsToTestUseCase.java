package com.english.phvr.application;

import java.util.List;

import com.english.phvr.domain.models.PhrasalVerb;
import com.english.phvr.infrastructure.persistence.repository.PhrasalVerbAdapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetPhrasalVerbsToTestUseCase {

    private PhrasalVerbAdapter adapter;

    List<PhrasalVerb> execute(int limit) {
        return adapter.getPhrasalVerbs(limit);
    }
}
