package com.company;

import com.company.Driver;
import com.company.State;

public class Truck {
    private int id;
    private String name;
    private Driver driver;
    private State state;


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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver drive) {
        this.driver = drive;
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", drive=" + driver +
                ", state=" + state +
                '}';
    }
}
