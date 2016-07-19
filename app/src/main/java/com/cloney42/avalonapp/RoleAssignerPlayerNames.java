package com.cloney42.avalonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RoleAssignerPlayerNames extends AppCompatActivity {
    TextView p1TV,p2TV,p3TV,p4TV,p5TV,p6TV,p7TV,p8TV,p9TV,p10TV;
    EditText p1TF,p2TF,p3TF,p4TF,p5TF,p6TF,p7TF,p8TF,p9TF,p10TF;
    Button nextButton;
    int numPlayers;
    int seed;
    int yourNum;
    Boolean merlinInGame;
    Boolean percyInGame;
    Boolean assassinInGame;
    Boolean morganaInGame;
    Boolean mordredInGame;
    Boolean oberonInGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_assigner_player_names);
        Intent toPlayerNames = getIntent();
        p1TV = (TextView) findViewById(R.id.p1TV);
        p2TV = (TextView) findViewById(R.id.p2TV);
        p3TV = (TextView) findViewById(R.id.p3TV);
        p4TV = (TextView) findViewById(R.id.p4TV);
        p5TV = (TextView) findViewById(R.id.p5TV);
        p6TV = (TextView) findViewById(R.id.p6TV);
        p7TV = (TextView) findViewById(R.id.p7TV);
        p8TV = (TextView) findViewById(R.id.p8TV);
        p9TV = (TextView) findViewById(R.id.p9TV);
        p10TV = (TextView) findViewById(R.id.p10TV);
        p1TF = (EditText) findViewById(R.id.p1TF);
        p2TF = (EditText) findViewById(R.id.p2TF);
        p3TF = (EditText) findViewById(R.id.p3TF);
        p4TF = (EditText) findViewById(R.id.p4TF);
        p5TF = (EditText) findViewById(R.id.p5TF);
        p6TF = (EditText) findViewById(R.id.p6TF);
        p7TF = (EditText) findViewById(R.id.p7TF);
        p8TF = (EditText) findViewById(R.id.p8TF);
        p9TF = (EditText) findViewById(R.id.p9TF);
        p10TF = (EditText) findViewById(R.id.p10TF);
        nextButton = (Button) findViewById(R.id.nextButton);
        numPlayers = toPlayerNames.getIntExtra("numPlayers",0);
        seed = toPlayerNames.getIntExtra("seed",0);
        yourNum = toPlayerNames.getIntExtra("yourNum",0);
        merlinInGame = toPlayerNames.getBooleanExtra("merlinInGame",false);
        percyInGame = toPlayerNames.getBooleanExtra("percyInGame",false);
        assassinInGame = toPlayerNames.getBooleanExtra("assassinInGame",false);
        morganaInGame = toPlayerNames.getBooleanExtra("morganaInGame",false);
        mordredInGame = toPlayerNames.getBooleanExtra("mordredInGame",false);
        oberonInGame = toPlayerNames.getBooleanExtra("oberonInGame",false);
        switch(numPlayers) {
            case 5:
                p6TV.setVisibility(View.GONE);
                p6TF.setVisibility(View.GONE);
            case 6:
                p7TV.setVisibility(View.GONE);
                p7TF.setVisibility(View.GONE);
            case 7:
                p8TV.setVisibility(View.GONE);
                p8TF.setVisibility(View.GONE);
            case 8:
                p9TV.setVisibility(View.GONE);
                p9TF.setVisibility(View.GONE);
            case 9:
                p10TV.setVisibility(View.GONE);
                p10TF.setVisibility(View.GONE);
        }
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent namesToLogic = new Intent(RoleAssignerPlayerNames.this,RoleAssignerDisplay.class);
                namesToLogic.putExtra("numPlayers",numPlayers);
                namesToLogic.putExtra("seed",seed);
                namesToLogic.putExtra("yourNum",yourNum);
                namesToLogic.putExtra("p1Name",p1TF.getText().toString());
                namesToLogic.putExtra("p2Name",p2TF.getText().toString());
                namesToLogic.putExtra("p3Name",p3TF.getText().toString());
                namesToLogic.putExtra("p4Name",p4TF.getText().toString());
                namesToLogic.putExtra("p5Name",p5TF.getText().toString());
                namesToLogic.putExtra("p6Name",p6TF.getText().toString());
                namesToLogic.putExtra("p7Name",p7TF.getText().toString());
                namesToLogic.putExtra("p8Name",p8TF.getText().toString());
                namesToLogic.putExtra("p9Name",p9TF.getText().toString());
                namesToLogic.putExtra("p10Name",p10TF.getText().toString());
                namesToLogic.putExtra("numPlayers",numPlayers);
                namesToLogic.putExtra("seed",seed);
                namesToLogic.putExtra("yourNum",yourNum);
                namesToLogic.putExtra("merlinInGame",merlinInGame);
                namesToLogic.putExtra("percyInGame",percyInGame);
                namesToLogic.putExtra("assassinInGame",assassinInGame);
                namesToLogic.putExtra("morganaInGame",morganaInGame);
                namesToLogic.putExtra("mordredInGame",mordredInGame);
                namesToLogic.putExtra("oberonInGame",oberonInGame);
                RoleAssignerPlayerNames.this.startActivity(namesToLogic);
            }
        });
    }
}
