package main.selectionStrategy;

import main.competitor.Competitor;
import main.observer.MatchObserver;
import java.util.List;

/**
 * Represents the interface of the Strategy pattern
 *
 * @author Théo Crespo
 * @author Abir Bezzazi
 * @version 2.0
 */
public interface SelectionStrategy {
    public List<Competitor> play(List<Competitor> competitors);
    public List<Competitor> play(List<Competitor> competitors, List<MatchObserver> observers);
}
