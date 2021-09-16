package com.example.footballsimulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TeamTest {
    private final Team ajax = new Team("Ajax", 85, 78);

    @Test
    void compareScore() {

        ajax.setScore(3);
        ajax.setScore(ajax.getScore() + 3);
        assertEquals(6, ajax.getScore());
    }
    @Test
    void compareScoreToTotalScore() {
        ajax.setScore(3);
        ajax.setTotalScore(8);
        ajax.setScore(ajax.getScore() + 3);
        System.out.println(ajax.getTotalScore() + " : " + ajax.getScore());
        assertNotEquals(ajax.getTotalScore(), ajax.getScore());
    }

    @Test
    void compareAfterClear() {
        ajax.setScore(6);
        ajax.setTotalScore(8);
        ajax.clearScore();
        assertNotEquals(ajax.getTotalScore(), ajax.getScore());
    }

}