package main.selectionStrategy;

import org.junit.jupiter.api.Test;
import main.competitor.Competitor;
import main.observer.MatchObserver;
import main.observer.Bookmaker;
import main.observer.Journalist;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcreteSelectionATest extends SelectionTest {

    protected SelectionStrategy createSelection() {
        return new ConcreteSelectionA();
    }

    protected List<Competitor> createList() {
        return List.of(
                new Competitor("Théo"),
                new Competitor("Abir"),
                new Competitor("Maeva"),
                new Competitor("Mehdi"),
                new Competitor("Bob"),
                new Competitor("Timoléon"),
                new Competitor("Toto"),
                new Competitor("Titi"),
                new Competitor("Théophile"),
                new Competitor("jules"),
                new Competitor("cesar"),
                new Competitor("brayan"),
                new Competitor("lola"),
                new Competitor("sarah"),
                new Competitor("eric"),
                new Competitor("grosminet")
        );
    }

    @Test
    public void playTest() {
        SelectionStrategy selectionStrategy = new ConcreteSelectionA();
        List<Competitor> l;
        List<Competitor> cmp = createList();
        Bookmaker bookmaker1 = new Bookmaker("ParionsSport", cmp);
        Journalist journalist1 = new Journalist("beIN SPORTS");
        List<MatchObserver> observers = new ArrayList<MatchObserver>();
        observers.add(journalist1);
        observers.add(bookmaker1);
        l = selectionStrategy.play(cmp, observers);
        assertEquals(4, l.size());
    }
}