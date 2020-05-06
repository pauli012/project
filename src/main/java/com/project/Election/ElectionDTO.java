package com.project.Election;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;


public class ElectionDTO {
    @Id
    @Getter @Setter private Integer id;
    @Getter @Setter private String firstPlace;
    @Getter @Setter private String secoundPlace;
    @Getter @Setter private String thirdPlace;


    public ElectionDTO(){

    }

    public ElectionDTO(int id, String firstPlace, String secoundPlace, String thirdPlace) {
        super();
        this.id = id;
        this.firstPlace = firstPlace;
        this.secoundPlace = secoundPlace;
        this.thirdPlace = thirdPlace;
    }
}
