package com.ebuozturk;

public class PlayerOption {

    private final Player player;
    private final GameOption option;

    public PlayerOption(Player player, GameOption option) {
        this.player = player;
        this.option = option;
    }

    public Player getPlayer() {
        return player;
    }

    public GameOption getOption() {
        return option;
    }
}
