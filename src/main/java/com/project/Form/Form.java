package com.project.Form;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
@Entity
public class Form {
    @Id
    @Getter @Setter private String id;
    @Getter @Setter private String name;
    @Getter @Setter private String nip;
    @Getter @Setter private String tel;

    public Form() {

    }
    public Form(String id, String name, String nip, String tel) {
        super();
        this.id = id;
        this.name = name;
        this.nip = nip;
        this.tel = tel;
    }

}
