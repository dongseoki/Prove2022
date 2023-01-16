package com.example.prove2022.test.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class TestProduct {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    public TestProduct() {

    }

    @Builder
    public TestProduct(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
