package DTO;

public abstract class Unit {
	private int speed;
	private int power;
	private int boomCnt;
	private String name;
	private String mark;
	
	public Unit(int speed, int power, int boomCnt, String name, String mark) {
		super();
		this.speed = speed;
		this.power = power;
		this.boomCnt = boomCnt;
		this.name = name;
		this.mark = mark;
	}


	public int getSpeed() {
		return speed;
	}


	public void setSpeed(int speed) {
		this.speed = speed;
	}


	public int getPower() {
		return power;
	}


	public void setPower(int power) {
		this.power = power;
	}


	public int getBoomCnt() {
		return boomCnt;
	}


	public void setBoomCnt(int boomCnt) {
		this.boomCnt = boomCnt;
	}


	public String getName() {
		return name;
	}


	public String getMark() {
		return mark;
	}


	@Override
	public String toString() {
		return " [ " + name + " ] ";
	}
	
	
	
	

}
