package main.selectionStrategy;

import main.competition.Tournament;
import org.junit.jupiter.api.Test;
import main.observer.MatchObserver;
import main.observer.Bookmaker;
import main.observer.Journalist;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import main.competitor.Competitor;

public abstract class SelectionTest {

    protected abstract SelectionStrategy createSelection();

    protected abstract List<Competitor> createList();

    @Test
    void testPoul() {
        List<Competitor> c = createList();
        List<Competitor> l;
        SelectionStrategy selectionStrategy = createSelection();
        l = selectionStrategy.play(c);
        assertTrue(Tournament.goodSizeForTournament(l.size()));
        for (Competitor i : l) {
            assertTrue(c.contains(i));
        }
    }
    @Test
    void testPoulWithObservers() {
        List<Competitor> c = createList();
        List<Competitor> l;
        SelectionStrategy selectionStrategy = createSelection();
        Bookmaker bookmaker1 = new Bookmaker("ParionsSport", c);
        Journalist journalist1 = new Journalist("beIN SPORTS");
        List<MatchObserver> observers = new ArrayList<MatchObserver>();
        observers.add(journalist1);
        observers.add(bookmaker1);
        l = selectionStrategy.play(c, observers);
        assertTrue(Tournament.goodSizeForTournament(l.size()));
        for (Competitor i : l) {
            assertTrue(c.contains(i));
        }
    }
}