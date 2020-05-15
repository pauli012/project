package com.project.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ResultController {
    @Autowired
    private ResultService resultService;

    @RequestMapping("/results")
    public Map<String,Integer> getResults() {
        return resultService.getResults();
    }
}

