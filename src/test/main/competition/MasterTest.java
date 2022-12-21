package main.competition;

import main.competitor.Competitor;
import main.selectionStrategy.*;

import java.util.List;


public class MasterTest extends CompetitionTest {
    SelectionStrategy selectionStrategy = new ConcreteSelectionA();

    @Override
    protected Competition createCompetition(List<Competitor> competitors) {
        return new Master(competitors, selectionStrategy);
    }
}