package com.book.javase;

public enum PowerState {
    ON("This Is ON"),
    OFF("This Is OFF"),
    SUSBEND("This Is SUSBEND");

    private String description;

    PowerState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
