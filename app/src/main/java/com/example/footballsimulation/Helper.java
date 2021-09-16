package com.example.footballsimulation;

import java.util.*;

public class Helper {


    public void changeScoreAndConcededPoints(Team teamHome, Team teamAway) {
        teamHome.setScore(teamHome.getScore() + 1);
        teamHome.setTotalScore(teamHome.getTotalScore() + 1);
        teamAway.setConceded(teamAway.getConceded() - 1);

        teamHome.setGoalDifference(teamHome.getTotalScore() - changeNegativeNumberToPositive(teamHome));
        teamAway.setGoalDifference(teamAway.getTotalScore() - changeNegativeNumberToPositive(teamAway));
    }

    public int changeNegativeNumberToPositive(Team team) {
        return Math.abs(team.getConceded());
    }


    public float changeOdds(Team teamHome, Team teamAway) {
        float odds = 0;
        //makes sure that the odds can't be a negative number to prevent random crashing.
        if (teamHome.getteamAttackingStrength() - teamAway.getTeamDefensiveStrength() > 0) ;
        odds = teamHome.getteamAttackingStrength() - teamAway.getTeamDefensiveStrength();
        odds = odds / 10;
        return Math.abs(odds);
    }

    public void sortTeams(ArrayList<Team> leagueTableList, Team team1, Team team2, Team team3, Team team4) {
        //clears previous objects, updates values and sorts them through points and then goal difference.
        leagueTableList.clear();
        leagueTableList.add(team1);
        leagueTableList.add(team2);
        leagueTableList.add(team3);
        leagueTableList.add(team4);
        leagueTableList.sort(new PointSorter());
    }
}
