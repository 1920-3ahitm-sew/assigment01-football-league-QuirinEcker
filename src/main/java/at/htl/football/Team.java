package at.htl.football;

public class Team implements Comparable<Team> {
    private String name;
    protected int points;
    private int wins;
    private int draws;
    private int defeats;
    private int goalsShot;
    private int goalsReceived;

    public Team(String name) {
        this.name = name;
    }

    public void addMatch(Match match) {
        int guestGoals = match.getGuestGoals();
        int homeGoals = match.getHomeGoals();

        if (match.getHomeName().equals(this.name)) {
            // homeTeam
            this.goalsShot += homeGoals;
            this.goalsReceived += guestGoals;

            if (homeGoals > guestGoals) {
                this.wins++;
            } else if (homeGoals < guestGoals) {
                this.defeats++;
            } else {
                this.draws++;
            }
        } else if (match.getGuestName().equals(this.name)){
            // guestTeam
            this.goalsShot += guestGoals;
            this.goalsReceived += homeGoals;

            if (guestGoals > homeGoals) {
                this.wins++;
            } else if (guestGoals < homeGoals) {
                this.defeats++;
            } else {
                this.draws++;
            }
        }

        this.points = this.wins * 3 + this.draws;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public int getGoalDifference() {
        return this.goalsShot - this.goalsReceived;
    }

    @Override
    public int compareTo(Team o) {
        if (this.points > o.points) {
            return -1;
        }  else if (this.points < o.points) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
