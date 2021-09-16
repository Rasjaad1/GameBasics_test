package com.example.footballsimulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    private final Team ajax = new Team("Ajax", 85, 78);
    private final Team psv = new Team("psv", 82, 77);
    Match match = new Match();

    @Test
    void checkIfHomeWins() {
        match.matchWon(ajax, psv);
        assertEquals(3 , ajax.getPoints());
    }

    @Test
    void checkIfAwayLoses() {
        match.matchWon(ajax, psv);
        assertEquals(0, psv.getPoints());
    }

    @Test
    void matchTied() {
        match.matchTied(ajax ,psv);
        assertEquals(1, ajax.getPoints());
    }

    @Test
    void hasScored() {

        assertTrue(match.hasScored(ajax, psv));
    }

    @Test
    void playMatch() {
        match.playMatch(ajax, psv);
        boolean b = false;
        if (ajax.getPoints() == 3) {
            b = true;
        }
        else if (ajax.getPoints() == 1) {
            b = true;
        }
        assertTrue(b);
    }
}