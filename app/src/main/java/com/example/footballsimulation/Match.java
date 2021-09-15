package com.example.footballsimulation;

import java.util.ArrayList;

public class Match {

    public static ArrayList<Team> matches = new ArrayList<>();
    Helper helper = new Helper();


    public void getMatchup(Team t1, Team t2) {
        String text = t1.getTeamName() + " vs " + t2.getTeamName();
        System.out.println(text);
    }

    public void matchWon(Team teamWon, Team teamLost) {
        System.out.println(teamWon.getTeamName() + " has won!");
        teamWon.setWin(teamWon.getWin() + 1);
        teamLost.setLoss(teamLost.getLoss() + 1);
        teamWon.setPoints(teamWon.getPoints() + 3);
    }

    public void matchTied(Team t1, Team t2) {
        System.out.println("It's a tie!");
        t1.setPoints(t1.getPoints() + 1);
        t1.setTie(t1.getTie() + 1);
        t2.setPoints(t2.getPoints() + 1);
        t2.setTie(t2.getTie() + 1);
    }

    public void MatchResult(Team t1, Team t2) {
        getMatchup(t1, t2);
        matches.add(t1);
        matches.add(t2);
        helper.countDownTime(t1, t2);
        if (t1.getScore() > t2.getScore()) {
            matchWon(t1, t2);
        } else if (t1.getScore() == t2.getScore()) {
            matchTied(t1, t2);
        } else {
            matchWon(t2, t1);
        }
    }

}
