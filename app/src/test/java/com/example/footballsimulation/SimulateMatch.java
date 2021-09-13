package com.example.footballsimulation;

import org.junit.jupiter.api.Test;


public class SimulateMatch {
    @Test
    void simulateAllRounds() {
        Team ajax = new Team("Ajax", 85, 78);
        Team psv = new Team("psv", 83, 79);
        Team ado = new Team("ado", 72, 65);
        Team feyenoord = new Team("feyenoord", 76, 70);
        Simulate round = new Simulate();
        round.simulateRound(ajax, psv, ado, feyenoord);
        round.simulateRound(ajax, ado, psv, feyenoord);
        round.simulateRound(ajax, feyenoord, psv, ado);
    }
}