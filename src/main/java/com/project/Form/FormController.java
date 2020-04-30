package com.project.Form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormController {
    @Autowired
    private FormService FormService;

    @RequestMapping("/forms")
    public List<Form> getAllForms() {
        return FormService.getAllForms();
    }

    @RequestMapping("/forms/{id}")
    public Form getForm(@PathVariable String id) {
        return FormService.getForm(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/forms")
    public void addForm(@RequestBody Form Form) {
        FormService.addForm(Form);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/forms/{id}")
    public void addForm(@RequestBody Form Form, @PathVariable String id) {
        FormService.updateForm(id, Form);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/forms/{id}")
    public void addForm(@PathVariable String id) {
        FormService.deleteForm(id);
    }
}
