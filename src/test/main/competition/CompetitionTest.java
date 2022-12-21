package main.competition;

import main.competitor.Competitor;
import main.mock.MockCompetition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class CompetitionTest
{
    protected Competition cmp;
    protected List<Competitor> competitors;
    protected Competitor c1;
    protected Competitor c2;
    protected Competitor c3;
    protected Competitor c4;
    protected Competitor c5;
    protected Competitor c6;
    protected Competitor c7;
    protected Competitor c8;

    protected abstract Competition createCompetition(List<Competitor> competitors);
    @BeforeEach
    public void init()
    {
        c1 = new Competitor("abir");
        c2 = new Competitor("theo");
        c3 = new Competitor("maeva");
        c4 = new Competitor("toto");
        c5 = new Competitor("louka");
        c6 = new Competitor("louise");
        c7 = new Competitor("julie");
        c8 = new Competitor("roro");
        this.competitors = new ArrayList<>();
        competitors.add(c1);
        competitors.add(c2);
        competitors.add(c3);
        competitors.add(c4);
        competitors.add(c5);
        competitors.add(c6);
        competitors.add(c7);
        competitors.add(c8);
        this.cmp = this.createCompetition(this.competitors);
    }

    /**
     * for test if this fonction call play(List<Competitor> l)
     */
    @Test
    public void playTest()
    {
        MockCompetition mc = new MockCompetition(competitors);
        assertEquals( 0,mc.flagPlay) ;
        mc.play();
        assertEquals(1 , mc.flagPlay) ;
    }

    /**
     * for test if ranking sort the map
     */
    @Test
    public void rankingTest()
    {
        Random random = new Random();
        for (Competitor c: cmp.competitors)
        {
            cmp.competitorsRanking.put(c, random.nextInt(20));
        }
        cmp.ranking();
        int tmp = -1;
        for (Map.Entry<Competitor,Integer> entry : cmp.competitorsRanking.entrySet())
        {
            if (tmp == -1)
            {
                tmp = entry.getValue();
            }
            assertTrue(tmp >= entry.getValue());
            tmp = entry.getValue();
        }
    }
}