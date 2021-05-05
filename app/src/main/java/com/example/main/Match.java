package com.example.main;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import chess.Board;

public class Match implements java.io.Serializable {
    public String name;
    public LocalDate date;
    public ArrayList<Board> moves;

    public Match(String n, ArrayList<Board> b) {
        this.name = n;
        this.date = java.time.LocalDate.now();
        this.moves = b;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String toString() {
        return this.name;
    }


}
