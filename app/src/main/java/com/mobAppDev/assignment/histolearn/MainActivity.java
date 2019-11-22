package com.mobAppDev.assignment.histolearn;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Loads cardViews upon starting
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

        CardView Flashcards = findViewById(R.id.flashcards);
        CardView Quiz = findViewById(R.id.quiz);
        CardView Videos = findViewById(R.id.videos);

        Flashcards.setOnClickListener(this);
        Quiz.setOnClickListener(this);
        Videos.setOnClickListener(this);

    }

    //switch cases for when user clicks on a cardView (feature)
    @Override
    public void onClick(View view) {

        Intent intent = null;

        switch (view.getId()) {
            case R.id.flashcards: intent = new Intent(getApplicationContext(), HistoryTodayActivity.class);
                break;

            case R.id.quiz:
                choose();
                break;

            case R.id.videos: intent = new Intent(getApplicationContext(), Additional_Resources_Menu.class);
                break;

            default: break;
        }

        if (intent != null){
            try {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);

            } catch (Exception e){
                System.out.println("Caught e");
            }
        }
    }

    // Alert Screen implemented so user can choose difficulty for quiz
    private void choose() {
        final String[] diff = {"Easy","Medium","Hard"};
        new AlertDialog.Builder(this)
                .setTitle("Select Difficulty")
                .setSingleChoiceItems(diff, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent  intent = new Intent(getApplicationContext(), QuizMainActivity.class);
                        intent.putExtra("type",diff[which]);
                        startActivity(intent);
                    }
                }).create().show();
    }

}

