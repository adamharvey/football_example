package com.itd.football_example;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.security.SecureRandom;

public class CupCompetition {
	private Map<FootballTeam,FootballTeam> fixtures;
	private List<Match> matches;
	
	CupCompetition(List<FootballTeam> teams) {
		fixtures = new LinkedHashMap<FootballTeam,FootballTeam>();
		matches = new LinkedList<Match>();
		loadFixtures(teams);
	}
	
	private void loadFixtures(List<FootballTeam> teams) {
		if(teams == null || teams.size() < 1) { return; }
		
		// Home team is key of Map; away team is value
		fixtures.put(teams.remove(new SecureRandom().nextInt(teams.size())),
					 teams.remove(new SecureRandom().nextInt(teams.size())));

		loadFixtures(teams);
	}
	
	private int allocateGoals(int teamSkill, int opponentSkill) {
		int diff = teamSkill-opponentSkill;
		int rnd = new SecureRandom().nextInt(999);
		if(isBetween(diff,45,54)) { 
			if(isBetween(rnd,0,24)) return 0;
			else if(isBetween(rnd,25,174)) return 1;
			else if(isBetween(rnd,175,424)) return 2;
			else if(isBetween(rnd,425,824)) return 3;
			else if(isBetween(rnd,825,924)) return 4;
			else if(isBetween(rnd,925,999)) return 5;
		} else if(isBetween(diff,35,44)) {
			if(isBetween(rnd,0,49)) return 0;
			else if(isBetween(rnd,50,474)) return 1;
			else if(isBetween(rnd,475,674)) return 2;
			else if(isBetween(rnd,675,874)) return 3;
			else if(isBetween(rnd,875,949)) return 4;
			else if(isBetween(rnd,950,999)) return 5;			
		} else if(isBetween(diff,25,34)) {
			if(isBetween(rnd,0,99)) return 0;
			else if(isBetween(rnd,100,674)) return 1;
			else if(isBetween(rnd,675,824)) return 2;
			else if(isBetween(rnd,825,924)) return 3;
			else if(isBetween(rnd,925,974)) return 4;
			else if(isBetween(rnd,975,999)) return 5;						
		} else if(isBetween(diff,15,24)) {
			if(isBetween(rnd,0,199)) return 0;
			else if(isBetween(rnd,200,759)) return 1;
			else if(isBetween(rnd,760,884)) return 2;
			else if(isBetween(rnd,885,959)) return 3;
			else if(isBetween(rnd,960,984)) return 4;
			else if(isBetween(rnd,985,999)) return 5;									
		} else if(isBetween(diff,5,14)) {
			if(isBetween(rnd,0,249)) return 0;
			else if(isBetween(rnd,250,824)) return 1;
			else if(isBetween(rnd,825,924)) return 2;
			else if(isBetween(rnd,925,974)) return 3;
			else if(isBetween(rnd,975,989)) return 4;
			else if(isBetween(rnd,990,999)) return 5;												
		} else if(isBetween(diff,-4,4)) {
			if(isBetween(rnd,0,299)) return 0;
			else if(isBetween(rnd,300,884)) return 1;
			else if(isBetween(rnd,885,959)) return 2;
			else if(isBetween(rnd,960,984)) return 3;
			else if(isBetween(rnd,985,994)) return 4;
			else if(isBetween(rnd,995,999)) return 5;															
		} else if(isBetween(diff,-5,-14)) {
			if(isBetween(rnd,0,399)) return 0;
			else if(isBetween(rnd,400,927)) return 1;
			else if(isBetween(rnd,928,977)) return 2;
			else if(isBetween(rnd,978,992)) return 3;
			else if(isBetween(rnd,993,997)) return 4;
			else if(isBetween(rnd,998,999)) return 5;																		
		} else if(isBetween(diff,-15,-24)) {
			if(isBetween(rnd,0,499)) return 0;
			else if(isBetween(rnd,500,961)) return 1;
			else if(isBetween(rnd,962,986)) return 2;
			else if(isBetween(rnd,987,996)) return 3;
			else if(isBetween(rnd,997,998)) return 4;
			else if(isBetween(rnd,999,999)) return 5;																					
		} else if(isBetween(diff,-25,-34)) {
			if(isBetween(rnd,0,599)) return 0;
			else if(isBetween(rnd,600,984)) return 1;
			else if(isBetween(rnd,985,994)) return 2;
			else if(isBetween(rnd,995,998)) return 3;
			else if(isBetween(rnd,999,999)) return 4;			
		} else if(isBetween(diff,-35,-44)) {
			if(isBetween(rnd,0,699)) return 0;
			else if(isBetween(rnd,700,992)) return 1;
			else if(isBetween(rnd,993,997)) return 2;
			else if(isBetween(rnd,998,999)) return 3;			
		} else if(isBetween(diff,-45,-54)) {
			if(isBetween(rnd,0,799)) return 0;
			else if(isBetween(rnd,800,996)) return 1;
			else if(isBetween(rnd,997,998)) return 2;
			else if(isBetween(rnd,999,999)) return 3;						
		}
		return 0;
	}
	
	public void playMatches() {
		for (Map.Entry<FootballTeam,FootballTeam> entry : fixtures.entrySet())
		{
			playMatch(entry.getKey(),entry.getValue());
		}		
	}
	
	public List<Match> getMatches() { return matches; }
	
	private void playMatch(FootballTeam team1, FootballTeam team2) {
		// Play Match is not complete until someone wins...
		Match match = new Match(team1,team2,allocateGoals(team1.getSkill(),team2.getSkill()),allocateGoals(team2.getSkill(),team2.getSkill()));
		if(match.getWinner() == null) { playMatch(team1,team2); }
		else { matches.add(match); }
	}
	
	private boolean isBetween(int x, int lower, int upper) {
		return lower <= x && x <= upper;
	}
	
	@Override 
	public String toString() {
		return fixtures.toString();
	}
}
