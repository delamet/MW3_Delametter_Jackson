package com.example.jackson.mw3_delametter_jackson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jackson on 12/3/2017.
 */

public class ChordActivity extends AppCompatActivity {

    private ImageView[][] dots;
    private TextView chordNameView;
    private Chord chord;
    private static String CHORD_ID = "chord_id";

    public static Intent getChordActivityIntent(Chord chord, Context context) {
        Intent intent = new Intent(context, ChordActivity.class);
        intent.putExtra(CHORD_ID, chord);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord);
        chordNameView = (TextView) findViewById(R.id.chordNameView);
        Intent intent = getIntent();
        chord = (Chord) intent.getSerializableExtra(CHORD_ID);
        chordNameView.setText(chord.getChordName());
        getDots();
        setDots(chord);
    }

    private void getDots() {
        dots = new ImageView[4][5];
        for(int i=1;i<=4;i++) {
            for(int j=1;j<=5;j++) {
                String idName = "d_" + i + "_" + j;
                int dotID = getResources().getIdentifier(idName, "id", getPackageName());
                ImageView dot = (ImageView) findViewById(dotID);
                dot.setVisibility(View.INVISIBLE);
                dots[i-1][j-1] = dot;
            }
        }
    }

    private void setDots(Chord chord) {
        setDotVisibility(1, Integer.parseInt(chord.getString1()));
        setDotVisibility(2, Integer.parseInt(chord.getString2()));
        setDotVisibility(3, Integer.parseInt(chord.getString3()));
        setDotVisibility(4, Integer.parseInt(chord.getString4()));
    }

    private void setDotVisibility(int stringNum, int fretNum) {
        if(fretNum != 0) {
            ImageView dot = dots[stringNum - 1][fretNum - 1];
            dot.setVisibility(View.VISIBLE);
        }
    }
}
