package com.example.footballsimulation;

import java.util.*;

public class Helper {


    public void changeScoreAndConceded(Team teamHome, Team teamAway) {
        teamHome.setScore(teamHome.getScore() + 1);
        teamHome.setTotalScore(teamHome.getTotalScore() + 1);
        teamAway.setConceded(teamAway.getConceded() - 1);

        teamHome.setGoalDifference(teamHome.getTotalScore() - setNegativeNumberToPositive(teamHome));
        teamAway.setGoalDifference(teamAway.getTotalScore() - setNegativeNumberToPositive(teamAway));
    }

    public int setNegativeNumberToPositive(Team team) {
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

    public void countDownTime(Team teamHome, Team teamAway) {
        for (int i = 0; i <= 90; i++) {
            if (hasScored(teamHome, teamAway) == 1) {
                changeScoreAndConceded(teamHome, teamAway);
                ++i;
            } else if (hasScored(teamAway, teamHome) == 1) {
                changeScoreAndConceded(teamAway, teamHome);
                ++i;
            }
        }
    }

    public int hasScored(Team teamHome, Team teamAway) {
        int goal = 0;
        Random r = new Random();
        float odds = changeOdds(teamHome, teamAway);
        float chance = r.nextFloat();
        if (chance <= odds) {
            goal = (int) ((Math.random() * 1) * (teamHome.getteamAttackingStrength() - teamAway.getTeamDefensiveStrength()));
            if (goal == 1) {
                return goal;
            }
        }
        return goal;
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
