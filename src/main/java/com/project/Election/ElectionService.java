package com.project.Election;

import com.project.DuplicatedDataException;
import com.project.Election.Election;
import com.project.Election.ElectionRepository;
import com.project.Register.Register;
import com.project.Register.RegisterRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Entity;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ElectionService {
    @Autowired

    private ElectionRepository electionRepository;
    @Autowired
    private RegisterRepository registerRepository;

    public ElectionService() {
    }

    public List<Election> getAllElection() {
        List<Election> e = new ArrayList<>();
        electionRepository.findAll()
                .forEach(e::add);
        return e;
    }

    public ResponseEntity<?> getElection(int id) {
        Map map = new HashMap<>();

        map.put("firstProject", electionRepository.findById(id).orElse(null).getFirstPlace());
        map.put("secondProject", electionRepository.findById(id).orElse(null).getSecoundPlace());
        return (new ResponseEntity<>(map, HttpStatus.OK));
    }

    public void addElection(Election election) throws DuplicatedDataException {
        if (registerRepository.findById(election.getPesel()).orElse(null) == null) {
            throw new DuplicatedDataException("REGISTER TO ADD A VOTE!");
        }
        for (Election iterElection : electionRepository.findAll()) {
            if (election.getPesel().equals(iterElection.getPesel())) {
                throw new DuplicatedDataException("YOU HAVE BEEN VOTED!");
            }

        }

        electionRepository.save(election);

    }

    public String getResults() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (Election iterElection : electionRepository.findAll()) {

            if (map.containsKey(iterElection.getFirstPlace())) {
                System.out.println(map.get(iterElection.getFirstPlace()));
                map.replace(iterElection.getFirstPlace(), map.get(iterElection.getFirstPlace()) + 3);
                System.out.println("!!3");
                System.out.println(map.get(iterElection.getFirstPlace()));
            }
            if (map.containsKey(iterElection.getSecoundPlace())) {
                map.replace(iterElection.getSecoundPlace(), map.get(iterElection.getSecoundPlace()) + 2);
                System.out.println("!!2");
            }
            if (map.containsKey(iterElection.getThirdPlace())) {
                map.replace(iterElection.getThirdPlace(), map.get(iterElection.getThirdPlace()) + 1);
                System.out.println("!!1");
            }
            System.out.println(iterElection.getFirstPlace());
            System.out.println(iterElection.getSecoundPlace());
            System.out.println(iterElection.getThirdPlace());
            if (!map.containsKey(iterElection.getFirstPlace())) {
                map.put(iterElection.getFirstPlace(), 3);
                System.out.println("3");
                System.out.println(map.get(iterElection.getFirstPlace()));
            }
            if (!map.containsKey(iterElection.getSecoundPlace())) {
                map.put(iterElection.getSecoundPlace(), 2);
                System.out.println("2");
            }
            if (!map.containsKey(iterElection.getThirdPlace())) {
                map.put(iterElection.getThirdPlace(), 1);
 
            }
            System.out.println(map);
        }
        return map.toString();

    }
}
