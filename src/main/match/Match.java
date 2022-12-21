package main.match;

import main.competitor.Competitor;

/**
 * Represents a Match
 *
 * @author Théo Crespo and Abir Bezzazi
 * @version 1.0
 */
public class Match {
    Competitor winner;
    Competitor looser;

    /**
     * The constructor of the class.
     *
     * @param c1 the first competitor
     * @param c2 the second competitor
     */
    public Match(Competitor c1, Competitor c2) {
        this.winner = c1;
        this.looser = c2;
    }

    /**
     * Gets the winner
     *
     * @return an object Competitor
     */
    public Competitor getWinner() {
        return winner;
    }

    /**
     * Gets the looser
     *
     * @return an object Competitor
     */
    public Competitor getLooser() {
        return looser;
    }

    /**
     * Plays a match between two competitors setting randomly the winner and looser
     * Prints the winner
     */
    public void playMatch() {
        String s = winner.getName() + " vs " + looser.getName();
        if (Math.random() < 0.5) {
            Competitor tmp = looser;
            looser = winner;
            winner = tmp;
        }
        s += " --> " + winner.getName() + " wins!";
        System.out.println(s);

    }
}
