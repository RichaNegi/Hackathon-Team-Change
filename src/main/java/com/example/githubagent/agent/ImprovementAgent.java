package com.example.githubagent.agent;

import org.springframework.stereotype.Service;

@Service
public class ImprovementAgent {

    public String generate(String analysis) {
        return "Suggested Improvements:\n" + analysis;
    }
}