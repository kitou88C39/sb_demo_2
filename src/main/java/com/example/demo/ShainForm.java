package com.example.demo;

import jakarta.validation.constraints.NotEmpty;

class ShainForm {

    @NotEmpty
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
