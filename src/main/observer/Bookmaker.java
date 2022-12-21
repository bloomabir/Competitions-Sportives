package main.observer;

import main.competitor.Competitor;
import main.match.Match;
import main.util.MapUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents the concrete observer Bookmaker
 *
 * @author Théo Crespo
 * @author Abir Bezzazi
 * @version 3.0
 */
public class Bookmaker implements MatchObserver {
    private Map<Competitor, Integer> cotes = new HashMap<Competitor, Integer>();
    public final String name;


    /**
     * The constructor of the class
     *
     * @param name        name of the bookmaker
     * @param competitors list of competitors
     */
    public Bookmaker(String name, List<Competitor> competitors) {
        this.name = name;
        for (Competitor c : competitors) {
            cotes.put(c, 2);
        }
    }

    /**
     * Observes the match given in parameter and reacts to it by updating the quota of each competitor
     *
     * @param match match that is being observed
     */
    @Override
    public void reactToMatch(Match match) {
        int coteWin;
        if ((coteWin = cotes.get(match.getWinner())) > 0) {
            cotes.put(match.getWinner(), coteWin - 1);
        }
        cotes.put(match.getLooser(), cotes.get(match.getLooser()) + 1);
        displayCotes();
    }

     public Map<Competitor, Integer> displayCotes()
    {
        this.cotes = MapUtil.sortByDescendingValue(cotes);
        System.out.println("");
            System.out.println("--- cotes ---");
            for (Map.Entry<Competitor, Integer> entry : this.cotes.entrySet()) {
                System.out.println(entry.getKey().getName() + " - " + entry.getValue());
            }
        System.out.println("");
        return cotes;
    }
}
