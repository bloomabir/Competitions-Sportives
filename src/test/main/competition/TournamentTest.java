package main.competition;

import main.competitor.Competitor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TournamentTest extends CompetitionTest{
    /**
     * Factory methode (to have the right instance in super class tests)
     * @param competitors list of competitors registered the tournament
     * @return instance of tournament
     */
    protected Competition createCompetition(List<Competitor> competitors)
    {
        return new Tournament(competitors);
    }

    /**
     * for test if this methode make a right tournament with the right number of point
     */
    @Test
    @Override
    public void playTest()
    {
        Tournament t = new Tournament(competitors);
        t.play();
        Map<Competitor,Integer> m;
        m = t.ranking();
        assertEquals(competitors.size(),m.size());
        int point = 0;
        for (Map.Entry<Competitor,Integer> entry : m.entrySet())
        {
            point += entry.getValue();
        }
        int poule = m.size();
        int bonNombrePoint = 0;
        while(poule >= 2)
        {
            poule = poule / 2 ;
            bonNombrePoint += poule;
        }
        assertEquals(point, bonNombrePoint);
    }

    /**
     * for test if playMatch make match, nominates a winner and give the right number of point to the winner
     */
    @Test
    public void playMatchTest()
    {

        List<Competitor> l = new ArrayList<>();
        l.add(c1);
        l.add(c2);
        Tournament t = new Tournament(l);
        t.playMatch(c1, c2);
        Map<Competitor,Integer> result;
        result = t.ranking();
        int i = 1;
        for (Map.Entry<Competitor, Integer> entry : result.entrySet())
        {
            assertEquals(entry.getValue(),i);
            i -= 1;
        }
    }
}