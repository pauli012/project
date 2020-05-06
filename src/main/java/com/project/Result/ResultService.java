package com.project.Result;

import com.project.Election.Election;
import com.project.Election.ElectionRepository;
import com.project.Register.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResultService {
    @Autowired

    private ElectionRepository electionRepository;
    @Autowired
    private RegisterRepository registerRepository;

    public ResultService() {
    }


    public Map<String, Integer> getResults() {
        Map<String, Integer> map = new HashMap<>();
        for (Election iterElection : electionRepository.findAll()) {

            if (map.containsKey(iterElection.getFirstPlace())) {
                map.replace(iterElection.getFirstPlace(), map.get(iterElection.getFirstPlace()) + 3);
            } else {
                map.put(iterElection.getFirstPlace(), 3);
            }
            if (map.containsKey(iterElection.getSecoundPlace())) {
                map.replace(iterElection.getSecoundPlace(), map.get(iterElection.getSecoundPlace()) + 2);

            } else {
                map.put(iterElection.getSecoundPlace(), 2);
            }
            if (map.containsKey(iterElection.getThirdPlace())) {
                map.replace(iterElection.getThirdPlace(), map.get(iterElection.getThirdPlace()) + 1);
            } else {
                map.put(iterElection.getThirdPlace(), 1);
            }

        }
        return map;

    }
}
