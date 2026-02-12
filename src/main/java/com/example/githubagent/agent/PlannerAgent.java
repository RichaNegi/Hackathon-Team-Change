package com.example.githubagent.agent;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.GenerateContentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlannerAgent {

    private final GenerativeModel model;

    public PlannerAgent(VertexAI vertexAI) {
        this.model = new GenerativeModel("gemini-1.5-pro", vertexAI);
    }

    public List<String> plan(String goal) {

        String prompt = "You are an ADK planner. Goal: " + goal +
                ". Available tools: github_tool. Return JSON {\"plan\":[\"tool_name\"]}";

        try {

            GenerateContentResponse response = model.generateContent(prompt);

            String text = response.getCandidates()
                    .get(0)
                    .getContent()
                    .getParts()
                    .get(0)
                    .getText();

            ObjectMapper mapper = new ObjectMapper();
            Map result = mapper.readValue(text, Map.class);

            return (List<String>) result.get("plan");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}