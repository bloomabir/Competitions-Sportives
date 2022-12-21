package main.selectionStrategy;

import main.competition.League;
import main.competitor.Competitor;
import main.util.NotGoodSizeException;
import main.observer.MatchObserver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Represents the concrete selection strategy A
 *
 * @author Théo Crespo
 * @author Abir Bezzazi
 * @version 2.0
 */
public class ConcreteSelectionA implements SelectionStrategy {

    /**
     * Method that plays the logic of this concrete selection A
     *
     * @param competitors list of competitors
     * @param observers   list of observers
     * @return the list of the competitors qualified for the second phase
     * @throws NotGoodSizeException exception thrown if the size of the list of competitors is not good for poul
     */
    @Override
    public List<Competitor> play(List<Competitor> competitors, List<MatchObserver> observers) throws NotGoodSizeException {
        int nb_groups = 4;
        if ((competitors.size() % nb_groups != 0) || (competitors.size() < 4)) {
            throw new NotGoodSizeException("The organisation of such poul requires a number of competitors multiple of 4.");
        }
        if (competitors.size() == nb_groups) {
            return competitors;
        }
        List<Competitor> qualified = new ArrayList<Competitor>();
        int taille_poul = competitors.size() / nb_groups;
        for (int i = 0; i < nb_groups; i++) {
            System.out.println("----------poul " + (i + 1) + "----------");
            System.out.println("");
            List<Competitor> poul_participants = new ArrayList<Competitor>();
            for (int j = (taille_poul * i); j < taille_poul + (taille_poul * i); j++) {
                poul_participants.add(competitors.get(j));
            }
            League league = new League(poul_participants, observers);
            league.play();
            Iterator it = league.ranking().entrySet().iterator();
            int j = 0;
            while (it.hasNext() && (j < 1)) {
                Map.Entry m = (Map.Entry) it.next();
                qualified.add((Competitor) m.getKey());
                j++;
            }
            league.displayRanking();
            System.out.println("");
        }
        return qualified;
    }

    /**
     * Calls method play above
     *
     * @param competitors list of competitors
     * @return list of the qualified competitors from the method play of this concrete selection
     * @throws NotGoodSizeException
     */
    @Override
    public List<Competitor> play(List<Competitor> competitors) throws NotGoodSizeException {
        return play(competitors, null);
    }
}
