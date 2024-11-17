package com.english.phvr.domain.repository;

import java.util.List;

import com.english.phvr.domain.models.PhrasalVerb;

public interface PhrasalVerbPort {
    List<PhrasalVerb> getPhrasalVerbs(int limit);

    void insertPhrasalVerb(PhrasalVerb verbs);
}
