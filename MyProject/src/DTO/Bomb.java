package DTO;

import Controller.GameController;

public class Bomb {
	private int y;
	private int x;
	private String name;
	private int power;
	private int timer;
	private Unit owner; 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	public Bomb(int y, int x, String name, int power,Unit owner) {
		super();
		this.y = y;
		this.x = x;
		this.name = name;
		this.power = power;
		this.owner = owner;
	}
	public int getTimer() {
		return timer;
	}
	public void setTimer(int timer) {
		this.timer = timer;
	}
	public Unit getOwner() {
		return owner;
	}
	

//	void run() {
//		private void boom(int bY,int bX, int power) {
//			for(int i= 0; i< power ; i+=1) {
//				int y = bY+i;
//				int x = bX+i;
//				if(bY+i < 0 || bY+i >map.length)continue;
//				if(bX+i < 0 || bX+i >map[0].length)continue;
//				if(map[y][x].equals("P")){
//					System.out.println("플레이어 죽음");
//					return;
//				}
//				if(map[y][x].equals("N")) {
//					System.out.println("NPC 죽음");
//					return;
//				}
//				if(!map[y][x].equals("RH")||!map[y][x].equals("BH")||!map[y][x].equals("YH")||!map[y][x].equals("T")) {
//					map[y][x] = "0";
//				}
//				switch (map[y][x]) {
//				case "P" : System.out.println("플레이어 죽음");
//							break;
//				case "N" : System.out.println("NPC 죽음");
//							break;
//				case "PnB" : boom(y,x,power);
//							break;
//				case "PB" : boom(y,x,power);
//							break;
//				case "NB" : boom(y, x, GameController.getInstance().getNPC().getPower());
//							break;
//				}
//				if(map[y][x].equals("PnB")||map[y][x].equals("PB")) {
//					boom(y, x, power);
//				}
//				if(map[y][x].equals("NB")) {
//					boom(y, x, GameController.getInstance().getNPC().getPower());
//				}
//				map[bY][bX+y]
				
//			}
//			
//			
//		}
//	}
//	
	
}
