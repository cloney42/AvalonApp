package com.cloney42.avalonapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HowToUse extends AppCompatActivity {
    Button roleAssignerButton;
    Button voteCheckerButton;
    Button avalonButton;
    Button avalonRolesButton;
    Button mainMenuButton;
    TextView roleAssignerContent;
    TextView voteCheckerContent;
    TextView avalonContent;
    TextView avalonRolesContent;
    boolean avalonToggle;
    boolean roleAssignerToggle;
    boolean voteCheckerToggle;
    boolean avalonRolesToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use);
        avalonToggle = false;
        roleAssignerToggle = false;
        voteCheckerToggle = false;
        avalonRolesToggle = false;
        mainMenuButton = (Button) findViewById(R.id.mainMenuButton);
        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMainMenu = new Intent(HowToUse.this, menu.class);
                HowToUse.this.startActivity(toMainMenu);
            }
        });
        avalonRolesButton = (Button) findViewById(R.id.avalonRolesButton);
        avalonRolesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avalonRolesToggle = !avalonRolesToggle;
                if (avalonRolesToggle) {
                    avalonRolesContent.setVisibility(View.VISIBLE);
                } else {
                    avalonRolesContent.setVisibility(View.GONE);
                }
            }
        });
        roleAssignerButton = (Button) findViewById(R.id.roleAssignerButton);
        roleAssignerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roleAssignerToggle = !roleAssignerToggle;
                if (roleAssignerToggle) {
                    roleAssignerContent.setVisibility(View.VISIBLE);
                } else {
                    roleAssignerContent.setVisibility(View.GONE);
                }
            }
        });
        voteCheckerButton = (Button) findViewById(R.id.voteCheckerButton);
        voteCheckerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voteCheckerToggle = !voteCheckerToggle;
                if (voteCheckerToggle) {
                    voteCheckerContent.setVisibility(View.VISIBLE);
                } else {
                    voteCheckerContent.setVisibility(View.GONE);
                }
            }
        });
        avalonButton = (Button) findViewById(R.id.avalonButton);
        avalonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avalonToggle = !avalonToggle;
                if (avalonToggle) {
                    avalonContent.setVisibility(View.VISIBLE);
                } else {
                    avalonContent.setVisibility(View.GONE);
                }
            }
        });
        avalonRolesContent = (TextView) findViewById(R.id.avalonRolesContent);
        roleAssignerContent = (TextView) findViewById(R.id.roleAssignerContent);
        voteCheckerContent = (TextView) findViewById(R.id.voteCheckerContent);
        avalonContent = (TextView) findViewById(R.id.avalonContent);
        avalonRolesContent.setVisibility(View.GONE);
        roleAssignerContent.setVisibility(View.GONE);
        voteCheckerContent.setVisibility(View.GONE);
        avalonContent.setVisibility(View.GONE);

        avalonContent.setText("Source: http://www.theresistanceonline.com/rules.html\n\n" +
                "- The game requires between five and ten players.\n\n" +
                "- Approximately one third of the players are randomly chosen as Minions of Mordred; the rest are members are the Loyal Servants of Arthur.\n\n" +
                "- The Minions of Mordred know who the other Minions of Mordred are, but Loyal Servants of Arthur do not.\n\n" +
                "- The game consists of up to five missions.\n\n" +
                "- Each mission has a leader. The leader proposes a mission team of a certain size, which the group approves by public vote.\n\n" +
                "- If the group does not approve the mission by a simple majority, leadership passes to the next player.\n\n" +
                "- If the group cannot approve a mission team after five attempts, the Minions of Mordred win.\n\n" +
                "- Once a mission team is chosen, it votes by secret ballot whether the mission succeeds or fails.\n\n" +
                "- Loyal Servants of Arthur will always vote for success, but Minions of Mordred have the option of voting for success or failure.\n\n" +
                "- It usually only takes one Minion of Mordred on the mission team to sabotage a mission, but sometimes the fourth mission requires two.\n\n" +
                "- If three missions succeed, the Loyal Servants of Arthur win. If three fail, the Minions of Mordred win.\n\n" +
                "- You are allowed to say anything, to any one, at any time -- as long as it is said publicly.");

        avalonRolesContent.setText("" +
                "- 5 Players: Merlin, Assassin, Percival, Morgana, and 1 Loyal Servant of Arthur\n" +
                "- 6 Players: Merlin, Assassin, Percival, Morgana, and 2 Loyal Servant of Arthur\n" +
                "- 7 Players: Merlin, Assassin, Percival, Morgana, Oberon, and 2 Loyal Servant of Arthur\n" +
                "- 8 Players: Merlin, Assassin, Percival, Morgana, Oberon, and 3 Loyal Servant of Arthur\n" +
                "- 9 Players: Merlin, Assassin, Percival, Morgana, Oberon, and 4 Loyal Servant of Arthur\n" +
                "- 10 Players: Merlin, Assassin, Percival, Morgana, Oberon, Mordred, and 4 Loyal Servant of Arthur\n\n" +
                "- Merlin: Merlin is a Loyal Servant of Arthur. At the beginning of the game, Merlin can see all the Minions of Mordred.\n\n" +
                "- Assassin: The assassin is a Minion of Mordred. If the Loyal Servants of Arthur win the game, the assassin is allowed to guess who merlin is. If the assassin guesses right, Minions of Mordred win the game.\n\n" +
                "- Morgana: Morgana is a Minion of Mordred. Morgana can be seen as Merlin to Percival.\n\n" +
                "- Percival: Percival is a a Loyal Servant of Arthur. At the beginning of the game, Percival can see Merlin and Morgana. Percival does not know which one is which.\n\n" +
                "- Oberon: Oberon is a Minion of Mordred. Oberon is not seen by any Minion of Mordred. Merlin can see Oberon.\n\n" +
                "- Mordred: Mordred cannot be seen by Merlin.");

        roleAssignerContent.setText("" +
                "- When you start the role assigner, you are greeted with 3 inputs, \"Number of Players\", \"Seed\", and \"Your Number\". For Number of Players, insert the total number of players" +
                " that are playing. For Seed, everyone that is playing has to enter the same number. The number can be any random number. The seed makes sure everyone has different roles. Everyone " +
                "that is playing should get their own number from 1 to the number of players playing. This number can be shared to the other players. " +
                "When all the text fields are filled, click the next button on the bottom.\n\n" +
                "- On the next screen, you will see text fields for player names. Insert the name of the player that corresponds " +
                "with their individual number. You may leave your own text field empty." +
                " When all the names are filled in, press the next button on the bottom.\n\n" +
                "- At the top of the following screen, it will say what your role is. Below your role, there may be some intelligence on other players. On the bottom of that screen there " +
                "two buttons, \"New Game\" and \"Main Menu\". New Game will bring you to a new screen to enter a new seed. Number of Players, Your number, and the player names will stay " +
                "the same. Main Menu will bring you back to the main menu.");

        voteCheckerContent.setText("" +
                "- This vote checker can only be used if everyone is playing in person.\n\n" +
                "- First thing to do is choose if the mission requires a double fail. You can toggle the switch on top (White = no double fail), (Black = requires double fail)." +
                " The first voter will choose if they want to pass or fail the mission by clicking on the \"Pass\" or \"Fail\" buttons. Then they will press the \"Vote\"" +
                " button to cast their vote. When the color of the button has returned to grey, they will pass the device to the next voter who will then vote. The device will continue " +
                "to be passed until all the people on the mission have voted. Once all the people on the mission have either passed or failed the mission, press the \"Check Vote\" button on the" +
                "bottom of the screen. There it will say whether the mission has passed or failed, how many people failed the quest, and how many total voters there were.\n\n" +
                "- At the bottom of the screen there are two buttons, \"New Vote\" and \"Main Menu\". New Vote will bring you back to the previous screen to start a new vote. Main Menu will bring" +
                " you back to the main menu.");
    }
}
