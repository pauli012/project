package com.project.Form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;

    private List<Form> forms = new ArrayList<>(Arrays.asList(
            new Form("1", "Ola", "12345678", "123456789"),
            new Form("2", "Jadzia", "666666", "123456789"),
            new Form("3", "Wiesia", "102938475", "123456789")
    ));
    public List<Form> getAllForms(){
        List <Form> forms = new ArrayList<>();
        formRepository.findAll()
        .forEach(forms::add);
        return forms;
    }
    public Form getForm(String id) {

        return formRepository.findById(id).orElse(null);
    }
    public void addForm(Form form) {
        formRepository.save(form);

    }
    public void updateForm(String id, Form Form) {
        for (int i = 0; i < forms.size(); i++) {
            Form t = forms.get(i);
            if(t.getId().equals(id)) {
                forms.set(i, Form);
                return;
            }
        }

    }
    public void deleteForm(String id) {
        for (int i = 0; i < forms.size(); i++) {
            Form t = forms.get(i);
            if(t.getId().equals(id)) {
                forms.remove(i);
                return;
            }
        }
    }
}
