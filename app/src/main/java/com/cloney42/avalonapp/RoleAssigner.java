package com.cloney42.avalonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RoleAssigner extends AppCompatActivity {
    EditText numPlayersTF;
    EditText seedTF;
    EditText yourNumTF;
    Button nextButton;
    int numPlayers;
    int seed;
    int yourNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_assigner);
        numPlayersTF = (EditText) findViewById(R.id.numPlayersTF);
        seedTF = (EditText) findViewById(R.id.seed);
        yourNumTF = (EditText) findViewById(R.id.yourNum);
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int errCount = 0;
                boolean numPlayersError = false;
                boolean yourNumError = false;
                try {
                    numPlayers = Integer.parseInt(numPlayersTF.getText().toString());
                }catch (Exception e){
                    numPlayersTF.setText("Error");
                        errCount++;
                    numPlayersError = true;
                }
                try {
                    seed = Integer.parseInt(seedTF.getText().toString());
                }catch (Exception e) {
                    seedTF.setText("Error");
                    errCount++;
                }
                try {
                    yourNum = Integer.parseInt(yourNumTF.getText().toString());
                }catch (Exception e){
                    yourNumTF.setText("Error");
                    errCount++;
                    yourNumError = true;
                }
                if (numPlayers > 10 || numPlayers < 5){
                    if (!numPlayersError) {
                        numPlayersTF.setText("Players must be in between 5 and 10.");
                    }
                    numPlayersTF.setInputType(InputType.TYPE_CLASS_NUMBER);
                    errCount++;
                }
                if (yourNum < 1 || yourNum > numPlayers){
                    if (!yourNumError) {
                        yourNumTF.setText("Must be in between 1 and Number of Players.");
                    }
                    yourNumTF.setInputType(InputType.TYPE_CLASS_NUMBER);
                    errCount++;
                }
                if (errCount == 0) {
                    Intent toRolesInGame = new Intent(RoleAssigner.this,RolesInGame.class);
                    toRolesInGame.putExtra("numPlayers",numPlayers);
                    toRolesInGame.putExtra("seed",seed);
                    toRolesInGame.putExtra("yourNum",yourNum);
                    RoleAssigner.this.startActivity(toRolesInGame);
                }
            }
        });
    }
}
