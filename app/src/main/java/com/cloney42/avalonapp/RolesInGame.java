package com.cloney42.avalonapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RolesInGame extends AppCompatActivity {
    Button merlinInGameButton;
    Button percyInGameButton;
    Button assassinInGameButton;
    Button morganaInGameButton;
    Button mordredInGameButton;
    Button oberonInGameButton;
    Button nextButton;
    Boolean merlinInGame = false;
    Boolean percyInGame = false;
    Boolean assassinInGame = false;
    Boolean morganaInGame = false;
    Boolean mordredInGame = false;
    Boolean oberonInGame = false;
    int playerCount;
    int numPlayers;
    int seed;
    int yourNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles_in_game);
        playerCount = 0;
        Intent toRolesInGame = getIntent();
        numPlayers = toRolesInGame.getIntExtra("numPlayers",0);
        seed = toRolesInGame.getIntExtra("seed",0);
        yourNum = toRolesInGame.getIntExtra("yourNum",0);
        merlinInGameButton = (Button) findViewById(R.id.merlinInGame);
        merlinInGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                merlinInGame = !merlinInGame;
                if (!merlinInGame){
                    merlinInGameButton.setBackgroundColor(0xff5a595b);
                    playerCount--;
                }else{
                    if (playerCount<numPlayers){
                        merlinInGameButton.setBackgroundColor(Color.BLUE);
                        playerCount++;
                    }else{
                        merlinInGame = !merlinInGame;
                    }
                }
                System.out.println("PLAYER COUNT: "+playerCount);
            }
        });
        percyInGameButton = (Button) findViewById(R.id.percyInGame);
        percyInGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percyInGame = !percyInGame;
                if (!percyInGame){
                    percyInGameButton.setBackgroundColor(0xff5a595b);
                    playerCount--;
                }else{
                    if (playerCount<numPlayers){
                        percyInGameButton.setBackgroundColor(Color.BLUE);
                        playerCount++;
                    }else{
                        percyInGame = !percyInGame;
                    }
                }
                System.out.println("PLAYER COUNT: "+playerCount);
            }
        });
        assassinInGameButton = (Button) findViewById(R.id.assassinInGame);
        assassinInGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assassinInGame = !assassinInGame;
                if (!assassinInGame){
                    assassinInGameButton.setBackgroundColor(0xff5a595b);
                    playerCount--;
                }else{
                    if (playerCount<numPlayers){
                        assassinInGameButton.setBackgroundColor(Color.RED);
                        playerCount++;
                    }else{
                        assassinInGame = !assassinInGame;
                    }
                }
                System.out.println("PLAYER COUNT: "+playerCount);
            }
        });
        morganaInGameButton = (Button) findViewById(R.id.morganaInGame);
        morganaInGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                morganaInGame = !morganaInGame;
                if (!morganaInGame){
                    morganaInGameButton.setBackgroundColor(0xff5a595b);
                    playerCount--;
                }else{
                    if (playerCount<numPlayers){
                        morganaInGameButton.setBackgroundColor(Color.RED);
                        playerCount++;
                    }else{
                        morganaInGame = !morganaInGame;
                    }
                }
                System.out.println("PLAYER COUNT: "+playerCount);
            }
        });
        mordredInGameButton = (Button) findViewById(R.id.mordredInGame);
        mordredInGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mordredInGame = !mordredInGame;
                if (!mordredInGame){
                    mordredInGameButton.setBackgroundColor(0xff5a595b);
                    playerCount--;
                }else{
                    if (playerCount<numPlayers){
                        mordredInGameButton.setBackgroundColor(Color.RED);
                        playerCount++;
                    }else{
                        mordredInGame = !mordredInGame;
                    }
                }
                System.out.println("PLAYER COUNT: "+playerCount);
            }
        });
        oberonInGameButton = (Button) findViewById(R.id.oberonInGame);
        oberonInGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oberonInGame = !oberonInGame;
                if (!oberonInGame){
                    oberonInGameButton.setBackgroundColor(0xff5a595b);
                    playerCount--;
                }else{
                    if (playerCount<numPlayers){
                        oberonInGameButton.setBackgroundColor(Color.RED);
                        playerCount++;
                    }else{
                        oberonInGame = !oberonInGame;
                    }
                }
                System.out.println("PLAYER COUNT: "+playerCount);
            }
        });
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPlayerNames = new Intent(RolesInGame.this,RoleAssignerPlayerNames.class);
                toPlayerNames.putExtra("numPlayers",numPlayers);
                toPlayerNames.putExtra("seed",seed);
                toPlayerNames.putExtra("yourNum",yourNum);
                toPlayerNames.putExtra("merlinInGame",merlinInGame);
                toPlayerNames.putExtra("percyInGame",percyInGame);
                toPlayerNames.putExtra("assassinInGame",assassinInGame);
                toPlayerNames.putExtra("morganaInGame",morganaInGame);
                toPlayerNames.putExtra("mordredInGame",mordredInGame);
                toPlayerNames.putExtra("oberonInGame",oberonInGame);
                RolesInGame.this.startActivity(toPlayerNames);
            }
        });

    }
}
