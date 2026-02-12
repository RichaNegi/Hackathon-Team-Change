package com.example.githubagent.agent;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FunctionalAgent {

    public String analyze(Map context) {
        return "AI Functional Analysis based on context: " + context.toString();
    }
}