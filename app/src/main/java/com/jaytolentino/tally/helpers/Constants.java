package com.jaytolentino.tally.helpers;

import com.jaytolentino.tally.models.Candidate;
import com.jaytolentino.tally.models.Party;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final List<Candidate> MOCK_CANDIDATES = new ArrayList<Candidate>() {{
        add(new Candidate(
                "Jeff Boss",
                Party.DEMOCRATS,
                "http://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Jeff_Boss.jpg/200px-Jeff_Boss.jpg"));
        add(new Candidate(
                "Vermin Supreme",
                Party.DEMOCRATS,
                "http://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Vermin_Supreme_2012.jpg/200px-Vermin_Supreme_2012.jpg"));
        add(new Candidate(
                "Robby Wells",
                Party.DEMOCRATS,
                "http://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Robby_Wells.PNG/200px-Robby_Wells.PNG"));
        add(new Candidate(
                "Mark Everson",
                Party.REPUBLICANS,
                "http://upload.wikimedia.org/wikipedia/commons/thumb/9/99/MarkEverson.jpg/200px-MarkEverson.jpg"));
        add(new Candidate(
                "Jack Fellure",
                Party.REPUBLICANS,
                "http://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Jack_Fellure.jpg/200px-Jack_Fellure.jpg"));
    }};
}
