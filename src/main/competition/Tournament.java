package main.competition;

import main.competitor.Competitor;
import main.match.Match;
import main.observer.MatchObserver;
import main.util.NotPowerOfTwoException;

import java.util.List;
import java.util.Map;


/**
 * Represents a Tournament
 *
 * @author Théo Crespo
 * @author Abir Bezzazi
 * @version 2.0
 */
public class Tournament extends Competition {

    /**
     * Constructor class
     * Creates an instance of tournament and tests if the length of competitors is a power of two
     *
     * @param competitors list of competitors registered the tournament
     * @throws NotPowerOfTwoException exception thrown when the number of the competitors is not a power of two
     */
    public Tournament(List<Competitor> competitors) throws NotPowerOfTwoException {
        super(competitors);
        if (!goodSizeForTournament(competitors.size())) {
            throw new NotPowerOfTwoException("The organisation of such tournaments requires a number of competitors to the power of 2.");
        }
    }

    /**
     * Another constructor class
     *
     * @param competitors list of competitors registered the tournament
     * @param observers   list of observers
     */
    public Tournament(List<Competitor> competitors, List<MatchObserver> observers) {
        super(competitors, observers);
        if (!goodSizeForTournament(competitors.size())) {
            throw new NotPowerOfTwoException("The organisation of such tournaments requires a number of competitors to the power of 2.");
        }
    }

    /**
     * Method that checks if the list of competitors is good for the tournament
     *
     * @param n number of competitors that will play the tournament
     * @return bool whether is a good number or not for the tournament
     */
    public static boolean goodSizeForTournament(int n) {
        while (n % 2 == 0) {
            n = n / 2;
        }
        if (n != 1) {
            return false;
        }
        return true;
    }

    /**
     * Plays the tournament competition with an algorithm
     *
     * @param l list of competitors
     */
    public void play(List<Competitor> l) {
        int numPlayer = 0;
        int poule = l.size();
        Competitor ctmp = null;
        int nbPointWinner = 0;
        while (poule >= 2) {
            for (Competitor cc : l) {
                if (competitorsRanking.get(cc) == nbPointWinner) {
                    if (numPlayer == 0) {
                        ctmp = cc;
                        numPlayer = 1;
                    } else {
                        playMatch(ctmp, cc);
                        numPlayer = 0;
                    }
                }
            }
            nbPointWinner++;
            poule = poule / 2;
        }
    }

    /**
     * Plays a match and nominates a winner
     *
     * @param c1 Competitor 1
     * @param c2 Competitor 2
     */
    public void playMatch(Competitor c1, Competitor c2) {
        Match m = new Match(c1, c2);
        m.playMatch();
        this.competitorsRanking.put(m.getWinner(), this.competitorsRanking.get(m.getWinner()) + 1);
        matchPlayed(m);
    }

    /**
     * sorts the list in the order of the winners
     *
     * @return the list of competitors sorted
     */
    @Override
    public Map<Competitor, Integer> ranking() {
        super.ranking();
        displayRanking();
        return this.competitorsRanking;
    }

    /**
     * prints the ranking
     */
    public void displayRanking() {
        System.out.println("*** Ranking ***");
        for (Map.Entry<Competitor, Integer> entry : this.competitorsRanking.entrySet()) {
            System.out.println(entry.getKey().getName() + " - " + entry.getValue());
        }
    }
}
