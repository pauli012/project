package com.project.Register;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Register {
    @Id
    private String pesel;
    private String token;


    public Register() {

    }

        public String getPesel () {
            return pesel;
        }

        public void setPesel (String pesel){
            this.pesel = pesel;
        }

        public String getToken () {
            return token;
        }

        public void setToken (String token){
            this.token = token;
        }

    public Register(String pesel, String token) {
            super();
            this.pesel = pesel;
            this.token = token;

        }
    }
