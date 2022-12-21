package main.mock;

import main.competition.League;
import main.competitor.Competitor;

import java.util.List;

public class MockLeague extends League {
    public int flagPlay = 0;

    public MockLeague(List<Competitor> competitors) {
        super(competitors);
    }


    @Override
    public void playMatch(Competitor c1, Competitor c2) {
        // someone has to win
        this.competitorsRanking.put(c1, this.competitorsRanking.get(c1) + 1);
        flagPlay++;
    }
}
