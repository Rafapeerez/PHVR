package com.english.phvr.infrastructure.rest.csv.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class CsvFileLoader {

    private final ResourceLoader resourceLoader;

    public CsvFileLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public BufferedReader loadCsvFile(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + filePath);
        InputStream inputStream = resource.getInputStream();
        return new BufferedReader(new InputStreamReader(inputStream));
    }

}