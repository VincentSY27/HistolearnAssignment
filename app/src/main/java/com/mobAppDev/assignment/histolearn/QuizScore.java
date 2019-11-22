package com.mobAppDev.assignment.histolearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

// Obtains mark then displays message according to mark range
public class QuizScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);

        TextView prompt = (TextView) findViewById(R.id.prompt);
        TextView mark = (TextView) findViewById(R.id.mark);

        int quizScore = getIntent().getIntExtra("quizScore", 0);

        if (quizScore < 5) {
            prompt.setText("Oh No! \n You're on track to fail finals, study hard to make sure you pass!");

        } else if (quizScore >= 5 && quizScore < 8) {
            prompt.setText("Nice! \n A working progress. You're getting there!");

        } else if (quizScore >= 8) {
            prompt.setText("Amazing Work! Easy HD!");
        }

        mark.setText(quizScore + " / 10");

    }

    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
