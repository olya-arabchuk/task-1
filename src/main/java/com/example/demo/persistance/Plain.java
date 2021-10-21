package com.example.demo.persistance;

import java.io.Serializable;

public class Plain implements Serializable {

    private int id;

    private String name;

    private String type;

    private String route;

    private int year;


    public Plain(int id, String name, String type, String route, int year) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.route = route;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
