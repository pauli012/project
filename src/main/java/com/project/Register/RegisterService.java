package com.project.Register;

import com.project.Exception.DataException;
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


    public String addRegister() throws DataException {
        Register r = new Register();
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String token = RandomStringUtils.random(length, useLetters, useNumbers);
        for (Register register : registerRepository.findAll()) {
            if (token.equals(register.getToken())) {
                // rzucam wyjątkiem, zamiast generować nowy token, żeby użyć wyjątku
                throw new DataException("THIS TOKEN EXISTS, GENERATE AGAIN");
            }
        }
        r.setToken(token);
        registerRepository.save(r);
        return token;

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
