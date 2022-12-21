package main.competition;

import main.competitor.Competitor;
import main.match.Match;
import main.observer.MatchObserver;

import java.util.List;

/**
 * Represents a League
 *
 * @author Théo Crespo
 * @author Abir Bezzazi
 * @version 1.0
 */
public class League extends Competition {

    /**
     * The constructor of the class League
     *
     * @param competitors list of the competitors
     */
    public League(List<Competitor> competitors) {
        super(competitors);
    }

    /**
     * Another constructor of the class League
     *
     * @param competitors list of the competitors
     * @param observers   list of the observers
     */
    public League(List<Competitor> competitors, List<MatchObserver> observers) {
        super(competitors, observers);
    }

    /**
     * Calls the method playMatch for each competitor in the competitors list given in parameter
     * and each competitor plays with the rest of the list twice
     *
     * @param l list of the competitors
     */
    @Override
    protected void play(List<Competitor> l) {
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.size(); j++)
                if (i != j) {
                    this.playMatch(l.get(i), l.get(j));
                }
        }
    }

    /**
     * Creates a match with the params given, plays the match and adds 1 to the winner key of the list
     * when the match ends.
     *
     * @param c1 first competitor
     * @param c2 second competitor
     */
    public void playMatch(Competitor c1, Competitor c2) {
        Match m = new Match(c1, c2);
        m.playMatch();
        competitorsRanking.put(m.getWinner(), competitorsRanking.get(m.getWinner()) + 1);
        matchPlayed(m);
    }
}
