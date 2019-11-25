package com.mycompany.discgolfapp;

public class Player {
    
    private String name;
    private int score;
    
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }
    
    public String Name() {
        return this.name;
    }
    
    public int Score() {
        return this.score;
    }
    
    public void AddScore(int score) {
        this.score += score;
    }
    
    public String PrintScore() {
        return this.name + ": " + this.score;
    }
}
