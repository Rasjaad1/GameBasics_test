package com.example.footballsimulation;

public class Team {

    private final String teamName;
    private final int teamAttackingStrength;
    private final int teamDefensiveStrength;
    private int score;
    private int conceded;
    private Integer goalDifference;
    private Integer points;
    private int win;
    private int tie;
    private int loss;

    public Team(String teamName, int teamAttackingStrength, int teamDefensiveStrength) {
        this.teamName = teamName;
        this.teamAttackingStrength = teamAttackingStrength;
        this.teamDefensiveStrength = teamDefensiveStrength;
        score = 0;
        conceded = 0;
        goalDifference = 0;
        points = 0;
        win = 0;
        tie = 0;
        loss = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getteamAttackingStrength() {
        return teamAttackingStrength;
    }

    public int getTeamDefensiveStrength() {
        return teamDefensiveStrength;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setConceded(int conceded) {
        this.conceded = conceded;
    }

    public int getConceded() {
        return conceded;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Integer getPoints() {
        return points;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getWin() {
        return win;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    public int getTie() {
        return tie;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getLoss() {
        return loss;
    }
}
