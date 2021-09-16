package com.example.footballsimulation;

import java.util.Random;

public class Match {

    private final Helper helper = new Helper();


    public void matchWon(Team teamWon, Team teamLost) {
        System.out.println(teamWon.getTeamName() + " has won!");
        teamWon.setWin(teamWon.getWin() + 1);
        teamLost.setLoss(teamLost.getLoss() + 1);
        teamWon.setPoints(teamWon.getPoints() + 3);
    }

    public void matchTied(Team teamHome, Team teamAway) {
        System.out.println("It's a tie!");
        teamHome.setPoints(teamHome.getPoints() + 1);
        teamHome.setTie(teamHome.getTie() + 1);
        teamAway.setPoints(teamAway.getPoints() + 1);
        teamAway.setTie(teamAway.getTie() + 1);
    }


    public void countDownTime(Team teamHome, Team teamAway) {
        for (int i = 0; i <= 90; i++) {
            if (hasScored(teamHome, teamAway)) {
                helper.changeScoreAndConcededPoints(teamHome, teamAway);
                ++i;
            } else if (hasScored(teamAway, teamHome)) {
                helper.changeScoreAndConcededPoints(teamAway, teamHome);
                ++i;
            }
        }
    }

    public boolean hasScored(Team teamHome, Team teamAway) {
        int goal = 0;
        Random r = new Random();
        float odds = helper.changeOdds(teamHome, teamAway);
        float chance = r.nextFloat();
        if (chance <= odds) {
            goal = (int) ((Math.random() * 1) * (teamHome.getteamAttackingStrength() - teamAway.getTeamDefensiveStrength()));
            if (goal == 1) {
                System.out.println(teamHome.getTeamName() + " has scored!");
                return true;
            }
        }
        return false;
    }

    public void playMatch(Team teamHome, Team teamAway) {
        System.out.println(teamHome.getTeamName() + " vs " + teamAway.getTeamName());
        countDownTime(teamHome, teamAway);
        if (teamHome.getTotalScore() > teamAway.getTotalScore()) {
            matchWon(teamHome, teamAway);
        } else if (teamHome.getTotalScore() == teamAway.getTotalScore()) {
            matchTied(teamHome, teamAway);
        } else {
            matchWon(teamAway, teamHome);
        }
    }

}
