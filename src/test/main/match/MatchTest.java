package main.match;

import main.competitor.Competitor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    @Test
    void creationMatchTest() {
        Competitor c1 = new Competitor("abir");
        Competitor c2 = new Competitor("theo");
        Match m = new Match(c1, c2);
        assertEquals(m.getWinner().getName(), c1.getName());
        assertEquals(m.getLooser().getName(), c2.getName());
    }

    @Test
    void playMatchTest() {
        Competitor c1 = new Competitor("abir");
        Competitor c2 = new Competitor("theo");
        Match m = new Match(c1, c2);
        m.playMatch();
        assertTrue((m.getWinner() == c1 && m.getLooser() == c2) || (m.getWinner() == c2 && m.getLooser() == c1));
    }
}