package com.english.phvr.domain.repository;

import java.util.List;

import com.english.phvr.domain.models.PhrasalVerb;

public interface PhrasalVerbRepository {
    List<PhrasalVerb> getPhrasalVerbs(int limit);
}
