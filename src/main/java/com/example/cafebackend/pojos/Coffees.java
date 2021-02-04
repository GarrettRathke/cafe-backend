package com.example.cafebackend.pojos;

public class Coffees {
    
    public Coffees(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Coffees() {}

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
