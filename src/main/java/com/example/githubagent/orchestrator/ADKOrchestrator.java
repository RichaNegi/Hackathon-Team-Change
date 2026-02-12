package com.example.githubagent.orchestrator;

import com.example.githubagent.agent.FunctionalAgent;
import com.example.githubagent.agent.ImprovementAgent;
import com.example.githubagent.agent.PlannerAgent;
import com.example.githubagent.tools.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ADKOrchestrator {

    @Autowired
    PlannerAgent planner;

    @Autowired
    List<Tool> tools;

    @Autowired
    FunctionalAgent functional;

    @Autowired
    ImprovementAgent improvement;

    public String run(String repo, String goal) {

        List<String> plan = planner.plan(goal);

        Map<String,Object> context = new HashMap<>();
        context.put("repo", repo);

        for(String step : plan){

            Tool tool = tools.stream()
                    .filter(t -> t.getName().equals(step))
                    .findFirst()
                    .orElseThrow();

            context.putAll(tool.execute(context));
        }

        String analysis = functional.analyze(context);

        return improvement.generate(analysis);
    }
}