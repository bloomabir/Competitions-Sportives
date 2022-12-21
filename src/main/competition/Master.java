package main.competition;

import main.competitor.Competitor;
import main.selectionStrategy.SelectionStrategy;
import main.observer.MatchObserver;

import java.util.List;

/**
 * Represents a Master
 *
 * @author Théo Crespo
 * @author Abir Bezzazi
 * @version 2.0
 */
public class Master extends Competition {


    /**
     * The object that represents a selection strategy used for the master
     */
    private SelectionStrategy selectionStrategy;

    /**
     * The constructor class
     *
     * @param competitors       list of the competitors
     * @param selectionStrategy the type of selection used during Master
     */
    public Master(List<Competitor> competitors, SelectionStrategy selectionStrategy) {
        super(competitors);
        this.selectionStrategy = selectionStrategy;
    }

    /**
     * Another constructor class
     *
     * @param competitors       list of the competitors
     * @param selectionStrategy the type of selection used during Master
     * @param observers         list of the observers
     */
    public Master(List<Competitor> competitors, SelectionStrategy selectionStrategy, List<MatchObserver> observers) {
        super(competitors, observers);
        this.selectionStrategy = selectionStrategy;
    }

    /**
     * Plays the method play of the selection strategy
     *
     * @param competitors competitors of the poul generated
     * @return a poul ready for the second phase
     */
    public List<Competitor> poul(List<Competitor> competitors, List<MatchObserver> observers) {
        return selectionStrategy.play(competitors, observers);
    }

    /**
     * Plays a tournament and prints its ranking
     *
     * @param l list of competitors
     */
    @Override
    protected void play(List<Competitor> l) {
        Tournament tournament = new Tournament(poul(l, observers), observers);
        System.out.println("");
        System.out.println("----------Tournament----------");
        System.out.println("");

        tournament.play();

        System.out.println("");
        tournament.ranking();
    }

    /**
     * Plays a match between two competitors
     *
     * @param c1 first competitor
     * @param c2 second competitor
     */
    @Override
    protected void playMatch(Competitor c1, Competitor c2){
    }
}
