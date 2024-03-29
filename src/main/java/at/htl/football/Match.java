package at.htl.football;

public class Match {

    private String homeName;
    private String guestName;
    private int homePoints;
    private int guestPoints;
    private int homeGoals;
    private int guestGoals;

    public Match(String homeName, String guestName, int homeGoals, int guestGoals) {
        this.homeName = homeName;
        this.guestName = guestName;
        this.homeGoals = homeGoals;
        this.guestGoals = guestGoals;
    }

    public String getHomeName() {
        return homeName;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getHomePoints() {
        return homePoints;
    }

    public int getGuestPoints() {
        return guestPoints;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getGuestGoals() {
        return guestGoals;
    }
}
