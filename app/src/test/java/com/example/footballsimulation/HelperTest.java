package com.example.footballsimulation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    Helper helper = new Helper();
    private final Team ajax = new Team("Ajax", 85, 78);
    private final Team psv = new Team("psv", 82, 77);
    private final Team ado = new Team("ado", 72, 65);
    private final Team feyenoord = new Team("feyenoord", 76, 73);
    ArrayList<Team> leagueTableList = new ArrayList<>();


    @Test
    void changeScoreAndConcededPoints() {
        helper.changeScoreAndConcededPoints(ajax, psv);
        assertEquals(1, ajax.getScore());
    }

    @Test
    void changeNegativeNumberToPositive() {
        ajax.setConceded(-5);
        int expected = 5;
        int actual = helper.changeNegativeNumberToPositive(ajax);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    void changeOdds() {
        float actual = helper.changeOdds(ajax, psv);
        float expected = 0.8f;
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    void sortTeams() {
        ArrayList<Team> test = new ArrayList<>();
        test.add(ajax);
        test.add(psv);
        test.add(feyenoord);
        test.add(ado);
        ajax.setPoints(10);
        psv.setPoints(8);
        ado.setPoints(2);
        feyenoord.setPoints(6);
        helper.sortTeams(leagueTableList, ajax, psv, ado, feyenoord);
        for (int i = 0; i < leagueTableList.size(); i++) {
            System.out.println(test.get(i).getTeamName() + " : " + leagueTableList.get(i).getTeamName() + "\n");
            assertEquals(test.get(i).getTeamName(), leagueTableList.get(i).getTeamName());
        }
    }
}