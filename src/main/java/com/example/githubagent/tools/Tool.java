package com.example.githubagent.tools;

import java.util.Map;

public interface Tool {
    String getName();
    Map<String,Object> execute(Map<String,Object> input);
}