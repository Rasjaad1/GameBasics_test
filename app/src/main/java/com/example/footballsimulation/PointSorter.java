package com.example.footballsimulation;

import java.util.Comparator;

public class PointSorter implements Comparator<Team> {

    @Override
    public int compare(Team t1, Team t2) {


        int sComp = t2.getPoints().compareTo(t1.getPoints());

        if (sComp != 0) {
            return sComp;
        }


        return t2.getGoalDifference().compareTo(t1.getGoalDifference());
    }
}