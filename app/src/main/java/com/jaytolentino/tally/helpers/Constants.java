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
                "Conspiracy Theorist",
                "http://upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Jeff_Boss.jpg/200px-Jeff_Boss.jpg",
                "New Jersey"));
        add(new Candidate(
                "Vermin Supreme",
                Party.DEMOCRATS,
                "Performance Artist",
                "http://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Vermin_Supreme_2012.jpg/200px-Vermin_Supreme_2012.jpg",
                "Massachusetts"));
        add(new Candidate(
                "Robby Wells",
                Party.DEMOCRATS,
                "Former Head Football Coach",
                "http://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Robby_Wells.PNG/200px-Robby_Wells.PNG",
                "Georgia"));
        add(new Candidate(
                "Mark Everson",
                Party.REPUBLICANS,
                "Former IRS Comissioner",
                "http://upload.wikimedia.org/wikipedia/commons/thumb/9/99/MarkEverson.jpg/200px-MarkEverson.jpg",
                "Mississippi"));
        add(new Candidate(
                "Jack Fellure",
                Party.REPUBLICANS,
                "Retired Engineer",
                "http://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Jack_Fellure.jpg/200px-Jack_Fellure.jpg",
                "West Virginia"));
        add(new Candidate(
                "Jim Webb",
                Party.DEMOCRATS,
                "Former US Senator",
                "http://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Jim_Webb_official_110th_Congress_photo.jpg/440px-Jim_Webb_official_110th_Congress_photo.jpg",
                "Virginia"));
        add(new Candidate(
                "Dr. Ben Carson",
                Party.REPUBLICANS,
                "Former Neurosurgeon",
                "http://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/Ben_Carson_by_Gage_Skidmore_3.jpg/440px-Ben_Carson_by_Gage_Skidmore_3.jpg",
                "Michigan"));
    }};
}
