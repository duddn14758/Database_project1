package com.player;

public class Player {
	private String name;
	private double rate;
	private int number;
	private String team;
	private int running;
	public Player(String team,String name,double rate,int number) {
		this.team=team;
		this.name=name;
		this.rate=rate;
		this.number=number;
	}
	public Player() {
		
	}
	public String getTeam() {
		return team;
	}
	public double getRate() {
		return rate;
	}
	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public int getRunning() {
		return running;
	}
	public void init() {
		running=0;
	}
	public boolean setRunning(int num) {
		running+=num;
		if(running>4) {
			System.out.println(this.name+"홈인!");
			running=0;
			return true;
		}
		return false;
	}
	
}
