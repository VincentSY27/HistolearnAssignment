package com.mobAppDev.assignment.histolearn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;

public class QuizMainActivity extends AppCompatActivity {

    private String type;
    private String url = "https://opentdb.com/api.php?amount=10&category=23&difficulty=";
    private ProgressDialog dialog;
    private List<QuestionBean> questionList;
    private int currentNum=0;
    private TextView tvTitle;
    private RadioButton rl_a;
    private RadioButton rl_b;
    private RadioButton rl_c;
    private RadioButton rl_d;
    private TextView questionNumber;
    private Button skip;
    private Button submit;
    private int quizScore;
    private RadioGroup myRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);
        tvTitle = findViewById(R.id.question);
        skip = findViewById(R.id.skip);
        questionNumber = findViewById(R.id.questionNumber);
        submit = findViewById(R.id.submit);
        myRadioGroup = findViewById(R.id.myRadioGroup);
        rl_a = (RadioButton)findViewById(R.id.radioButton);
        rl_b = (RadioButton)findViewById(R.id.radioButton2);
        rl_c = (RadioButton)findViewById(R.id.radioButton3);
        rl_d = (RadioButton)findViewById(R.id.radioButton4);
        dialog = new ProgressDialog(this);
        type = getIntent().getStringExtra("type").toLowerCase();
        url = url + type;
        getQuestion();
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum++;
                refreshQuestion();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionList==null&&questionList.size()==0){
                    return;
                }
                // checks to see if user's answer is correct
                String ok = questionList.get(currentNum).getCorrect_answer().toLowerCase();
                if (rl_a.isChecked()){
                    if (ok.equals(rl_a.getText().toString().toLowerCase())){
                        Toast.makeText(QuizMainActivity.this,"correct",Toast.LENGTH_SHORT).show();
                        quizScore++;
                    }else{
                        Toast.makeText(QuizMainActivity.this,"incorrect",Toast.LENGTH_SHORT).show();

                    }
                    check();

                }else if (rl_b.isChecked()){
                    if (ok.equals(rl_b.getText().toString().toLowerCase())){
                        Toast.makeText(QuizMainActivity.this,"correct",Toast.LENGTH_SHORT).show();
                        quizScore++;
                    }else{
                        Toast.makeText(QuizMainActivity.this,"incorrect",Toast.LENGTH_SHORT).show();

                    }
                    check();
                }else if (rl_c.isChecked()){
                    if (ok.equals(rl_c.getText().toString().toLowerCase())){
                        Toast.makeText(QuizMainActivity.this,"correct",Toast.LENGTH_SHORT).show();
                        quizScore++;
                    }else{
                        Toast.makeText(QuizMainActivity.this,"incorrect",Toast.LENGTH_SHORT).show();

                    }
                    check();
                }else if (rl_d.isChecked()){
                    if (ok.equals(rl_d.getText().toString().toLowerCase())){
                        Toast.makeText(QuizMainActivity.this,"correct",Toast.LENGTH_SHORT).show();
                        quizScore++;
                    }else{
                        Toast.makeText(QuizMainActivity.this,"incorrect",Toast.LENGTH_SHORT).show();

                    }
                    check();
                }
            }
        });
    }

    //if loop to provide questions then feedback page after the 10th
    private void check(){
        if(currentNum<9){
            currentNum++;
            refreshQuestion();
        }else{
            Intent intent = new Intent(QuizMainActivity.this,QuizScore.class);
            intent.putExtra("quizScore",quizScore);
            startActivity(intent);
            finish();
        }
    }
    private void getQuestion() {
        dialog.show();
        RequestQueue queue = Volley.newRequestQueue(this);
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();
            } };
        StringRequest stringRequest =
                new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();
                        Gson gson = new Gson();
                        QuestionResponse questionResponse = gson.fromJson(response, QuestionResponse.class);
                       if (questionResponse.getResponse_code()==0){
                           questionList = questionResponse.getResults();
                           refreshQuestion();
                       }

                    }
                }, errorListener);
        queue.add(stringRequest);
    }

    //prevents skipping on last question
    private void refreshQuestion() {
        myRadioGroup.clearCheck();
        if(currentNum==9){
            skip.setVisibility(View.GONE);
        }
        QuestionBean question = questionList.get(currentNum);
        tvTitle.setText(question.getQuestion());
        questionNumber.setText("Q"+(currentNum+1));
        if (question.getType().equals("boolean")){
            rl_a.setText("True");
            rl_b.setText("False");
            rl_d.setVisibility(View.GONE);
            rl_c.setVisibility(View.GONE);
        }else{
            List<String> incorrectList = question.getIncorrect_answers();
            incorrectList.add(question.getCorrect_answer());
            Collections.shuffle(incorrectList);

            rl_a.setText(incorrectList.get(0));
            rl_b.setText(incorrectList.get(1));
            rl_c.setText(incorrectList.get(2));
            rl_d.setText(incorrectList.get(3));

            rl_d.setVisibility(View.VISIBLE);
            rl_c.setVisibility(View.VISIBLE);
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
