package at.htl.football;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class MatchTest {

    @Test
    void test_League_addMatchResults() {
        League league = new League();

        league.addMatchResult(new Match("homeTeam", "guestTeam", 5, 7));

        assertThat(league.teams.get(0).getName(), is("guestTeam"));
        assertThat(league.teams.get(1).getName(), is("homeTeam"));
    }

    @Test
    void test_League_findOrCreateTeam_findExisting() {
        League league = new League();

        league.teams.add(new Team("team1"));
        league.teams.add(new Team("team2"));

        assertThat(league.findOrCreateTeam("team1").getName(), is("team1"));
        assertThat(league.findOrCreateTeam("team2").getName(), is("team2"));
    }

    @Test
    void test_Leaugue_findOrCreateTeam_createNew() {
        League league = new League();

        league.findOrCreateTeam("team1");
        league.findOrCreateTeam("team2");

        assertThat(league.findOrCreateTeam("team1").getName(), is("team1"));
        assertThat(league.findOrCreateTeam("team2").getName(), is("team2"));
    }

    @Test
    void test_Team_compareTo_greaterThan() {
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");

        team1.points = 10;
        team2.points = 5;

        assertThat(team2.compareTo(team1), greaterThan(0));

    }

    @Test
    void test_Team_compareTo_lessThan() {
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");

        team1.points = 10;
        team2.points = 5;

        assertThat(team1.compareTo(team2), lessThan(0));
    }

    @Test
    void test_Team_compareTo_equal() {
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");

        team1.points = 10;
        team2.points = 10;

        assertThat(team1.compareTo(team2), is(0));
    }

    @Test
    void test_Team_addMatch_goalsShot() {
        League league = new League();
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        Match match = new Match("team1", "team2", 5, 1);

        league.teams.add(team1);
        league.teams.add(team2);

        team1.addMatch(match);
        assertThat(team1.getGoalsShot(), is(5));
    }

    @Test
    void test_Team_addMatch_goalsReceived() {
        League league = new League();
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        Match match = new Match("team1", "team2", 5, 1);

        league.teams.add(team1);
        league.teams.add(team2);

        team1.addMatch(match);
        assertThat(team1.getGoalsReceived(), is(1));
    }

    @Test
    void test_Team_addMatch_win() {
        League league = new League();
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        Match match = new Match("team1", "team2", 5, 1);

        league.teams.add(team1);
        league.teams.add(team2);

        team1.addMatch(match);
        assertThat(team1.getWins(), is(1));
    }

    @Test
    void test_Team_addMatch_defeat() {
        League league = new League();
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        Match match = new Match("team1", "team2", 5, 1);

        league.findOrCreateTeam("team1");
        league.findOrCreateTeam("team2");

        team1.addMatch(match);
        team2.addMatch(match);
        assertThat(team2.getWins(), is(0));
        assertThat(team1.getWins(), is(1));
        assertThat(team1.getPoints(), is(3));
    }

    @Test
    void test_Team_addMatch_draw() {
        League league = new League();
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        Match match = new Match("team1", "team2", 5, 5);

        league.teams.add(team1);
        league.teams.add(team2);

        team2.addMatch(match);
        assertThat(team2.getDraws(), is(1));
    }

    @Test
    void test_Team_addMatch_pointsByWin() {
        League league = new League();
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        Match match1 = new Match("team1", "team2", 5, 1);
        Match match2 = new Match("team1", "team2", 5, 1);
        Match match3 = new Match("team1", "team2", 5, 1);
        Match match4 = new Match("team1", "team2", 5, 1);

        league.teams.add(team1);
        league.teams.add(team2);

        team1.addMatch(match1);
        team1.addMatch(match2);
        team1.addMatch(match3);
        team1.addMatch(match4);
        assertThat(team1.points, is(12));
    }

    @Test
    void test_Team_addMatch_pointsByDraw() {
        League league = new League();
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        Match match1 = new Match("team1", "team2", 5, 5);
        Match match2 = new Match("team1", "team2", 5, 5);
        Match match3 = new Match("team1", "team2", 5, 5);
        Match match4 = new Match("team1", "team2", 5, 5);

        league.teams.add(team1);
        league.teams.add(team2);

        team1.addMatch(match1);
        team1.addMatch(match2);
        team1.addMatch(match3);
        team1.addMatch(match4);
        assertThat(team1.points, is(4));
    }

    @Test
    void test_Team_addMatch_pointsByDefeat() {
        League league = new League();
        Team team1 = new Team("team1");
        Team team2 = new Team("team2");
        Match match1 = new Match("team1", "team2", 1, 5);
        Match match2 = new Match("team1", "team2", 1, 5);
        Match match3 = new Match("team1", "team2", 1, 5);
        Match match4 = new Match("team1", "team2", 1, 5);

        league.teams.add(team1);
        league.teams.add(team2);

        team1.addMatch(match1);
        team1.addMatch(match2);
        team1.addMatch(match3);
        team1.addMatch(match4);
        assertThat(team1.points, is(0));
    }
}