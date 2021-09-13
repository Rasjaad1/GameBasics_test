package com.example.footballsimulation;

import java.util.*;

public class Helper {


    public void changeScoreAndConceded(Team t1, Team t2) {
        t1.setScore(t1.getScore() + 1);
        t2.setConceded(t2.getConceded() - 1);

        t1.setGoalDifference(t1.getScore() - setNegativeNumberToPositive(t1));
        t2.setGoalDifference(t2.getScore() - setNegativeNumberToPositive(t2));
    }

    public int setNegativeNumberToPositive(Team t) {
        return Math.abs(t.getConceded());
    }


    public float changeOdds(Team t1, Team t2) {
        float odds = 0;
        //makes sure that the odds can't be a negative number to prevent random crashing.
        if (t1.getteamAttackingStrength() - t2.getTeamDefensiveStrength() > 0) ;
        odds = t1.getteamAttackingStrength() - t2.getTeamDefensiveStrength();
        odds = odds / 10;
        return Math.abs(odds);
    }


    public void sortTeamsByPoints(Team t1, Team t2, Team t3, Team t4) {
        ArrayList<Team> items = new ArrayList<>();
        items.add(t1);
        items.add(t2);
        items.add(t3);
        items.add(t4);

        items.sort(new PointSorter());
        System.out.println("Club:             Points:                   Goals:                  Conceded:                 Goal Difference:  ");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getTeamName() + "               " + items.get(i).getPoints() + "            " + items.get(i).getScore() + "           " + Math.abs(items.get(i).getConceded()) + "            " + items.get(i).getGoalDifference());
        }
    }


    public void doSomething(Team t1, Team t2) {
        int time = 0;
        do {
            time++;

            changeName(t1, t2);
            changeName(t2, t1);
        } while (time != 90);
    }

    public void changeName(Team t1, Team t2) {
        int goal;
        Random r = new Random();
        float odds = changeOdds(t1, t2);
        float chance = r.nextFloat();
        System.out.println("odds " + odds);
        System.out.println("chance " + chance);
        if (chance <= odds) {
            goal = (int) ((Math.random() * 1) * (t1.getteamAttackingStrength() - t2.getTeamDefensiveStrength()));
            if (goal == 1) {
                System.out.println(t1.getTeamName() + " goal " + goal);
                changeScoreAndConceded(t1, t2);
            }
        }
    }
}
