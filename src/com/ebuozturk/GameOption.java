package com.ebuozturk;

public enum GameOption {
    ROCK(1,3),PAPER(2,1),SCISSORS(3,2),EMPTY(0,0);

    private final Integer id;
    private final Integer canBeat;

    GameOption(Integer id, Integer canBeat) {
        this.id = id;
        this.canBeat = canBeat;
    }

    public static GameOption getGameOption(Integer id){
        for(GameOption option : GameOption.values()){
            if(option.getId() == id){
                return option;
            }
        }
        return EMPTY;
    }
    public static Integer compareOptions(GameOption op1, GameOption op2){
        if(op1.getId() == op2.getCanBeat()){
            return 0;
        }
        else if(op1.getCanBeat() == op2.getId()){
            return 1;
        }
        else{
            return -1;
        }
    }

    public int getId() {
        return id;
    }

    public int getCanBeat() {
        return canBeat;
    }

}
