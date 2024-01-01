package DTO;

public abstract class Unit {
	private int speed;
	private int power;
	private int bombCnt;
	private int curBobmCnt;
	private String name;
	private String mark;
	private boolean dead;
	
	public Unit(int speed, int power, int bombCnt, String name, String mark) {
		super();
		this.speed = speed;
		this.power = power;
		this.bombCnt = bombCnt;
		this.name = name;
		this.mark = mark;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
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


	public int getBombCnt() {
		return bombCnt;
	}


	public void setBombCnt(int bombCnt) {
		this.bombCnt = bombCnt;
	}


	public int getCurBobmCnt() {
		return curBobmCnt;
	}


	public void setCurBobmCnt(int curBobmCnt) {
		this.curBobmCnt = curBobmCnt;
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
