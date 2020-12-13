package com.coursework.freelance.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "workers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String secondName;
    private String speciality;
    private Integer experience;
    private Integer ordersCompleted;
    private Double rating;
    private String email;
    private String phoneNumber;
    private String login;
    private String password;
    private String photoURL;
}
