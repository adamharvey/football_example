package com.itd.football_example;

import java.util.LinkedList;
import java.util.List;

public class FootballExample {

	public static void main(String[] args) {
		List<FootballTeam> teams = new LinkedList<FootballTeam>();
		teams.add(new FootballTeam("Arsenal", 90));
		teams.add(new FootballTeam("Manchester United", 91));
		teams.add(new FootballTeam("West Ham United", 78));
		teams.add(new FootballTeam("Liverpool", 89));
		teams.add(new FootballTeam("Tottenham Hotspur", 87));
		teams.add(new FootballTeam("Aston Villa", 76));
		teams.add(new FootballTeam("Stoke City", 81));
		teams.add(new FootballTeam("Manchester City", 92));
		teams.add(new FootballTeam("Norwich City", 73));
		teams.add(new FootballTeam("Ipswich Town", 67));
		teams.add(new FootballTeam("Middlesbrough", 69));
		teams.add(new FootballTeam("Fulham", 63));
		teams.add(new FootballTeam("Rotherham United", 52));
		teams.add(new FootballTeam("Swindon Town", 48));
		teams.add(new FootballTeam("Coventry City", 50));
		teams.add(new FootballTeam("Yeovil Town", 36));
		
		CupCompetition comp8 = new CupCompetition(teams);
		comp8.playMatches();
		
		System.out.println("comp8:  " + comp8.toString());
		
		List<Match> matches = comp8.getMatches();
		
		System.out.println("First Round:  " + matches.toString());
		
		teams = new LinkedList<FootballTeam>();
		for(Match match : matches) {
			teams.add(match.getWinner());
		}
		CupCompetition comp4 = new CupCompetition(teams);
		comp4.playMatches();
		
		System.out.println("comp4:  " + comp4.toString());
		
		matches = comp4.getMatches();
		
		System.out.println("Second Round:  " + matches.toString());
		
		teams = new LinkedList<FootballTeam>();
		for(Match match : matches) {
			teams.add(match.getWinner());
		}
		CupCompetition comp2 = new CupCompetition(teams);
		comp2.playMatches();

		System.out.println("comp2:  " + comp2.toString());		
		
		matches = comp2.getMatches();
		
		System.out.println("Third Round:  " + matches.toString());		
		
		teams = new LinkedList<FootballTeam>();
		for(Match match : matches) {
			teams.add(match.getWinner());
		}
		
		CupCompetition finalComp = new CupCompetition(teams);
		finalComp.playMatches();
		
		System.out.println("finalComp:  " + finalComp.toString());
		
		matches = finalComp.getMatches();
		
		System.out.println("Final Round:  " + matches.toString());		
		
		teams = new LinkedList<FootballTeam>();
		for(Match match : matches) {
			teams.add(match.getWinner());
		}
		
		// Teams should now contain the final winner!
		System.out.println(teams);
	}
}
