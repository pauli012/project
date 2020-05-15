package com.project.Register;

import com.project.Exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    public Register getRegister(String id) {

        return registerRepository.findById(id).orElse(null);
    }


    public String addRegister() throws DataException {

        final String token = UUID.randomUUID().toString();
        for (Register register : registerRepository.findAll()) {
            if (token.equals(register.getToken())) {
                // rzucam wyjątkiem, zamiast generować nowy token, żeby użyć wyjątku
                throw new DataException("THIS TOKEN EXISTS, GENERATE AGAIN");
            }
        }
        Register r = new Register(token);
        registerRepository.save(r);
        return token;

    }

    public void deleteRegister(String id) {
        //registerRepository.delete(id);
    }

    public List<Register> getAllRegister() {
        return (List<Register>) registerRepository.findAll();
    }
}
