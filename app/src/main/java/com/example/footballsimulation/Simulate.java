package com.example.footballsimulation;

public class Simulate {

    Helper helper = new Helper();
    public void simulateRound(Team t1, Team t2, Team t3, Team t4) {
        Match match = new Match();

        match.MatchResult(t1, t2);
        match.MatchResult(t2, t1);
        match.MatchResult(t3, t4);
        match.MatchResult(t4, t3);
        helper.sortTeamsByPoints(t1, t2, t3, t4);
    }
}