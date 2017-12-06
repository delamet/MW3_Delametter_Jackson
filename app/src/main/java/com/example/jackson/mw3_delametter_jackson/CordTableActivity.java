package com.example.jackson.mw3_delametter_jackson;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CordTableActivity extends AppCompatActivity {

    private RecyclerView chordRecyclerView;
    private ArrayList<Chord> chordsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cord_table);
        chordRecyclerView = (RecyclerView) findViewById(R.id.chordList);
        getSupportActionBar().setTitle("Ukulele Chords");
        chordsList = new ArrayList<>();
        setChords();
        LinearLayoutManager layout = new LinearLayoutManager(getApplicationContext());
        chordRecyclerView.setLayoutManager(layout);
        chordRecyclerView.setAdapter(new ChordRecyclerViewAdapter());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                chordRecyclerView.getContext(),
                layout.getOrientation()
        );
        chordRecyclerView.addItemDecoration(dividerItemDecoration);

    }

    private void setChords () {
        ArrayList<Chord> tempList = new ArrayList<>();
        Chord aChord = new Chord("A", 2, 1, 0, 0);
        Chord bChord = new Chord("B", 4, 3, 2, 2);
        Chord cChord = new Chord("C", 0, 0, 0, 3);
        tempList.add(aChord);
        tempList.add(bChord);
        tempList.add(cChord);
        shuffleChords(tempList);
    }

    private void shuffleChords(ArrayList<Chord> list) {
        while(list.size() > 1) {
            // While there is at more than 1 chord in the list
            int randomNumber = (int) System.currentTimeMillis() % list.size();
            Chord chord = list.get(randomNumber);
            chordsList.add(chord);
            list.remove(randomNumber);
        }
        // There is only one chord in the list
        Chord chord = list.get(0);
        chordsList.add(chord);
    }

    private class ChordRecyclerViewAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chord_cell, parent, false);
            return new ChordViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ChordViewHolder chordViewHolder = (ChordViewHolder) holder;
            Chord chord = chordsList.get(position);
            chordViewHolder.setChord(chord);
        }

        @Override
        public int getItemCount() {
            return chordsList.size();
        }
    }

    private class ChordViewHolder extends RecyclerView.ViewHolder {

        private TextView chordNameView;
        private TextView fretView;
        private Chord chord;

        private ChordViewHolder(View itemView) {
            super(itemView);
            chordNameView = (TextView) itemView.findViewById(R.id.chordNameText);
            fretView = (TextView) itemView.findViewById(R.id.chordFretText);
        }

        private void setChord(Chord selectedChord) {
            chord = selectedChord;
            chordNameView.setText(chord.getChordName());
            fretView.setText(chord.getChordFretList());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = ChordActivity.getChordActivityIntent(chord, getApplicationContext());
                    startActivity(intent);
                }
            });
        }
    }
}
