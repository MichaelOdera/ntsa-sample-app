package com.example.drawers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LauncherActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.launcherButton)
    Button mLauncherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        ButterKnife.bind(this);

        mLauncherButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == mLauncherButton) {
            Intent launcherIntent = new Intent(LauncherActivity.this, MainActivity.class);
            startActivity(launcherIntent);
        }

    }
}
