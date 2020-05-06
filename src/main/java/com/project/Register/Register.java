package com.project.Register;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Register {
    @Id
    @Getter
    @Setter
    private String token;

    public Register() {

    }

    public Register(String token) {
        super();
        this.token = token;

    }
}
