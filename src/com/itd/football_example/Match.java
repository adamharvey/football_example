package com.itd.football_example;

public class Match {
	private FootballTeam team1;
	private int team1Goals;
	private FootballTeam team2;
	private int team2Goals;
	
	public Match(FootballTeam team1, FootballTeam team2, int team1Goals, int team2Goals) {
		this.team1 = team1;
		this.team2 = team2;
		this.team1Goals = team1Goals;
		this.team2Goals = team2Goals;
	}
	
	public FootballTeam getWinner() {
		if(team1Goals == team2Goals) return null;
		return team1Goals > team2Goals ? team1 : team2;
	}
	
	@Override
	public String toString() {
		return team1.getName() + "(" + team1.getSkill() + ")" + " vs. " + team2.getName() + "(" + team2.getSkill() + ")" + "goals:  " + team1Goals + "/" + team2Goals + "\n";
	}
}
