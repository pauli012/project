package com.project.Election;

import com.project.Exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ElectionController {
    @Autowired
    private ElectionService ElectionService;

    @RequestMapping("/election")
    public List<ElectionDTO> getAllElection() {
        return ElectionService.getAllElection();
    }

    @RequestMapping("/election/{id}")
    public Map<String,Integer> getElection(@PathVariable int id) {
        return ElectionService.getElection(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/election")
    public void addElection(@RequestBody Election election)  throws DataException {
        ElectionService.addElection(election);
    }

}

