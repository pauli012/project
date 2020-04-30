package com.project.Form;

import javax.persistence.Entity;
import javax.persistence.Id;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
@Entity
public class Form {
    @Id
    private String id;
    private String name;
    private String nip;
    private String tel;

    public Form() {

    }
    public Form(String id, String name, String nip, String tel) {
        super();
        this.id = id;
        this.name = name;
        this.nip = nip;
        this.tel = tel;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNip() {
        return nip;
    }
    public void setDescription(String nip) {
        this.nip = nip;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

}
