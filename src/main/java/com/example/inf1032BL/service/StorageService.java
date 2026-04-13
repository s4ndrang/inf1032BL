package com.example.inf1032BL.service;

import java.io.IOException;
import java.io.InputStream;

public interface StorageService {
    String upload(InputStream inputStream, String filename, String contentType) throws IOException;
    boolean delete(String filename);
    }
