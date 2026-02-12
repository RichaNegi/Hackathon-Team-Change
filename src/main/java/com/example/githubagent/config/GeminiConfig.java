package com.example.githubagent.config;

import com.google.cloud.vertexai.VertexAI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Bean
    public VertexAI vertexAI() {
        return new VertexAI("YOUR_GCP_PROJECT_ID", "us-central1");
    }
}