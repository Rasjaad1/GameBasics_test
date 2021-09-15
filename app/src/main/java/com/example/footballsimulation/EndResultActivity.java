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

import static com.example.footballsimulation.Match.matches;

public class EndResultActivity extends AppCompatActivity {
    public ArrayList<Team> items = new ArrayList<>();

    Team ajax = new Team("Ajax", 85, 78);
    Team psv = new Team("psv", 83, 79);
    Team ado = new Team("ado", 72, 65);
    Team feyenoord = new Team("feyenoord", 76, 73);
    Simulate simulate = new Simulate();

    TableLayout tablelayout;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_end_result);

        Switch layoutSwitch = findViewById(R.id.switch1);

        simulate.simulateRound(ajax, psv, ado, feyenoord);
        simulate.simulateRound(ajax, ado, psv, feyenoord);
        simulate.simulateRound(ajax, feyenoord, ado, psv);
        sortTeams();

        tablelayout = (TableLayout) findViewById(R.id.tablelayout);
        txt = findViewById(R.id.testtxt);
        txt.setVisibility(View.INVISIBLE);

        fillLeagueTable();
        fillLeagueMatchups();

        layoutSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tablelayout.setVisibility(View.INVISIBLE);
                    txt.setVisibility(View.VISIBLE);

                } else {
                    tablelayout.setVisibility(View.VISIBLE);
                    txt.setVisibility(View.INVISIBLE);
                }
            }

        });

    }

    public void sortTeams() {
        //clears previous objects, updates values and sorts them through points and goal difference.
        items.clear();
        items.add(ajax);
        items.add(psv);
        items.add(ado);
        items.add(feyenoord);
        items.sort(new PointSorter());
    }

    public void fillLeagueTable() {
        //Fills tablerow with values of items arraylist
        for (Team ar : items) {
            final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.tablerow, null);
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
            tv.setText(String.valueOf(ar.getScore()));

            tv = (TextView) tableRow.findViewById(R.id.tableCell7);
            tv.setText(String.valueOf(ar.getConceded()));

            tv = (TextView) tableRow.findViewById(R.id.tableCell8);
            tv.setText(String.valueOf(ar.getGoalDifference()));

            //Add row to the table
            tablelayout.addView(tableRow);
        }
    }

    public void fillLeagueMatchups() {

        //ToDo need to add a way to seperate and count score of every match.
        txt.setText(String.valueOf(matches.get(0).getScore()));
    }

}