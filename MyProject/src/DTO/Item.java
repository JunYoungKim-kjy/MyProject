package DTO;

import DTO.Inventory.Part;

public class Item {
	private String name;
	private String type;
	private int speed;
	private int power;
	private int bCnt;
	
	public Item(String name,Part type, int speed, int power, int bCnt) {
		super();
		this.name = name;
		this.type = type+"";
		this.speed = speed;
		this.power = power;
		this.bCnt = bCnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public int getbCnt() {
		return bCnt;
	}
	public void setbCnt(int bCnt) {
		this.bCnt = bCnt;
	}
	
	
}
