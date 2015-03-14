package com.jaytolentino.tally.models;

public class Candidate {
    private String name;
    private String imageUrl;
    private Party party;

    public Candidate(String name, Party party, String imageUrl) {
        this.name = name;
        this.party = party;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public Party getParty() {
        return party;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}