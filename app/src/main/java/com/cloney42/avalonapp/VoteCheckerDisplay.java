package com.cloney42.avalonapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VoteCheckerDisplay extends AppCompatActivity {
    TextView passOrFailTF;
    TextView numFailedTF;
    TextView totalVotesTF;
    Button newVoteButton;
    Button mainMenuButton;
    int passes;
    int fails;
    int totalVotes;
    boolean doubleFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_checker_display);
        Intent toDisplay = getIntent();
        passOrFailTF = (TextView) findViewById(R.id.passOrFailTF);
        numFailedTF = (TextView) findViewById(R.id.numFailedTF);
        totalVotesTF = (TextView) findViewById(R.id.totalVotesTF);
        newVoteButton = (Button) findViewById(R.id.newVoteButton);
        newVoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toNewVote = new Intent(VoteCheckerDisplay.this,VoteChecker.class);
                VoteCheckerDisplay.this.startActivity(toNewVote);
            }
        });
        mainMenuButton = (Button) findViewById(R.id.mainMenuButton);
        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMainMenu = new Intent(VoteCheckerDisplay.this,menu.class);
                VoteCheckerDisplay.this.startActivity(toMainMenu);
            }
        });
        passes = toDisplay.getIntExtra("passes", 0);
        fails = toDisplay.getIntExtra("fails", 0);
        totalVotes = passes+fails;
        doubleFail = toDisplay.getBooleanExtra("doubleFail", false);
        if(doubleFail){
            if (fails > 1){
                passOrFailTF.setTextColor(Color.RED);
                passOrFailTF.setText("FAIL");
            }else{
                passOrFailTF.setTextColor(Color.GREEN);
                passOrFailTF.setText("PASS");
            }
        }else{
            if (fails > 0){
                passOrFailTF.setTextColor(Color.RED);
                passOrFailTF.setText("FAIL");
            }else{
                passOrFailTF.setTextColor(Color.GREEN);
                passOrFailTF.setText("PASS");
            }
        }
        if (fails == 1){
            numFailedTF.setText("1 person has failed the quest.");
        }else{
            numFailedTF.setText(fails+" people have failed the quest.");
        }
        if (totalVotes == 1){
            totalVotesTF.setText("1 person has voted.");
        }else{
            totalVotesTF.setText(totalVotes+" people have voted.");
        }
    }
}
