package com.cloney42.avalonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class RoleAssignerDisplay extends AppCompatActivity {
    TextView LBL1;
    TextView LBL2;
    TextView LBL3;
    TextView LBL4;
    Button newGameButton;
    Button mainMenuButton;
    int numPlayers;
    int seed;
    int yourNum;
    String p1Name;
    String p2Name;
    String p3Name;
    String p4Name;
    String p5Name;
    String p6Name;
    String p7Name;
    String p8Name;
    String p9Name;
    String p10Name;
    ArrayList playerNums = new ArrayList();
    ArrayList playerNames = new ArrayList();
    ArrayList playerRealNums = new ArrayList();
    Boolean merlinInGame;
    Boolean percyInGame;
    Boolean assassinInGame;
    Boolean morganaInGame;
    Boolean mordredInGame;
    Boolean oberonInGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_assigner_display);
        LBL1 = (TextView) findViewById(R.id.LBL1);
        LBL2 = (TextView) findViewById(R.id.LBL2);
        LBL3 = (TextView) findViewById(R.id.LBL3);
        LBL4 = (TextView) findViewById(R.id.LBL4);
        newGameButton = (Button) findViewById(R.id.newGameButton);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newGame = new Intent(RoleAssignerDisplay.this, RoleAssignerNewGame.class);
                newGame.putExtra("numPlayers", numPlayers);
                newGame.putExtra("yourNum", yourNum);
                newGame.putExtra("p1Name", p1Name);
                newGame.putExtra("p2Name", p2Name);
                newGame.putExtra("p3Name", p3Name);
                newGame.putExtra("p4Name", p4Name);
                newGame.putExtra("p5Name", p5Name);
                newGame.putExtra("p6Name", p6Name);
                newGame.putExtra("p7Name", p7Name);
                newGame.putExtra("p8Name", p8Name);
                newGame.putExtra("p9Name", p9Name);
                newGame.putExtra("p10Name", p10Name);
                RoleAssignerDisplay.this.startActivity(newGame);
            }
        });
        mainMenuButton = (Button) findViewById(R.id.mainMenuButton);
        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent displayToMain = new Intent(RoleAssignerDisplay.this, menu.class);
                RoleAssignerDisplay.this.startActivity(displayToMain);
            }
        });
        Intent namesToLogic = getIntent();
        numPlayers = namesToLogic.getIntExtra("numPlayers", 0);
        seed = namesToLogic.getIntExtra("seed", 0);
        yourNum = namesToLogic.getIntExtra("yourNum", 0);
        p1Name = namesToLogic.getStringExtra("p1Name");
        p2Name = namesToLogic.getStringExtra("p2Name");
        p3Name = namesToLogic.getStringExtra("p3Name");
        p4Name = namesToLogic.getStringExtra("p4Name");
        p5Name = namesToLogic.getStringExtra("p5Name");
        p6Name = namesToLogic.getStringExtra("p6Name");
        p7Name = namesToLogic.getStringExtra("p7Name");
        p8Name = namesToLogic.getStringExtra("p8Name");
        p9Name = namesToLogic.getStringExtra("p9Name");
        p10Name = namesToLogic.getStringExtra("p10Name");
        merlinInGame = namesToLogic.getBooleanExtra("merlinInGame",false);
        percyInGame = namesToLogic.getBooleanExtra("percyInGame",false);
        assassinInGame = namesToLogic.getBooleanExtra("assassinInGame",false);
        morganaInGame = namesToLogic.getBooleanExtra("morganaInGame",false);
        mordredInGame = namesToLogic.getBooleanExtra("mordredInGame",false);
        oberonInGame = namesToLogic.getBooleanExtra("oberonInGame",false);
        playerNames.add(p1Name);
        playerNames.add(p2Name);
        playerNames.add(p3Name);
        playerNames.add(p4Name);
        playerNames.add(p5Name);
        playerNames.add(p6Name);
        playerNames.add(p7Name);
        playerNames.add(p8Name);
        playerNames.add(p9Name);
        playerNames.add(p10Name);
        for (int i = 10 - numPlayers, j = 0; j < i; j++) {
            playerNames.remove(playerNames.size() - 1);
        }
        assignRoles();
    }

    public void assignRoles() {
        resetPlayerNums();
        String name = "";
        boolean merlin = false;
        boolean oberon = false;
        boolean badGuy = false;
        boolean goodGuy = false;
        boolean assassin = false;
        boolean percival = false;
        boolean morgana = false;
        boolean mordred = false;
        for (int i = playerRealNums.size() - 1; i >= 0; i--) {
            playerRealNums.remove(i);
        }
        setPlayers();
        double playerNum = setRandNum(yourNum);
        resetPlayerNums();
        if (merlinInGame && playerNum == 1) {
            name = "Merlin";
            merlin = true;
        } else if (assassinInGame && playerNum == numPlayers) {
            name = "Assassin";
            assassin = true;
        } else if (percyInGame && playerNum == 2) {
            name = "Percival";
            percival = true;
        } else if (morganaInGame && playerNum == numPlayers - 1) {
            name = "Morgana";
            morgana = true;
        } else if (oberonInGame && playerNum == numPlayers - 2) {
            name = "Oberon";
            oberon = true;
        } else if (mordredInGame && playerNum == numPlayers - 3) {
            name = "Mordred";
            mordred = true;
        } else if (playerNum > Math.ceil(numPlayers / 2.0) + 1 && numPlayers != 9) {
            name = "a Minion of Mordred";
            badGuy = true;
        } else if (playerNum <= Math.ceil(numPlayers / 2.0) + 1 && numPlayers != 9) {
            name = "a Loyal Servant of Arthur";
            goodGuy = true;
        } else if (playerNum > 6 && numPlayers == 9) {
            name = "a Minion of Mordred";
            badGuy = true;
        } else if (playerNum <= 6 && numPlayers == 9) {
            name = "a Loyal Servant of Arthur";
            goodGuy = true;
        }
        LBL1.setText("You are " + name + "!");
        if (merlin) {
            Random r = new Random();
            int rNum2 = r.nextInt(2) + 1;
            int rNum3 = r.nextInt(3) + 1;
            int assassinLoc = playerRealNums.indexOf(numPlayers);
            int morganaLoc = playerRealNums.indexOf(numPlayers - 1);
            int oberonLoc = playerRealNums.indexOf(numPlayers - 2);
            if (numPlayers >= 7) {
                if (rNum3 == 1) {
                    LBL2.setText(playerNames.get(assassinLoc) + " is a Minion of Mordred");
                    LBL3.setText(playerNames.get(oberonLoc) + " is a Minion of Mordred");
                    LBL4.setText(playerNames.get(morganaLoc) + " is a Minion of Mordred");
                } else if (rNum3 == 2) {
                    LBL2.setText(playerNames.get(morganaLoc) + " is a Minion of Mordred");
                    LBL4.setText(playerNames.get(assassinLoc) + " is a Minion of Mordred");
                    LBL3.setText(playerNames.get(oberonLoc) + " is a Minion of Mordred");
                } else {
                    LBL2.setText(playerNames.get(oberonLoc) + " is a Minion of Mordred");
                    LBL4.setText(playerNames.get(morganaLoc) + " is a Minion of Mordred");
                    LBL3.setText(playerNames.get(assassinLoc) + " is a Minion of Mordred");
                }
            } else {
                if (rNum2 == 1) {
                    LBL2.setText(playerNames.get(assassinLoc) + " is a Minion of Mordred");
                    LBL3.setText(playerNames.get(morganaLoc) + " is a Minion of Mordred");
                } else {
                    LBL2.setText(playerNames.get(morganaLoc) + " is a Minion of Mordred");
                    LBL3.setText(playerNames.get(assassinLoc) + " is a Minion of Mordred");
                }
            }
        }
        if (assassin) {
            int morganaLoc = playerRealNums.indexOf(numPlayers - 1);
            int mordredLoc = playerRealNums.indexOf(numPlayers - 3);
            if (morganaInGame) {
                LBL2.setText(playerNames.get(morganaLoc) + " is Morgana");
            }else{
                LBL2.setText(playerNames.get(morganaLoc) + " is a Minion of Mordred");
            }
            if (numPlayers == 10) {
                if (mordredInGame) {
                    LBL3.setText(playerNames.get(mordredLoc) + " is Mordred");
                }else{
                    LBL3.setText(playerNames.get(mordredLoc) + " is a Minion of Mordred");
                }
            }
        }
        if (percival) {
            Random r = new Random();
            int rNum = r.nextInt(2) + 1;
            int merlinLoc = playerRealNums.indexOf(1);
            int morganaLoc = playerRealNums.indexOf(numPlayers - 1);
            if (rNum == 1) {
                LBL2.setText("Merlin is " + playerNames.get(merlinLoc) + " or " + playerNames.get(morganaLoc));
            } else {
                LBL2.setText("Merlin is " + playerNames.get(morganaLoc) + " or " + playerNames.get(merlinLoc));
            }
        }
        if (morgana) {
            int assassinLoc = playerRealNums.indexOf(numPlayers);
            int mordredLoc = playerRealNums.indexOf(numPlayers - 3);
            if (assassinInGame) {
                LBL2.setText(playerNames.get(assassinLoc) + " is the Assassin");
            }else{
                LBL2.setText(playerNames.get(assassinLoc) + " is a Minion of Mordred");
            }
            if (numPlayers == 10) {
                if (mordredInGame) {
                    LBL3.setText(playerNames.get(mordredLoc) + " is Mordred");
                }else{
                    LBL3.setText(playerNames.get(mordredLoc) + " is a Minion of Mordred");
                }
            }
        }
        if (mordred) {
            int assassinLoc = playerRealNums.indexOf(numPlayers);
            int morganaLoc = playerRealNums.indexOf(numPlayers - 1);
            if (assassinInGame) {
                LBL2.setText(playerNames.get(assassinLoc) + " is the Assassin");
            }else{
                LBL2.setText(playerNames.get(assassinLoc) + " is a Minion of Mordred");
            }
            if (morganaInGame) {
                LBL3.setText(playerNames.get(morganaLoc) + " is Morgana");
            }else{
                LBL3.setText(playerNames.get(morganaLoc) + " is a Minion of Mordred");
            }
        }
    }

    public void resetPlayerNums() {
        for (int i = playerNums.size() - 1; i >= 0; i--) {
            playerNums.remove(i);
        }
        for (int i = 0; i < numPlayers; i++) {
            playerNums.add(i + 1);
        }
    }

    public void setPlayers() {
        for (int i = 0; i < numPlayers; i++) {
            playerRealNums.add(setRandNum(i + 1));
        }
    }

    public int getRandNum(int num) {
        int seedNum = seed + num;
        Random r = new Random(seedNum);
        int rNum = r.nextInt(numPlayers) + 1;
        return rNum;
    }

    public int setRandNum(int num) {
        resetPlayerNums();
        int randNum;
        int loopNum = num;
        int finalNum = 0;
        for (int i = 0; i < loopNum; i++) {
            randNum = getRandNum(i);
            if (playerNums.indexOf(randNum) == -1) {
                loopNum++;
            } else {
                finalNum = randNum;
                int loc = playerNums.indexOf(randNum);
                playerNums.remove(loc);
            }
        }
        return finalNum;
    }
}
