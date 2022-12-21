package main.selectionStrategy;

import main.competitor.Competitor;
import main.util.NotGoodSizeException;
import main.competition.League;
import main.observer.MatchObserver;
import main.util.*;

import java.util.*;

/**
 * Represents the concrete selection strategy B
 *
 * @author Théo Crespo
 * @author Abir Bezzazi
 * @version 2.0
 */
public class ConcreteSelectionB implements SelectionStrategy {

    /**
     * Method that plays the logic of this concrete selection B
     *
     * @param competitors list of competitors
     * @param observers   list of observers
     * @return the list of the competitors qualified for the second phase
     * @throws NotGoodSizeException exception thrown if the size of the list of competitors is not good for poul
     */
    public List<Competitor> play(List<Competitor> competitors, List<MatchObserver> observers) throws NotGoodSizeException {
        int nb_groups = 3;
        if ((competitors.size() % nb_groups != 0) || (competitors.size() < 9)) {
            throw new NotGoodSizeException("The organisation of such poul requires a number of competitors  multiple of 3.");
        }
        List<Competitor> qualified = new ArrayList<Competitor>();
        Map<Competitor, Integer> repêchés = new HashMap<>();
        int taille_poul = competitors.size() / nb_groups;
        for (int i = 0; i < nb_groups; i++) {
            System.out.println("----------poul " + (i + 1) + "----------");
            System.out.println("");
            List<Competitor> participant_poul = new ArrayList<Competitor>();
            for (int j = (taille_poul * i); j < taille_poul + (taille_poul * i); j++) {
                participant_poul.add(competitors.get(j));
            }
            League league = new League(participant_poul, observers);
            league.play();
            Iterator it = league.ranking().entrySet().iterator();
            int j = 0;
            while (it.hasNext() && (j < 2)) {
                Map.Entry m = (Map.Entry) it.next();
                qualified.add((Competitor) m.getKey());
                j++;
            }
            if (it.hasNext()) {
                Map.Entry m = (Map.Entry) it.next();
                repêchés.put((Competitor) m.getKey(), (Integer) m.getValue());
            }
            league.displayRanking();
            System.out.println("");
        }
        repêchés = MapUtil.sortByDescendingValue(repêchés);
        Iterator itr = repêchés.entrySet().iterator();
        int k = 0;
        while (itr.hasNext() && (k < 2)) {
            Map.Entry m = (Map.Entry) itr.next();
            qualified.add((Competitor) m.getKey());
            k++;
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

