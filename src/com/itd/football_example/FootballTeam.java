package com.itd.football_example;

public class FootballTeam {
	
	private String name;
	private int skill;
	
	public FootballTeam(String name, int skill) {
		this.name = name;
		this.skill = skill;
	}
	
	public String getName() { return name; }
	
	public int getSkill() { return skill; }
	
	@Override
	public String toString() {
		return "Name:  " + name + " : Skill:  " + skill;
	}

}
