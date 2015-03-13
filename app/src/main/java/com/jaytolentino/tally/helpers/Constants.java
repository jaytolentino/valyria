package com.jaytolentino.tally.helpers;

import com.jaytolentino.tally.models.Candidate;
import com.jaytolentino.tally.models.Party;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final List<Candidate> MOCK_CANDIDATES = new ArrayList<Candidate>() {{
        add(new Candidate("Jeff Boss", Party.DEMOCRATS));
        add(new Candidate("Vermin Supreme", Party.DEMOCRATS));
        add(new Candidate("Robby Wells", Party.DEMOCRATS));
        add(new Candidate("Mark Everson", Party.REPUBLICANS));
        add(new Candidate("Jack Fellure", Party.DEMOCRATS));
    }};
}
