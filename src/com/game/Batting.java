package com.game;

import com.player.Player;

public class Batting {
	public int rand;
	public Batting(Player p) {
		double rate=p.getRate();
		rand=(int)(Math.random()*10);
		rate*=10;
		if(rate>rand) {		
		}
		
	}
}
