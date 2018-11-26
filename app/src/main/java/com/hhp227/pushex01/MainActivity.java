package com.hhp227.pushex01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    PlayView playView;
    ImageButton up, left, down, right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playView = findViewById(R.id.playView);
        up = findViewById(R.id.U_button);
        left = findViewById(R.id.L_button);
        down = findViewById(R.id.D_button);
        right = findViewById(R.id.R_button);

        up.setOnClickListener(this);
        left.setOnClickListener(this);
        down.setOnClickListener(this);
        right.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.U_button :
                playView.up();
                break;
            case R.id.L_button :
                playView.left();
                break;
            case R.id.D_button :
                playView.down();
                break;
            case R.id.R_button :
                playView.right();
                break;
        }
    }
}
