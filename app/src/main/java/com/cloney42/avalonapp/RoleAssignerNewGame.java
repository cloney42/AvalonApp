package com.cloney42.avalonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RoleAssignerNewGame extends AppCompatActivity {
    EditText newSeedTF;
    Button nextButton;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_assigner_new_game);
        newSeedTF = (EditText) findViewById(R.id.newSeedTF);
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    seed = Integer.parseInt(newSeedTF.getText().toString());
                    Intent toDisplay = new Intent(RoleAssignerNewGame.this,RoleAssignerDisplay.class);
                    toDisplay.putExtra("numPlayers",numPlayers);
                    toDisplay.putExtra("seed",seed);
                    toDisplay.putExtra("yourNum",yourNum);
                    toDisplay.putExtra("p1Name",p1Name);
                    toDisplay.putExtra("p2Name",p2Name);
                    toDisplay.putExtra("p3Name",p3Name);
                    toDisplay.putExtra("p4Name",p4Name);
                    toDisplay.putExtra("p5Name",p5Name);
                    toDisplay.putExtra("p6Name",p6Name);
                    toDisplay.putExtra("p7Name",p7Name);
                    toDisplay.putExtra("p8Name",p8Name);
                    toDisplay.putExtra("p9Name",p9Name);
                    toDisplay.putExtra("p10Name",p10Name);
                    RoleAssignerNewGame.this.startActivity(toDisplay);
                }catch(Exception e){
                    newSeedTF.setText("Error");
                    newSeedTF.setInputType(InputType.TYPE_CLASS_NUMBER);
                }

            }
        });
        Intent toNewGame = getIntent();
        numPlayers = toNewGame.getIntExtra("numPlayers",0);
        yourNum = toNewGame.getIntExtra("yourNum",0);
        p1Name = toNewGame.getStringExtra("p1Name");
        p2Name = toNewGame.getStringExtra("p2Name");
        p3Name = toNewGame.getStringExtra("p3Name");
        p4Name = toNewGame.getStringExtra("p4Name");
        p5Name = toNewGame.getStringExtra("p5Name");
        p6Name = toNewGame.getStringExtra("p6Name");
        p7Name = toNewGame.getStringExtra("p7Name");
        p8Name = toNewGame.getStringExtra("p8Name");
        p9Name = toNewGame.getStringExtra("p9Name");
        p10Name = toNewGame.getStringExtra("p10Name");
    }
}
