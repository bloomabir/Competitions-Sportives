package main.mock;

import main.competition.Competition;
import main.competitor.Competitor;

import java.util.List;

public class MockCompetition extends Competition
{
    public int flagPlay;

    public MockCompetition(List<Competitor> competitors)
    {
        super(competitors);
        this.flagPlay = 0;
    }

    /**
     * the list of competitors sorted
     * @param l liste of Competitor registered as player in this Competition
     */
    public void play(List<Competitor> l)
    {
        flagPlay++;
    }

    public void playMatch(Competitor c1, Competitor c2)
    {
        System.out.println("abir");
    }
}