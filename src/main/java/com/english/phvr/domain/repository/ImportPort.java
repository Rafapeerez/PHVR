package com.english.phvr.domain.repository;

import com.english.phvr.domain.models.Import;

public interface ImportPort {

    public Import saveImport(Import importObject);

    public Import updateImport(Import importObject);

}
