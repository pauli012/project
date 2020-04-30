package com.project.Register;

import com.project.DuplicatedDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService RegisterService;

    @RequestMapping("/register")
    public List<Register> getAllRegister() {
        return RegisterService.getAllRegister();
    }

    @RequestMapping("/register/{id}")
    public Register getRegister(@PathVariable String id) {
        return RegisterService.getRegister(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public void addRegister(@RequestBody Register register) throws DuplicatedDataException {
        RegisterService.addRegister(register);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/register/{id}")
    public void deleteRegister(@PathVariable String id) {
        RegisterService.deleteRegister(id);
    }
}
