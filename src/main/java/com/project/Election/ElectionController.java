package com.project.Election;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.DuplicatedDataException;
import com.project.Form.Form;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ElectionController {
    @Autowired
    private ElectionService ElectionService;

    //@RequestMapping("/election")
    //public List<Election> getAllElection() {
    //    return ElectionService.getAllElection();
   // }

    @RequestMapping("/election/{id}")
    public ResponseEntity<?> getElection(@PathVariable int id) {
        return ElectionService.getElection(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/election")
    public void addElection(@RequestBody Election election)  throws DuplicatedDataException {
        ElectionService.addElection(election);
    }
    @RequestMapping("/election")
    public String getAllElection() {
        return ElectionService.getResults();
    }
}

