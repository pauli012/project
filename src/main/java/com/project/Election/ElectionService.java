package com.project.Election;

import com.project.Exception.DataException;
import com.project.Register.RegisterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<ElectionDTO> getAllElection() {
        List<ElectionDTO> e = new ArrayList<ElectionDTO>();
        for (Election iterElection : electionRepository.findAll()) {
            ModelMapper modelMapper = new ModelMapper();
            ElectionDTO eDTO = modelMapper.map(iterElection, ElectionDTO.class);
            e.add(eDTO);

        }
        return e;
    }

    public Map<String, Integer> getElection(int id) {
        Map map = new HashMap<>();

        map.put("firstProject", electionRepository.findById(id).orElse(null).getFirstPlace());
        map.put("secondProject", electionRepository.findById(id).orElse(null).getSecoundPlace());
        map.put("thirdProject", electionRepository.findById(id).orElse(null).getThirdPlace());
        return map;
    }

    public void addElection(Election election) throws DataException {
        if (registerRepository.findById(election.getToken()).orElse(null) == null) {
            throw new DataException("REGISTER TO ADD A VOTE!");
        }
        for (Election iterElection : electionRepository.findAll()) {
            if (election.getToken().equals(iterElection.getToken())) {
                throw new DataException("YOU HAVE BEEN VOTED!");
            }

        }

        electionRepository.save(election);

    }

}
