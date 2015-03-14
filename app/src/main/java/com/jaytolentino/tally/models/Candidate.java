package com.jaytolentino.tally.models;

import java.io.Serializable;

public class Candidate implements Serializable {
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