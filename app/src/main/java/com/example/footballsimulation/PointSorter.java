package com.example.footballsimulation;

import java.util.Comparator;

public class PointSorter implements Comparator<Team> {

    @Override
    public int compare(Team teamHome, Team teamAway) {


        int sComp = teamAway.getPoints().compareTo(teamHome.getPoints());

        if (sComp != 0) {
            return sComp;
        }


        return teamAway.getGoalDifference().compareTo(teamHome.getGoalDifference());
    }
}