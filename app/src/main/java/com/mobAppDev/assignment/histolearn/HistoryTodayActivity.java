package com.mobAppDev.assignment.histolearn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class HistoryTodayActivity extends AppCompatActivity  {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    HistoryAdapter adapter;
     ArrayList<HistoryEvent> mHistoryToday = new ArrayList<>();
    private ProgressDialog dialog;

    //sets view, runs initView, and obtains flash cards
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_card_main);
        initView();
        dialog = new ProgressDialog(this);
        getFlashCards();

    }

    // sets up flash cards
    public void initView() {
        recyclerView = findViewById(R.id.recyclerViewID);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HistoryAdapter(this, mHistoryToday);
        recyclerView.setAdapter(adapter);

    }

    // Obtains flashcards from API and is converted to String
    private void getFlashCards() {
        dialog.show();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://history.muffinlabs.com/date";
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
                        HistoryToday historyToday = gson.fromJson(response, HistoryToday.class);
                        List<HistoryEvent> events = historyToday.getData().getEvents();
                        mHistoryToday.clear();
                        mHistoryToday.addAll(events);
                        adapter.notifyDataSetChanged();
                    }
                }, errorListener);
        stringRequest.setTag("search");
        queue.add(stringRequest);
    }

    //Back button redirects to Home Page
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}