package com.jaytolentino.tally.models;

import java.io.Serializable;

public class Candidate implements Serializable {
    private String name;
    private String imageUrl;
    private Party party;
    private String title;
    private String state;

    public Candidate(String name, Party party, String title, String imageUrl, String state) {
        this.name = name;
        this.party = party;
        this.title = title;
        this.imageUrl = imageUrl;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public Party getParty() {
        return party;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getState() {
        return state;
    }
}