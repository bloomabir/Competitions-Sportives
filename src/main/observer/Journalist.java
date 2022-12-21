package main.observer;

import main.match.Match;


/**
 * Represents the concrete observer Journalist
 *
 * @author Théo Crespo
 * @author Abir Bezzazi
 * @version 3.0
 */
public class Journalist implements MatchObserver{

    public final String name;

    /**
     * The constructor of the class
     * @param name name of the journalist
     */
    public Journalist(String name) {
        this.name = name;
    }

    /**
     * Observes the match given in parameter and reacts to it
     * @param match match that is being observed
     */
    @Override
    public void reactToMatch(Match match) {
        System.out.println(this.name+" : Oooh, what a sensational victory for "+match.getWinner().getName()+" ! "+match.getLooser().getName()+" has to be more concentrated.");
        System.out.println("");
    }
}
