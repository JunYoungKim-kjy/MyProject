package DAO;

import java.util.ArrayList;
import java.util.List;

import DTO.Player;
import Utils.Util;

public class PlayerDAO {
	private List<Player> pList;
	private static PlayerDAO instance = new PlayerDAO();
	public static PlayerDAO getInstance() {
		return instance;
	}
	PlayerDAO(){
		pList = new ArrayList<Player>();
		
		pList.add(new Player(4, 2, 2, "배찌", "🧸"));
		pList.add(new Player(2, 3, 3, "다오", "👻"));
		pList.add(new Player(2, 2, 4, "디지니","🎃"));
		pList.add(new Player(3, 3, 3, "마리드","👩‍"));
		
	}
	public void printPlayer() {
		int num = 1;
		for(Player p : pList) {
			System.out.println("["+num++ +"]" + p);
		}
	}
	public Player getPlayer() {
		printPlayer();
		int sel = Util.getValue("캐릭터 선택[0.뒤로가기]", 1, pList.size())-1;
		return pList.get(sel); 
	}

}
