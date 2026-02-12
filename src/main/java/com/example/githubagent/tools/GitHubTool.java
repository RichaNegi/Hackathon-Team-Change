package com.example.githubagent.tools;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Service
public class GitHubTool implements Tool {

    private final WebClient githubClient = WebClient.builder()
            .baseUrl("https://api.github.com")
            .defaultHeader("Authorization", "Bearer YOUR_GITHUB_TOKEN")
            .build();

    @Override
    public String getName() {
        return "github_tool";
    }

    @Override
    public Map<String, Object> execute(Map<String, Object> input) {

        String repo = input.get("repo").toString();

        List<Map> commits = githubClient.get()
                .uri("/repos/" + repo + "/commits")
                .retrieve()
                .bodyToFlux(Map.class)
                .collectList()
                .block();

        List<Map> pulls = githubClient.get()
                .uri("/repos/" + repo + "/pulls")
                .retrieve()
                .bodyToFlux(Map.class)
                .collectList()
                .block();

        return Map.of(
                "commits", commits,
                "pullRequests", pulls
        );
    }
}