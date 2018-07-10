package com.game;

import java.util.ArrayList;

import com.player.Player;

public class BaseBallgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player p1 = new Player("롯데", "손아섭", 0.3, 1);
		Player p2 = new Player("롯데", "김주찬", 0.3, 2);
		Player p3 = new Player("롯데", "이대호", 0.4, 3);
		Player p4 = new Player("롯데", "번즈", 0.2, 4);
		Player batter=new Player();

		ArrayList<Player> p=new ArrayList<>();		//주자
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		
		
		int outcount = 0;
		int ining = 1;
		int rand;			//안타확률
		int hit_rand;		//1,2,3루타, 홈런확률
		int hit = 0;		//득점
		int score = 0;		//점수
		int current=0;		//타자번호
		int team=0;
		boolean get;		//득점하였는가?

		System.out.println(ining + "이닝");

		while (ining != 10) {
			switch(current) {
			case 0:batter=p.get(0);break;
			case 1:batter=p2;break;
			case 2:batter=p3;break;
			case 3:batter=p4;break;
			}
			for(int i=0;i<4;i++) {
				p.get(i).init();
			}
			
			System.out.println("타석 : "+batter.getNumber()+"번타자 "+batter.getName());
			double rate = batter.getRate();
			rand = (int) (Math.random() * 10);
			rate *= 10;
			if (rate > rand) {
				hit_rand = (int) (Math.random() * 10);
				if (hit_rand <= 1) {
					System.out.print(batter.getName());
					System.out.println("홈런");
					hit=4;
				} else if (hit_rand > 1 && hit_rand <= 3) {
					System.out.print(batter.getName());
					System.out.println("3루타");
					hit=3;
				} else if (hit_rand <= 6) {
					System.out.print(batter.getName());
					System.out.println("2루타");
					hit=2;
				} else {
					System.out.print(batter.getName());
					System.out.println("1루타");
					hit=1;
				}
			} else {
				System.out.println(batter.getName() + "아웃!");
				outcount++;
			}
			batter.setRunning(hit);

			current=(current+1)%4;
			
			for(int i=0;i<4;i++) {
				if(p.get(i).getRunning()>0) {
					if(p.get(i).setRunning(hit)) {						
						score++;
						System.out.println("현재스코어 : " +score);
					}
				}
			}
			
			

			if (outcount == 3) {
				outcount = 0;
				ining++;
				hit=0;
				if(ining==10) {
					System.out.println("최종점수 : "+score);
					break;
				}
				
				

				System.out.println("이닝교체\n");
				System.out.println("현재점수 : " + score);
				System.out.println(ining + "이닝----------------------");
				try {
					Thread.sleep(1000); // 1초 대기
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			try {
				Thread.sleep(1000); // 1초 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
