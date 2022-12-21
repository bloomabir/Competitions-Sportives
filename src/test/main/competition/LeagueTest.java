package main.competition;

import main.competitor.Competitor;
import main.mock.MockLeague;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTest extends CompetitionTest{

    protected Competition createCompetition(List<Competitor> competitors)
    {
        return new League(competitors);
    }


    @Override
    @Test
    public void playTest() {
        MockLeague mc = new MockLeague(competitors);

        mc.play(competitors);

        assertEquals(calculateNumberOfMatches(competitors.size()), mc.flagPlay);
    }

    private int calculateNumberOfMatches(int n) {
        return (n - 1) * n;
    }
    @Test
    public void playMatchTest()
    {

        List<Competitor> participant = new ArrayList<>();
        participant.add(c1);
        participant.add(c2);
        League l = new League(participant);
        l.playMatch(c1, c2);
        Map<Competitor,Integer> result;
        result = l.ranking();
        int i = 1;
        for (Map.Entry<Competitor, Integer> entry : result.entrySet())
        {
            assertEquals(entry.getValue(),i);
            i -= 1;
        }
    }
}
    /*
    @Test
    void testPlayCalled6TimesForThreeCompetitors() {

        Competitor c1 = new Competitor("abir");
        Competitor c2 = new Competitor("theo");
        Competitor c3 = new Competitor("mehdi");
        League ml = new MockLeague(List.of(c1,c2,c3));
        ml.play();
        assertEquals(6, ml.);

        MockLeague mockLeague = new MockLeague(List.of(c1,c2));
        mockLeague.play();

        MockMatch mockMatch = new MockMatch(c1,c2);
        mockMatch.playMatch();
        assertEquals(2,mockMatch.playMatchCalled);
    }
*/
