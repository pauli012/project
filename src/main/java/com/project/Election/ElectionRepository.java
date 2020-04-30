package com.project.Election;


import com.project.Register.Register;
import org.springframework.data.repository.CrudRepository;

public interface ElectionRepository extends CrudRepository <Election, Integer>{
    // CrudRepository
    //getAllForms()
    // getForm()
    // updateForm(Form f)
    // deleteForm(String id)
}
