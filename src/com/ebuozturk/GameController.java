package com.ebuozturk;


import java.util.Random;
import java.util.Scanner;

public class GameController {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    private String wantToPlay = "y";
    private Integer totalRound= 0;


    public void start(){
        printWelcomeMessage();

        Player player = getNameFromPlayer();
        Player comp = new Player("Computer");

        do{
            totalRound++;

            PlayerOption playerOption  = new PlayerOption(player,selectOption());
            PlayerOption computerOption = new PlayerOption(comp,GameOption.getGameOption(random.nextInt(3)+1));

            Integer result  = GameOption.compareOptions(playerOption.getOption(),computerOption.getOption());

            if(result.equals(1)){
                player.increaseScore();
                printResults(playerOption,computerOption,false);
            }
            else if(result.equals(0)){
                comp.increaseScore();
                printResults(computerOption,playerOption,false);
            }
            else{
                printResults(computerOption,playerOption,true);
            }
            printTotalScoreAndPlayersScore(player,comp);
            stillWantToPlay();
        }
        while(wantToPlay.toLowerCase().equals("y"));

    }

    public void printWelcomeMessage(){
        System.out.println("\n         WELCOME\n"+
                              "           TO\n"+
                            "   ROCK-PAPER-SCISSORS\n");
    }

    public void printResults(PlayerOption winner,PlayerOption loser,Boolean isTie){
        if(isTie)
            System.out.println("\n"+"--------TIE!--------");
        else
            System.out.println("\n"+"--------"+winner.getPlayer().getName().toUpperCase()+" WIN!--------");
        System.out.println(winner.getPlayer().getName()+" played "+winner.getOption());
        System.out.println(loser.getPlayer().getName()+" played "+loser.getOption());
    }

    public Boolean isStringBetween1To3(String str){
        return str.matches("1|2|3");
    }

    public void printTotalScoreAndPlayersScore(Player player, Player comp){
        System.out.println("\n"+
                "TOTAL GAMES PLAYED: "+totalRound+"\n"+
                            player+"\n"+
                            comp+"\n"+
                            "Tie: "+(totalRound-(player.getScore()+comp.getScore()))
                );
    }

    public void stillWantToPlay(){
        System.out.println("\n"+
                "DO YOU WANT TO PLAY AGAIN?"+"\n"+
                        "Y-Yes  N-No"

        );
        wantToPlay = scanner.next();

        if(!wantToPlay.toLowerCase().equals("y") && !wantToPlay.toLowerCase().equals("n")){
            setWantToPlay(wantToPlay);
        }
    }

    public void setWantToPlay(String choice){
        this.wantToPlay = choice;
    }

    public Player getNameFromPlayer(){
        System.out.println("Enter a name:");
        String name = scanner.nextLine();

        if(name.length() >0){
            return new Player(name);
        }
        else {
            return getNameFromPlayer();
        }
    }

    public GameOption selectOption(){
        System.out.println(
                "\n"+
                "1.ROCK"+"\n"+
                "2.PAPER"+"\n"+
                "3.SCISSORS"
                );
        String option = scanner.nextLine();
        if(isStringBetween1To3(option))
            return GameOption.getGameOption(Integer.valueOf(option));
        else
            return selectOption();
    }



}
