package com.company;

import java.util.ArrayList;

public class Runner extends Thread {
    String name, teamName;
    Runner other;
    int number;
    int count = 0;
    ArrayList<String> winner;

    Runner(String name, Runner other, int number, Team team, ArrayList<String> winner) {
        this.name = name;
        this.number = number;
        this.other = other;
        this.winner = winner;
        this.teamName = team.name;
    }

    Runner(String name,int number, Team team) {
        this.name = name;
        this.number = number;
        this.other = null;
        this.teamName = team.name;
        this.winner = null;
    }

    public void run() {
        try {
            if(other != null) {
                System.out.println(name + " ждёт " + other.name);
                other.join();
            }
            System.out.println(name +  " начинает бежать ");
            while (count < 60) {
                ++count;
                System.out.println(name + " бежит " + count + " метров");
                Thread.yield();
                if(number == 4 && count == 60){
                    winner.add(teamName);
                }
            }
            sleep((long) (Math.random() * 10));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
