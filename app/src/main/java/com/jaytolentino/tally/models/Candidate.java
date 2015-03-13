package com.jaytolentino.tally.models;

public class Candidate {
    private String name;
    private Party party;

    public Candidate(String name, Party party) {
        this.name = name;
        this.party = party;
    }

    public String getName() {
        return name;
    }
}