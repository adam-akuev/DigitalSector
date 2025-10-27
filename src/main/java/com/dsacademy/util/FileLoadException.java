package com.dsacademy.util;

public class FileLoadException extends RuntimeException {
    public FileLoadException(String message, Throwable e) {
        super(message, e);
    }
}
