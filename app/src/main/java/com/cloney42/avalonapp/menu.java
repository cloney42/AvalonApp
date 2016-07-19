package com.cloney42.avalonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
Button RAButton;
Button VCButton;
Button HTUButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        RAButton = (Button)findViewById(R.id.RAButton);
        VCButton = (Button)findViewById(R.id.VCButton);
        HTUButton = (Button)findViewById(R.id.HTUButton);
        RAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuToRA = new Intent(menu.this,RoleAssigner.class);
                menu.this.startActivity(menuToRA);
            }
        });
        VCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuToVC = new Intent(menu.this,VoteChecker.class);
                menu.this.startActivity(menuToVC);
            }
        });
        HTUButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuToHTU = new Intent(menu.this,HowToUse.class);
                menu.this.startActivity(menuToHTU);
            }
        });
    }
}
