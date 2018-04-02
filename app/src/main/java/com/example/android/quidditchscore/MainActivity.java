package com.example.android.quidditchscore;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void quaffleTeamA(View v){
        scoreTeamA = scoreTeamA + 10;
        displayForTeamA(scoreTeamA);
    }

    public void quaffleTeamB(View v){
        scoreTeamB = scoreTeamB + 10;
        displayForTeamB(scoreTeamB);
    }

    public void snitchTeamA(View v){
        scoreTeamA = scoreTeamA + 150;
        winningTeam();
        displayForTeamA(scoreTeamA);
    }

    public void snitchTeamB(View v){
        scoreTeamB = scoreTeamB + 150;
        winningTeam();
        displayForTeamB(scoreTeamB);
    }

    public void obliviate(View v){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    public void winningTeam(){
        if (scoreTeamA > scoreTeamB){
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.ireland_wins,
                    (ViewGroup) findViewById(R.id.custom_toast_container));
            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }

        else if (scoreTeamB > scoreTeamA) {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.bulgaria_wins,
                    (ViewGroup) findViewById(R.id.custom_toast_container));
            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }

        else {
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.tie,
                    (ViewGroup) findViewById(R.id.custom_toast_container));
            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
