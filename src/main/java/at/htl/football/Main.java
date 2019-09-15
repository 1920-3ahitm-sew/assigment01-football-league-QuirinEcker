package at.htl.football;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    static League league;

    public static void main(String[] args) {
        league = new League();
        Path file = Paths.get("bundesliga-1819.csv");
        getDataOutOfFile(file);
        printTable(league.getTable());
    }

    private static void getDataOutOfFile(Path file) {
        boolean firstLine = true;

        try {
            for (String line : Files.readAllLines(file)) {
                if (!firstLine) {
                    String[] lineFragments = line.split(";");

                    String date = lineFragments[0];
                    String homeName = lineFragments[1];
                    String guestName = lineFragments[2];
                    String homeGoals = lineFragments[3];
                    String guestGoals = lineFragments[4];

                    league.addMatchResult(new Match(homeName, guestName, Integer.parseInt(homeGoals), Integer.parseInt(guestGoals)));
                } else {
                    firstLine = false;
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void printTable(List<Team> teams) {
        System.out.printf("%-20s %5s %5s %5s %5s %5s %5s %5s \n", "Team", "Pts", "W", "D", "L", "GF", "GA", "GD");

        for (Team team : teams) {
            System.out.printf("%-20s %5d %5d %5d %5d %5d %5d %5d \n", team.getName(), team.getPoints(), team.getWins(), team.getDraws(), team.getDefeats(), team.getGoalsShot(), team.getGoalsReceived(), team.getGoalDifference());
        }
    }
}
