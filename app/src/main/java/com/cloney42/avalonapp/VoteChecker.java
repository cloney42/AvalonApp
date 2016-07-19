package com.cloney42.avalonapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class VoteChecker extends AppCompatActivity {
    Switch doubleFailSwitch;
    Button passButton;
    Button failButton;
    Button voteButton;
    Button checkVoteButton;
    int doubleFailToggle;
    boolean passButtonToggle;
    boolean failButtonToggle;
    boolean doubleFail;
    int passes;
    int fails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote_checker);
        doubleFailToggle = 0;
        passButtonToggle = false;
        failButtonToggle = false;
        doubleFail = false;
        fails = 0;
        passes = 0;
        doubleFailSwitch = (Switch) findViewById(R.id.doubleFail);
        passButton = (Button) findViewById(R.id.passButton);
        failButton = (Button) findViewById(R.id.failButton);
        voteButton = (Button) findViewById(R.id.voteButton);
        checkVoteButton = (Button) findViewById(R.id.checkVoteButton);
        doubleFailSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doubleFail = !doubleFail;
                doubleFailSwitch.setChecked(doubleFail);
            }
        });
        passButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passButtonToggle = true;
                failButtonToggle = false;
                passButton.setBackgroundColor(Color.GREEN);
                failButton.setBackgroundColor(0xff5a595b);
            }
        });
        failButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passButtonToggle = false;
                failButtonToggle = true;
                failButton.setBackgroundColor(Color.RED);
                passButton.setBackgroundColor(0xff5a595b);
            }
        });
        voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passButtonToggle || failButtonToggle){
                    if (passButtonToggle){
                        passes++;
                    }else{
                        fails++;
                    }
                    failButton.setBackgroundColor(0xff5a595b);
                    passButton.setBackgroundColor(0xff5a595b);
                    passButtonToggle = false;
                    failButtonToggle = false;
                }
            }
        });
        checkVoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toDisplay = new Intent(VoteChecker.this,VoteCheckerDisplay.class);
                toDisplay.putExtra("passes",passes);
                toDisplay.putExtra("fails",fails);
                toDisplay.putExtra("doubleFail",doubleFail);
                VoteChecker.this.startActivity(toDisplay);
            }
        });
    }
}
