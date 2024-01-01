package DTO;

public class NPC extends Unit{
	private int y;
	private int x;

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public NPC(int speed, int power, int boomCnt, String name,String mark) {
		super(speed, power, boomCnt, name, mark);
		// TODO Auto-generated constructor stub
	}

}
