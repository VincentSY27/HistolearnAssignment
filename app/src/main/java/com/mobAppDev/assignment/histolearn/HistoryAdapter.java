package com.mobAppDev.assignment.histolearn;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

//Recyclerview adapter: enables a default cardView screen to be used multiple times
//Creates views for items
public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private ArrayList<HistoryEvent> adapterList;
    Context mContext;

    public HistoryAdapter(Context context, ArrayList<HistoryEvent> adapterList) {
        this.adapterList = adapterList;
        this.mContext = context;
    }

    //Constructs a RecyclerView.ViewHolder
    //Sets the view it uses to display its contents
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flashcardlist, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    //Binds Data to the position of the flashcard
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        final HistoryEvent flashcard = adapterList.get(position);
        viewHolder.bindFlashCard(adapterList.get(position));

    }

    //Finds out number of items in adapter
    @Override
    public int getItemCount() {
        return adapterList.size();
    }

    //subclass constructor for an item view
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView topic;
        TextView fact;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            topic = itemView.findViewById(R.id.topic_view);
            fact = itemView.findViewById(R.id.fact_view);
            cardView = itemView.findViewById(R.id.cardView);
        }

        public void bindFlashCard(HistoryEvent adapterList) {
            topic.setText(adapterList.getYear());
            fact.setText(adapterList.getText());
        }

    }
}
