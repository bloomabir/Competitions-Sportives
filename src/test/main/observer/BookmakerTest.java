package main.observer;
import org.junit.jupiter.api.Test;
import java.util.*;
import main.match.Match;
import main.competitor.Competitor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookmakerTest
{
    @Test
    public void creationBookmakerTest()
    {
        List<Competitor> competitors = new ArrayList<Competitor>();
        Competitor c1 = new Competitor("abir");
        Competitor c2 = new Competitor("theo");
        competitors.add(c1);
        competitors.add(c2);

        Bookmaker bookmaker1 = new Bookmaker("ParionsSport", competitors);
        Map<Competitor, Integer> cotes = new HashMap<Competitor, Integer>();
        for(Map.Entry<Competitor,Integer> entry : bookmaker1.displayCotes().entrySet())
        {
            assertEquals(entry.getValue(),2);
        }
    }

    @Test
    public void reactToMatchTest()
    {
        List<Competitor> competitors = new ArrayList<Competitor>();
        Competitor c1 = new Competitor("abir");
        Competitor c2 = new Competitor("theo");
        competitors.add(c1);
        competitors.add(c2);

        Bookmaker bookmaker1 = new Bookmaker("ParionsSport", competitors);
        Match m = new Match(c1, c2); //I don’t play the match to be sure c1 is the winner of the match (before the match c1 is the winner by default)
        bookmaker1.reactToMatch(m);
        Map<Competitor, Integer> cotes = new HashMap<Competitor, Integer>();
        cotes = bookmaker1.displayCotes();
        assertEquals(cotes.get(c1),1);
        assertEquals(cotes.get(c2),3);
    }

    @Test
    public void displayCotes()
    {
        List<Competitor> competitors = new ArrayList<Competitor>();
        Competitor c1 = new Competitor("abir");
        Competitor c2 = new Competitor("theo");
        Competitor c3 = new Competitor("maeva");
        Competitor c4 = new Competitor("ponyo");
        competitors.add(c1);
        competitors.add(c2);
        competitors.add(c3);
        competitors.add(c4);
        Bookmaker bookmaker1 = new Bookmaker("ParionsSport", competitors);
        Match m = new Match(c1, c2); //I don’t play the match to be sure c1 is the winner of the match (before the match c1 is the winner by default)
        bookmaker1.reactToMatch(m);
        m = new Match(c1, c3); //I don’t play the match to be sure c1 is the winner of the match (before the match c1 is the winner by default)
        bookmaker1.reactToMatch(m);
        m = new Match(c3, c4); //I don’t play the match to be sure c1 is the winner of the match (before the match c1 is the winner by default)
        bookmaker1.reactToMatch(m);
        int tmp = -1;
        for (Map.Entry<Competitor,Integer> entry : bookmaker1.displayCotes().entrySet())
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