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

    public void countDownTime(Team t1, Team t2) {
        int time = 0;
        do {
            time++;

            if (hasScored(t1, t2)) break;
            else hasScored(t2, t1);

        } while (time != 90);
    }

    public boolean hasScored(Team t1, Team t2) {
        int goal;
        Random r = new Random();
        float odds = changeOdds(t1, t2);
        float chance = r.nextFloat();
        if (chance <= odds) {
            goal = (int) ((Math.random() * 1) * (t1.getteamAttackingStrength() - t2.getTeamDefensiveStrength()));
            if (goal == 1) {
                changeScoreAndConceded(t1, t2);
                return true;
            }
        }
        return false;
    }
}
