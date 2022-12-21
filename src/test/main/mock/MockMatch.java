package main.mock;

import main.competition.Competition;
import main.competitor.Competitor;
import main.match.Match;

import java.util.List;

public class MockMatch extends Match {
    public int flagPlay = 0;

    public MockMatch(Competitor c1, Competitor c2) {
        super(c1, c2);
    }


    public void playMatch(Competitor c1, Competitor c2) {
        flagPlay++;
    }
}
