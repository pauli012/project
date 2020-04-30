package com.project.Election;

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
    private Integer id;
    private String firstPlace;
    private String secoundPlace;
    private String thirdPlace;
    private String pesel;

    public Election() {

    }
    public Election(int id, String firstPlace,String secoundPlace, String thirdPlace, String pesel) {
        super();
        this.id = id;
        this.firstPlace = firstPlace;
        this.secoundPlace = secoundPlace;
        this.thirdPlace = thirdPlace;
        this.pesel = pesel;
    }
    public String getPesel() {
        return pesel;
    }

    public String getFirstPlace() {
        return firstPlace;
    }

    public String getSecoundPlace() {
        return secoundPlace;
    }

    public String getThirdPlace() {
        return thirdPlace;
    }

}
