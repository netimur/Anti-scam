package com.example.antiscam.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Scammer {

    private final int id;
    private final String number;
    private final String initLink;

    public Scammer(int id, String number, String initLink) {
        this.id = id;
        this.number = number;
        this.initLink = initLink;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getInitLink() {
        return initLink;
    }
}
