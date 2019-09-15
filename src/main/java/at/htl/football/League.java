package at.htl.football;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class League {
    List<Team> teams = new ArrayList<>();

    public void addMatchResult(Match match) {
        Team guestTeam = findOrCreateTeam(match.getGuestName());
        Team homeTeam = findOrCreateTeam(match.getHomeName());
        guestTeam.addMatch(match);
        homeTeam.addMatch(match);
    }

    public List<Team> getTable() {
        Collections.sort(teams);
        return teams;
    }

    protected Team findOrCreateTeam(String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }

        Team team = new Team(teamName);
        teams.add(team);
        return team;
    }
}
