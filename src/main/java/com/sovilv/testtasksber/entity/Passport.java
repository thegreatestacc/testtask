package com.sovilv.testtasksber.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long passportId;
    private String passportSerial;
    private String passportNumber;
    private String registration;

    @OneToOne
    @JoinColumn(name = "personId")
    private Person person;
}
