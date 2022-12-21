package main.competition;

import main.competitor.Competitor;
import main.observer.MatchObserver;
import main.util.MapUtil;
import main.match.Match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a Competition
 *
 * @author Théo Crespo
 * @author Abir Bezzazi
 * @version 1.0
 */
public abstract class Competition {
    protected Map<Competitor, Integer> competitorsRanking;
    protected final List<Competitor> competitors;
    protected List<MatchObserver> observers;

    /**
     * The constructor class
     *
     * @param competitors list of the competitors
     */
    public Competition(List<Competitor> competitors) {
        this.competitors = competitors;
        this.competitorsRanking = new HashMap<>();
        for (Competitor cc : this.competitors) {
            this.competitorsRanking.put(cc, 0);
        }
    }

    /**
     * Another constructor class
     *
     * @param competitors list of the competitors
     * @param observers   list of the observers
     */
    public Competition(List<Competitor> competitors, List<MatchObserver> observers) {

        this.competitors = competitors;
        this.observers = observers;
        this.competitorsRanking = new HashMap<>();
        for (Competitor cc : this.competitors) {
            this.competitorsRanking.put(cc, 0);
        }
    }

    /**
     * Adds the observer given in param to the list of observers. We might want to have Family or FIFA as an observer.
     *
     * @param observer an observer
     */
    public void addObserver(MatchObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes the observer given in param from the list of observers. We might want to have a private competition so we remove the unwanted observers.
     *
     * @param observer an observer
     */
    public void removeObserver(MatchObserver observer) {
        observers.remove(observer);
    }

    /**
     * Makes each observer reacts to the match played
     *
     * @param match the match played
     */
    public void matchPlayed(Match match) {
        if (observers != null) {
            for (MatchObserver observer : observers) {
                observer.reactToMatch(match);
            }
        }
    }

    /**
     * Calls the method play of the subclass.
     * Subclass represents a type of competition (League or Tournament)
     */
    public void play() {
        play(this.competitors);
    }

    /**
     * Signature of the method play that defines the logic of the course of the subclass.
     * Subclass represents a type of competition (League or Tournament)
     *
     * @param l list of competitors
     */
    protected abstract void play(List<Competitor> l);

    /**
     * Signature of the method playMatch that plays a match between two competitors given in params
     *
     * @param c1 first competitor
     * @param c2 second competitor
     */
    protected abstract void playMatch(Competitor c1, Competitor c2);

    /**
     * Sorts the list in the order of the winners
     *
     * @return the list of competitors sorted
     */
    public Map<Competitor, Integer> ranking() {
        competitorsRanking = MapUtil.sortByDescendingValue(competitorsRanking);
        return competitorsRanking;
    }

    /**
     * Prints the ranking
     */
    public void displayRanking() {
        System.out.println("");
        System.out.println("*** Ranking ***");
        for (Map.Entry<Competitor, Integer> entry : this.competitorsRanking.entrySet()) {
            System.out.println(entry.getKey().getName() + " - " + entry.getValue());
        }
        System.out.println("");
    }
}
