package main.observer;

import main.match.Match;

/**
 * Represents the interface of the Observer pattern
 * @author Théo Crespo
 * @author Abir Bezzazi
 * @version 3.0
 */
public interface MatchObserver {
    void reactToMatch(Match match);
}
