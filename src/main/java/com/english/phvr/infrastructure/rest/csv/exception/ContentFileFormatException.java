package com.english.phvr.infrastructure.rest.csv.exception;

public class ContentFileFormatException extends RuntimeException {

    private final String errorLine;

    public ContentFileFormatException(String message, String errorLine) {
        super(message);
        this.errorLine = errorLine;
    }

    public ContentFileFormatException(String message, Throwable cause, String errorLine) {
        super(message, cause);
        this.errorLine = errorLine;
    }

    public String getErrorLine() {
        return errorLine;
    }
}
