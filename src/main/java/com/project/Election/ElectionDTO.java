package com.project.Election;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
public class ElectionDTO {
    @Id
    @Getter @Setter private Integer id;
    @Getter @Setter private String firstPlace;
    @Getter @Setter private String secoundPlace;
    @Getter @Setter private String thirdPlace;
}
