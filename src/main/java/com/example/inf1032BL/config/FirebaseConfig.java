package com.example.inf1032BL.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PublicKey;

@Configuration
public class FirebaseConfig {

    @Bean
    public GoogleCredentials googleCredentials() throws IOException {
        String json = System.getenv("GOOGLE_CREDENTIALS");

        if (json == null || json.isEmpty()) {
            throw new IllegalStateException("GOOGLE_CREDENTIALS env variable not set");
        }

        return GoogleCredentials.fromStream(
                new ByteArrayInputStream(json.getBytes())
        );
    }

    @Bean
    public FirebaseApp firebaseApp() throws Exception {

        GoogleCredentials credentials = googleCredentials();
        /*InputStream serviceAccount =
                getClass().getClassLoader()
                        .getResourceAsStream("serviceAccountKey.json");

        if (serviceAccount == null) {
            throw new IllegalStateException("Firebase service account file not found in resources");
        }*/

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                //.setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setStorageBucket("inf1030tp.firebasestorage.app")
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            return FirebaseApp.initializeApp(options);
        } else {
            return FirebaseApp.getInstance();
        }
    }
}