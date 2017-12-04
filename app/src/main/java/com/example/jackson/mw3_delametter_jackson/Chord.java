package com.example.jackson.mw3_delametter_jackson;

/**
 * Created by Jackson on 12/3/2017.
 */

public class Chord {

    private String chordName;
    private String string1;
    private String string2;
    private String string3;
    private String string4;

    public Chord(String chordName, int string4, int string3, int string2, int string1) {
        this.chordName = chordName;
        this.string4 = string4 + "";
        this.string3 = string3 + "";
        this.string2 = string2 + "";
        this.string1 = string1 + "";
    }

    public String getChordName() {
        return chordName;
    }

    public String getChordFretList() {
        return (string4 + string3 + string2 + string1) + "";
    }

}
