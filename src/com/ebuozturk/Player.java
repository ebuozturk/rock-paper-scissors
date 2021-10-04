package com.ebuozturk;

public class Player {
    private final String name;
    private Integer score = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }
    public void increaseScore(){
        this.score++;
    }

    @Override
    public String toString() {
        return String.format("%s score: %d",this.name,this.score);
    }
}
