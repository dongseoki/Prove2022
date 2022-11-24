package com.example.prove2022.test;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue
    private Long id;
    private String value;
}