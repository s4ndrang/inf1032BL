package com.example.inf1032BL.service.impl;

import com.example.inf1032BL.service.StorageService;

import java.io.IOException;
import java.io.InputStream;

import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Service;

@Service
public class FirebaseStorageService implements StorageService {

    public static final String PHOTO_FOLDER = "photo/";
    private final FirebaseApp firebaseApp;

    public FirebaseStorageService(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    @Override
    public String upload(InputStream inputStream, String filename, String contentType) throws IOException {

        StorageClient storageClient = StorageClient.getInstance(firebaseApp);
        Bucket bucket = storageClient.bucket();

        bucket.create(
                PHOTO_FOLDER + filename,
                inputStream,
                contentType
        );
        //https://firebasestorage.googleapis.com/v0/b/inf1030tp.firebasestorage.app/o/photo%2F4bf741e7-2c93-43aa-acbc-d21c3e8a7b8e.jpg
        return "https://firebasestorage.googleapis.com/v0/b/" + bucket.getName() + "/o/photo%2F" + filename + "?alt=media";
    }

    public boolean delete(String filename) {
        Bucket bucket = StorageClient.getInstance().bucket();
        return bucket.get(PHOTO_FOLDER + filename).delete();
    }

}