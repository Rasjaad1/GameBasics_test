package com.example.footballsimulation;


import java.util.ArrayList;

public class Match {

    Helper helper = new Helper();


    public void getMatchup(Team teamHome, Team teamAway) {
        String text = teamHome.getTeamName() + " vs " + teamAway.getTeamName();
        System.out.println(text);
    }

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

    public void playMatch(Team teamHome, Team teamAway, ArrayList<Team> individualMatchListHome, ArrayList<Team> individualMatchListAway) {
        MatchResult(teamHome, teamAway);
        individualMatchListHome.add(teamHome);
        individualMatchListAway.add(teamAway);
    }

    public void MatchResult(Team teamHome, Team teamAway) {
        getMatchup(teamHome, teamAway);
        helper.countDownTime(teamHome, teamAway);
        if (teamHome.getTotalScore() > teamAway.getTotalScore()) {
            matchWon(teamHome, teamAway);
        } else if (teamHome.getTotalScore() == teamAway.getTotalScore()) {
            matchTied(teamHome, teamAway);
        } else {
            matchWon(teamAway, teamHome);
        }
    }

}
