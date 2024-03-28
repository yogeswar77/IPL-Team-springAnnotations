package com.example;

import java.util.HashMap;
import java.util.Map;

public class Team {
    private int id; 
    private Map<Integer, String> names = new HashMap<>();

    public Team() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, String> getNames() {
        return names;
    }

    public void setNames(Map<Integer, String> names) {
        this.names = names;
    }

    public void addName(int nameId, String name) {
        this.names.put(nameId, name);
    }

    @Override
    public String toString() {
        return "Team.No{" +
                "id=" + id +
                ", names=" + names +
                '}';
    }
}