package com.company;

import java.util.ArrayList;
import java.util.List;

public class Relay extends Thread {
    List<Team> teamName = new ArrayList<>();
    int count = 0;
    ArrayList<String> winner = new ArrayList<>();

    Relay(String[] teamNames, String[][] teamRunners) {
        for (String str : teamNames) {
            Team team = new Team();
            team.name = str;
            for (int i=0; i<4; i++) {
                team.runnerName.add(teamRunners[count][i]);
            }
            teamName.add(team);
            count++;
        }
    }

    public void run() {
        try {
            for(Team team : teamName) {
                Runner r1 = new Runner(team.runnerName.get(0),1,team);
                Runner r2 = new Runner(team.runnerName.get(1),r1,2,team,winner);
                Runner r3 = new Runner(team.runnerName.get(2),r2,3,team,winner);
                Runner r4 = new Runner(team.runnerName.get(3),r3,4,team,winner);

                r1.start();
                r2.start();
                r3.start();
                r4.start();
            }
            sleep(500);
            System.out.println("Победила команда " + winner.get(0));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
