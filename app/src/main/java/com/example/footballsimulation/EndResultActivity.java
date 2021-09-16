package com.example.footballsimulation;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EndResultActivity extends AppCompatActivity {
    public ArrayList<Team> leagueTableList = new ArrayList<>();
    public ArrayList<Team> individualMatchListHome = new ArrayList<>();
    public ArrayList<Team> individualMatchListAway = new ArrayList<>();


    TextView teamHome;
    Team ajax = new Team("Ajax", 85, 78);
    Team psv = new Team("psv", 82, 77);
    Team ado = new Team("ado", 72, 65);
    Team feyenoord = new Team("feyenoord", 76, 73);

    Match match = new Match();
    Helper helper = new Helper();

    TableLayout league_table_layout, individual_matches_tablelayout;
    int matchNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_end_result);

        Switch layoutSwitch = findViewById(R.id.switch1);

        league_table_layout = findViewById(R.id.league_table_layout);
        individual_matches_tablelayout = findViewById(R.id.individual_matches_tablelayout);
        individual_matches_tablelayout.setVisibility(View.INVISIBLE);
        teamHome = findViewById(R.id.teamHome);
        teamHome.setVisibility(View.VISIBLE);


        //Round 1
        match.playMatch(ajax, psv, individualMatchListHome, individualMatchListAway);
        fillMatchup();
        match.playMatch(psv, ajax, individualMatchListHome, individualMatchListAway);
        fillMatchup();
        match.playMatch(ado, feyenoord, individualMatchListHome, individualMatchListAway);
        fillMatchup();
        match.playMatch(feyenoord, ado, individualMatchListHome, individualMatchListAway);
        fillMatchup();

        //Round 2
        match.playMatch(ajax, feyenoord, individualMatchListHome, individualMatchListAway);
        fillMatchup();
        match.playMatch(feyenoord, ajax, individualMatchListHome, individualMatchListAway);
        fillMatchup();
        match.playMatch(psv, ado, individualMatchListHome, individualMatchListAway);
        fillMatchup();
        match.playMatch(ado, psv, individualMatchListHome, individualMatchListAway);
        fillMatchup();
        //Round 3
        match.playMatch(ajax, ado, individualMatchListHome, individualMatchListAway);
        fillMatchup();
        match.playMatch(ado, ajax, individualMatchListHome, individualMatchListAway);
        fillMatchup();
        match.playMatch(psv, feyenoord, individualMatchListHome, individualMatchListAway);
        fillMatchup();
        match.playMatch(feyenoord, psv, individualMatchListHome, individualMatchListAway);
        fillMatchup();

        helper.sortTeams(leagueTableList, ajax, psv, feyenoord, ado);
        fillLeagueTable();

        layoutSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    league_table_layout.setVisibility(View.INVISIBLE);
                    teamHome.setVisibility(View.INVISIBLE);
                    individual_matches_tablelayout.setVisibility(View.VISIBLE);
                } else {
                    league_table_layout.setVisibility(View.VISIBLE);
                    teamHome.setVisibility(View.VISIBLE);
                    individual_matches_tablelayout.setVisibility(View.INVISIBLE);
                }
            }

        });

    }

    public void fillLeagueTable() {
        //Fills tablerow with values of items arraylist
        for (Team ar : leagueTableList) {
            final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.league_table_row, null);
            TextView tv;

            //Filling in cells
            tv = (TextView) tableRow.findViewById(R.id.tableCell1);
            tv.setText(ar.getTeamName());

            tv = (TextView) tableRow.findViewById(R.id.tableCell2);
            tv.setText(String.valueOf(ar.getPoints()));

            tv = (TextView) tableRow.findViewById(R.id.tableCell3);
            tv.setText(String.valueOf(ar.getWin()));

            tv = (TextView) tableRow.findViewById(R.id.tableCell4);
            tv.setText(String.valueOf(ar.getTie()));

            tv = (TextView) tableRow.findViewById(R.id.tableCell5);
            tv.setText(String.valueOf(ar.getLoss()));

            tv = (TextView) tableRow.findViewById(R.id.tableCell6);
            tv.setText(String.valueOf(ar.getTotalScore()));

            tv = (TextView) tableRow.findViewById(R.id.tableCell7);
            tv.setText(String.valueOf(ar.getConceded()));

            tv = (TextView) tableRow.findViewById(R.id.tableCell8);
            tv.setText(String.valueOf(ar.getGoalDifference()));

            //Add row to the table
            league_table_layout.addView(tableRow);
        }
    }

    public void fillMatchup() {
        for (Team ar : individualMatchListHome) {
            for (Team ar2 : individualMatchListAway) {

                final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.individual_matches_table, null);
                TextView tv;

                //Filling in cells
                tv = (TextView) tableRow.findViewById(R.id.tableCell0);
                tv.setText(String.valueOf("Match: " + matchNumber));

                tv = (TextView) tableRow.findViewById(R.id.tableCell1);
                tv.setText(ar.getTeamName());

                tv = (TextView) tableRow.findViewById(R.id.tableCell2);
                tv.setText(String.valueOf(ar.getScore()));

                tv = (TextView) tableRow.findViewById(R.id.tableCell3);
                tv.setText(R.string.vs);

                tv = (TextView) tableRow.findViewById(R.id.tableCell4);
                tv.setText(String.valueOf(ar2.getTeamName()));

                tv = (TextView) tableRow.findViewById(R.id.tableCell5);
                tv.setText(String.valueOf(ar2.getScore()));

                //Add row to the table
                individual_matches_tablelayout.addView(tableRow);
                ++matchNumber;
                ar2.clearScore();
            }
            ar.clearScore();
        }
        individualMatchListHome.clear();
        individualMatchListAway.clear();
        //ToDo need to add a way to seperate and count score of every match.
    }

}