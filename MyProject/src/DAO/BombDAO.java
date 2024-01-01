package DAO;

import java.util.ArrayList;
import java.util.List;

import Controller.GameController;
import DTO.Bomb;
import DTO.Unit;

public class BombDAO {
	private GameController gc = GameController.getInstance();
	private List<Bomb> bombList = new ArrayList<Bomb>();
	private static BombDAO instance = new BombDAO();
	
	private BombDAO() {}
	public static BombDAO getInstance() {
		return instance;
	}
	public Bomb plantBomb(int y, int x,int power,Unit owner) {
		Bomb b = new Bomb(y,x,"PB", power,owner);
		bombList.add(b);
		return b;
	}
	public void boom(Bomb b) {
		String[][]map = gc.getMap();
		for(int i=-b.getPower();i<b.getPower();i++) {
			int y = b.getY()+i;
			int x = b.getX()+i;
			if(y < 0 || y > map.length || x < 0 || x > map[0].length)continue;
			if(map[y][b.getX()].equals("P")||map[b.getY()][x].equals("P")){
				gc.getCurPlayer().setDead(true);
			}
			if(map[y][b.getX()].equals("N")||map[b.getY()][x].equals("N")) {
				gc.getNPC().setDead(true);
			}
			if(map[y][b.getX()].equals("I")||map[b.getY()][x].equals("I")) {
				
			}
			if(map[y][b.getX()].equals("B")||map[b.getY()][x].equals("B")||
				map[y][b.getX()].equals("BnP")||map[b.getY()][x].equals("BnN")){
				
			}
		}
		
		b.getOwner().setCurBobmCnt(b.getOwner().getCurBobmCnt()-1);
		bombList.remove(b);
	}
	
	public void checkBomb() {
		System.out.println(bombList.size());
		for(int i=0; i < bombList.size() ; i++) {
			bombList.get(i).setTimer(bombList.get(i).getTimer()+1);
			if(bombList.get(i).getTimer()>=5) {
				boom(bombList.get(i));
			}
		}
	}
}
