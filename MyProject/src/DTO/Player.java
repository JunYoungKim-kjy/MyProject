package DTO;

public class Player extends Unit{
	private int x;
	private int y;
	Inventory inven = new Inventory();
	
	public Player(int speed, int power, int bombCnt, String name, String mark) {
		super(speed, power, bombCnt, name,mark);
	}
	
	public Inventory getInven() {
		return inven;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		if(inven.isWearItem()) {
			int addSpeed = inven.getAddSpeed();
			int addPower = inven.getAddPower();
			int addbCnt = inven.getAddBCnt();
			return "[이름 : %s] [스피드 :%d + (%d)][물줄기 :%d + (%d)][물풍선 :%d개 +(%d개)]".formatted(this.getName(),this.getSpeed(),addSpeed,this.getPower(),addPower,this.getBombCnt()+addbCnt);
		}
		return "[이름 : %s] [스피드 :%d][물줄기 :%d][물풍선 :%d개]".formatted(this.getName(),this.getSpeed(),this.getPower(),this.getBombCnt());
	}
	
}
