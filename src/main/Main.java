package main;

import main.competition.Competition;
import main.competition.League;
import main.observer.Bookmaker;
import main.observer.Journalist;
import main.observer.MatchObserver;
import main.util.NotPowerOfTwoException;
import main.competition.Tournament;
import main.competitor.Competitor;
import main.competition.Master;
import main.selectionStrategy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int nbOfCompetition;
        Scanner console = new Scanner(System.in);
        System.out.println("""
                1. League\s
                2. Tournament\s
                3. Master A
                4. Master B""");
        System.out.print("Enter the number of the competition you want to watch: ");
        nbOfCompetition = console.nextInt();
        switch (nbOfCompetition) {
            case 1 -> {
                System.out.println("------You chose a league------");
                List<Competitor> competitors = List.of(
                        new Competitor("Théo"),
                        new Competitor("Abir"),
                        new Competitor("Maeva"),
                        new Competitor("Mehdi"));
                Bookmaker bookmaker1 = new Bookmaker("ParionsSport", competitors);
                Journalist journalist1 = new Journalist("beIN SPORTS");
                List<MatchObserver> observers = new ArrayList<MatchObserver>();
                observers.add(journalist1);
                observers.add(bookmaker1);
                Competition league = new League(competitors, observers);
                System.out.println("");
                league.play();
                System.out.println("");
                System.out.println("*** Ranking ***");
                Map<Competitor, Integer> m = league.ranking();
                m.forEach((key, value) -> System.out.println(key.getName() + " - " + value));
                System.out.println("------You chose a league------");
            }
            case 2 -> {
                System.out.println("------You chose a tournament------");
                try {
                    //observers.remove(bookmaker1);
                    List<Competitor> Tcompetitors = List.of(
                            new Competitor("Théo"),
                            new Competitor("Abir"),
                            new Competitor("Maeva"),
                            new Competitor("Mehdi"),
                            new Competitor("Bob"),
                            new Competitor("Timoléon"),
                            new Competitor("Toto"),
                            new Competitor("Titi"));

                    Journalist Tjournalist = new Journalist("beIN SPORTS");
                    Bookmaker Tbookmaker = new Bookmaker("ParionsSport", Tcompetitors);
                    List<MatchObserver> Tobservers = new ArrayList<MatchObserver>();
                    Tobservers.add(Tjournalist);
                    Tobservers.add(Tbookmaker);

                    Competition tournament = new Tournament(Tcompetitors, Tobservers);

                    System.out.println("");
                    tournament.play();
                    System.out.println("");
                    tournament.ranking();
                } catch (NotPowerOfTwoException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("------You chose a tournament------");
            }
            case 3 -> {
                System.out.println("------You chose Master A------");
                try {
                    //observers.remove(bookmaker1);
                    List<Competitor> MAcompetitors = List.of(
                            new Competitor("Théo"),
                            new Competitor("Abir"),
                            new Competitor("Maeva"),
                            new Competitor("Mehdi"),
                            new Competitor("Bob"),
                            new Competitor("Timoléon"),
                            new Competitor("Toto"),
                            new Competitor("Titi"),
                            new Competitor("Théophile"),
                            new Competitor("Ronaldo"),
                            new Competitor("Messi"),
                            new Competitor("Di Maria"),
                            new Competitor("Mbappé"),
                            new Competitor("Neymar"),
                            new Competitor("Maradona"),
                            new Competitor("Pepe")
                    );
                    Journalist MAjournalist = new Journalist("beIN SPORTS");
                    Bookmaker MAbookmaker = new Bookmaker("ParionsSport", MAcompetitors);
                    List<MatchObserver> MAobservers = new ArrayList<MatchObserver>();
                    MAobservers.add(MAjournalist);
                    MAobservers.add(MAbookmaker);
                    //bookmaker1 = new Bookmaker("ParionsSport", competitors);
                    //observers.add(bookmaker1);
                    Competition masterA = new Master(MAcompetitors, new ConcreteSelectionA(), MAobservers);

                    System.out.println("");
                    masterA.play();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("------You chose Master A------");
            }
            case 4 -> {
                System.out.println("------You chose Master B------");
                try {
                    //observers.remove(bookmaker1);
                    List<Competitor> MBcompetitors = List.of(
                            new Competitor("Théo"),
                            new Competitor("Abir"),
                            new Competitor("Maeva"),
                            new Competitor("Mehdi"),
                            new Competitor("Bob"),
                            new Competitor("Timoléon"),
                            new Competitor("Toto"),
                            new Competitor("Titi"),
                            new Competitor("Théophile"),
                            new Competitor("Ronaldo"),
                            new Competitor("Messi"),
                            new Competitor("Di Maria"),
                            new Competitor("Mbappé"),
                            new Competitor("Neymar"),
                            new Competitor("Maradona"),
                            new Competitor("Pepe")
                    );
                    Journalist MBjournalist = new Journalist("beIN SPORTS");
                    Bookmaker MBbookmaker = new Bookmaker("ParionsSport", MBcompetitors);
                    List<MatchObserver> MBobservers = new ArrayList<MatchObserver>();
                    MBobservers.add(MBjournalist);
                    MBobservers.add(MBbookmaker);
                    //bookmaker1 = new Bookmaker("ParionsSport", competitors);
                    //observers.add(bookmaker1);
                    Competition masterB = new Master(MBcompetitors, new ConcreteSelectionA(), MBobservers);

                    System.out.println("");
                    masterB.play();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("------You chose Master B------");
            }
            default -> System.out.println("Invalid input. Enter number between 1 and 4 ");
        }
    }
}
