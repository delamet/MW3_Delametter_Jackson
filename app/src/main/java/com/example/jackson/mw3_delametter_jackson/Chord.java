package com.example.jackson.mw3_delametter_jackson;

import java.io.Serializable;

/**
 * Created by Jackson on 12/3/2017.
 */

public class Chord implements Serializable{

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

    public String getString1() {
        return string1;
    }

    public String getString2() {
        return string2;
    }

    public String getString3() {
        return string3;
    }

    public String getString4() {
        return string4;
    }
}
