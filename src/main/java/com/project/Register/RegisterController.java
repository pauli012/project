package com.project.Register;

import com.project.Exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @RequestMapping("/registers")
    public List<Register> getAllRegister() {
        return registerService.getAllRegister();
    }

    @RequestMapping("/register/{id}")
    public Register getRegister(@PathVariable String id) {
        return registerService.getRegister(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String getRegister() throws DataException {
        return registerService.addRegister();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/register/{id}")
    public void deleteRegister(@PathVariable String id) {
        registerService.deleteRegister(id);
    }
}
