package com.project.Election;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
@Entity
public class Election {


    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Integer id;
    @Getter @Setter private String firstPlace;
    @Getter @Setter private String secoundPlace;
    @Getter @Setter private String thirdPlace;
    @Getter @Setter private String token;

    public Election() {

    }

    public Election(int id, String firstPlace, String secoundPlace, String thirdPlace, String token) {
        super();
        this.id = id;
        this.firstPlace = firstPlace;
        this.secoundPlace = secoundPlace;
        this.thirdPlace = thirdPlace;
        this.token = token;
    }
}