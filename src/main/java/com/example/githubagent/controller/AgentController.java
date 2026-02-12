package com.example.githubagent.controller;

import com.example.githubagent.orchestrator.ADKOrchestrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent")
public class AgentController {

    @Autowired
    ADKOrchestrator orchestrator;

    @GetMapping("/analyze")
    public String analyze(@RequestParam String repo,
                          @RequestParam String goal){

        return orchestrator.run(repo, goal);
    }
}