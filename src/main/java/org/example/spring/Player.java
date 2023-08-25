package org.example.spring;

import java.util.ArrayList;

public class Player {
    public enum VARIANTS {
        ROCK, PAPER, SCISSORS
    }
    private String name;
    private VARIANTS var;
    public Player() {
        this.name = "bot";
        this.var = getRandomVariant();
    }
    public Player(VARIANTS var, String name) {
        this.var = var;
        this.name = name;
    }
    private VARIANTS getRandomVariant() {
        int x = (int) (Math.random() * 3);
        switch (x) {
            case 0:
                return VARIANTS.ROCK;
            case 1:
                return VARIANTS.PAPER;
            default:
                return VARIANTS.SCISSORS;
        }
    }
    public int whoWin(Player p1, Player p2) {
        System.out.println(p1.name + " выбор " + p1.var);
        System.out.println(p2.name + " выбор " + p2.var);
        ArrayList<VARIANTS> arr = new ArrayList<>();
        arr.add(VARIANTS.ROCK);
        arr.add(VARIANTS.PAPER);
        arr.add(VARIANTS.SCISSORS);
        int index1 = arr.indexOf(p1.var);
        int index2 = arr.indexOf(p2.var);
        if (index1 == index2) {
            return 1;
        }
        else if ((index1 - index2) == 1 || (index1 - index2) == -2) {
            return 2;
        }
        else if((index1-index2==-1)||(index1-index2==2)) {
            return 3;
        }
        return 0;
        }
}