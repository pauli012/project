package com.project.Register;

import com.project.DuplicatedDataException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    public Register getRegister(String id) {

        return registerRepository.findById(id).orElse(null);
    }


    public void addRegister(Register r) throws DuplicatedDataException {
        List<Register> registers = new ArrayList<>();
        for (Register register : registerRepository.findAll()) {
            if (r.getPesel().equals(register.getPesel())) {
                throw new DuplicatedDataException("THIS PESEL EXISTS");
            }
        }
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String token = RandomStringUtils.random(length, useLetters, useNumbers);
        r.setToken(token);
        registerRepository.save(r);

    }

    public void deleteRegister(String id) {
        //registerRepository.delete(id);
    }

    public List<Register> getAllRegister() {
        List<Register> registers = new ArrayList<>();
        registerRepository.findAll()
                .forEach(registers::add);
        return registers;

    }
}
