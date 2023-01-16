package com.example.prove2022.test;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TestUser {
    @NotNull(message = "not null please")
    private String id;

    @NotEmpty(message = "not empty pleases")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
