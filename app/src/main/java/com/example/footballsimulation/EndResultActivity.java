package com.example.footballsimulation;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EndResultActivity extends AppCompatActivity {

    private final Team ajax = new Team("Ajax", 85, 77);
    private final Team psv = new Team("psv", 81, 76);
    private final Team ado = new Team("ado", 77, 74);
    private final Team feyenoord = new Team("feyenoord", 79, 75);

    private final Match match = new Match();
    private final Helper helper = new Helper();

    private final ArrayList<Team> leagueTableList = new ArrayList<>();
    private TableLayout league_table_layout, individual_matches_tablelayout;
    private Switch layoutSwitch;
    private TextView teamHome;

    private int matchNumber = 1;
    private int number = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_result);

        layoutSwitch = findViewById(R.id.switch1);
        league_table_layout = findViewById(R.id.league_table_layout);
        individual_matches_tablelayout = findViewById(R.id.individual_matches_tablelayout);
        individual_matches_tablelayout.setVisibility(View.INVISIBLE);
        teamHome = findViewById(R.id.teamHome);
        teamHome.setVisibility(View.VISIBLE);

        //Round 1
        simRound(ajax, psv, ado, feyenoord);
        //Round 2
        simRound(ajax, feyenoord, psv, ado);
        //Round 3
        simRound(ajax, ado, psv, feyenoord);

        //Sorting teams according to their total points and goal difference
        helper.sortTeams(leagueTableList, ajax, psv, feyenoord, ado);
        fillLeagueTable();

        //This changes view from the league table to individual matches depending on if the switch is checked or not.
        layoutSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                league_table_layout.setVisibility(View.INVISIBLE);
                teamHome.setVisibility(View.INVISIBLE);
                individual_matches_tablelayout.setVisibility(View.VISIBLE);
            } else {
                league_table_layout.setVisibility(View.VISIBLE);
                teamHome.setVisibility(View.VISIBLE);
                individual_matches_tablelayout.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void simRound(Team team1, Team team2, Team team3, Team team4) {
        match.playMatch(team1, team2);
        fillMatchupTable(team1, team2);
        match.playMatch(team2, team1);
        fillMatchupTable(team2, team1);
        match.playMatch(team3, team4);
        fillMatchupTable(team3, team4);
        match.playMatch(team4, team3);
        fillMatchupTable(team4, team3);
    }

    public void fillLeagueTable() {
        //Fills tablerow with values of leagueTableList arraylist
        for (Team ar : leagueTableList) {
            final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.league_table_row, null);
            TextView tv;

            //Filling in cells
            tv = tableRow.findViewById(R.id.tableCell0);
            tv.setText(String.valueOf(number));

            tv = tableRow.findViewById(R.id.tableCell1);
            tv.setText(ar.getTeamName());

            tv = tableRow.findViewById(R.id.tableCell2);
            tv.setText(String.valueOf(ar.getPoints()));

            tv = tableRow.findViewById(R.id.tableCell3);
            tv.setText(String.valueOf(ar.getWin()));

            tv = tableRow.findViewById(R.id.tableCell4);
            tv.setText(String.valueOf(ar.getTie()));

            tv = tableRow.findViewById(R.id.tableCell5);
            tv.setText(String.valueOf(ar.getLoss()));

            tv = tableRow.findViewById(R.id.tableCell6);
            tv.setText(String.valueOf(ar.getTotalScore()));

            tv = tableRow.findViewById(R.id.tableCell7);
            tv.setText(String.valueOf(ar.getConceded()));

            tv = tableRow.findViewById(R.id.tableCell8);
            tv.setText(String.valueOf(ar.getGoalDifference()));

            tableRow.setBackgroundResource(R.drawable.border);
            //Add row to the table
            league_table_layout.addView(tableRow);
            ++number;
        }
    }

    public void fillMatchupTable(Team teamHome, Team teamAway) {
        final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.individual_matches_table, null);
        TextView tv;

        tv = tableRow.findViewById(R.id.tableCell0);
        tv.setText(("Match: " + matchNumber));

        tv = tableRow.findViewById(R.id.tableCell1);
        tv.setText(teamHome.getTeamName());

        tv = tableRow.findViewById(R.id.tableCell2);
        tv.setText(String.valueOf(teamHome.getScore()));

        tv = tableRow.findViewById(R.id.tableCell3);
        tv.setText(R.string.vs);

        tv = tableRow.findViewById(R.id.tableCell4);
        tv.setText(teamAway.getTeamName());

        tv = tableRow.findViewById(R.id.tableCell5);
        tv.setText(String.valueOf(teamAway.getScore()));

        tableRow.setBackgroundResource(R.drawable.border);
        //Add row to the table
        individual_matches_tablelayout.addView(tableRow);
        ++matchNumber;
        //clears previous match scores of both teams. This prevents adding up of all match scores.
        teamHome.clearScore();
        teamAway.clearScore();
    }

}