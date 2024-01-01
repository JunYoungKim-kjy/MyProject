package Menu;

import Controller.GameController;
import Controller.MenuCommand;
import DAO.BombDAO;
import DAO.MapDAO;
import DTO.Bomb;
import DTO.NPC;
import DTO.Player;
import Utils.Util;

public class PlayGame implements MenuCommand{
	private Player p;
	private NPC n;
	private MapDAO mapDAO;
	private BombDAO bombDAO;
	private int turn; 
	private GameController gc;
	private String[][] map;

	@Override
 	public void init() {
		gc = GameController.getInstance();
		p = GameController.getInstance().getCurPlayer();
		n = GameController.getInstance().getNPC();
		bombDAO = BombDAO.getInstance();
		mapDAO = MapDAO.getInstance();
		map = mapDAO.setingMap();
		setUnit();
		
	}
	private void setUnit() {
		int playerLimit = 5;
		int NPCLimit = map[5].length-5;
		while(true) {
			int rY = Util.rd.nextInt(map.length);
			int rX = Util.rd.nextInt(playerLimit);
			if(!map[rY][rX].equals("0")) {
				continue;
			}
			map[rY][rX] = "P";
			p.setY(rY);
			p.setX(rX);
			break;
		}
		while(true) {
			int rY = Util.rd.nextInt(map.length);
			int rX = Util.rd.nextInt(5)+NPCLimit;
			if(!map[rY][rX].equals("0")) {
				continue;
			}
			map[rY][rX] = "N";
			n.setY(rY);
			n.setX(rX);
			break;
		}
	}
	private boolean action(String key) {
		int pY = p.getY();
		int pX = p.getX();
		if (key.equals("w")) {
			if (pY < 1)	return false;
			pY-=1;
			if (!map[pY][pX].equals("0"))return false;
		} else if (key.equals("a")) {
			if (pX < 1)	return false;
			pX-=1;
			if (!map[pY][pX].equals("0"))return false;
		} else if (key.equals("s")) {
			if (pY > map.length-2)	return false;
			pY+=1;
			if (!map[pY][pX].equals("0"))return false;
		} else if (key.equals("d")) {
			if (pX > map[0].length-2)	return false;
			pX+=1;
			if (!map[pY][pX].equals("0"))return false;
		} else if (key.equals("g")) {
			if(!plantBoom())return false;
			return true;
		} else {
			return false;
		}
		
		if(map[p.getY()][p.getX()].equals("PnB")) {
			map[p.getY()][p.getX()] = "PB";
		}else {
			map[p.getY()][p.getX()] = "0";
		}
		p.setY(pY);
		p.setX(pX);
		map[p.getY()][p.getX()] = "P";
		
		return true;
		
		
	}
	private boolean plantBoom() {
		if(p.getCurBobmCnt()>=p.getBombCnt() || map[p.getY()][p.getX()].equals("PnB")||map[p.getY()][p.getX()].equals("B")) {
			System.err.println("설치 불가");
			return false;
		}
		
		Bomb b = bombDAO.plantBomb(p.getY(),p.getX(),p.getPower(),p);
		map[b.getY()][b.getX()]="PnB";
		p.setCurBobmCnt(p.getCurBobmCnt() + 1);
		return true;
		
	}
	private void run() {
		while (true) {
			printMap();
			System.out.println("     상(w)");
			System.out.println("좌(a) 하(s) 우(d)");
			System.out.println("폭탄놓기 (g)");
			System.out.println("=================================");
			String input = Util.getValue("입력 :");
			if(!action(input))continue;
			bombDAO.checkBomb();
			if(checkPLife()) {
				System.out.println("플레이어 사망");
				return;
			}else if (checkNLife()) {
				System.out.println("NPC 사망");
			}
		}		
	}
	private boolean checkPLife(){
		if(gc.getCurPlayer().isDead()) {
			return true;
		}
		return false;
	}
	private boolean checkNLife(){
		if(gc.getNPC().isDead()) {
			return true;
		}
		return false;
	}
	@Override
	public boolean update() {
		run();
		GameController.getInstance().setNext("Main");
		return true;
	}
	
	private void printMap() {
		for(String[] x : gc.getMap()) {
			for(String y : x) {
				if(y.equals("0")) {
					System.out.printf("  ");
				}else if(y.equals("RH")) {
					System.out.printf("🎪");
				}else if(y.equals("BH")){
					System.out.printf("🎪");
				}else if(y.equals("YH")) {
					System.out.printf("🎪");
				}else if(y.equals("T")) {
					System.out.printf("🎄");
				}else if(y.equals("P")) {
					System.out.printf(p.getMark());
				}else if(y.equals("N")) {
					System.out.printf(n.getMark());
				}else if(y.equals("PB")) {
					System.out.printf("💣");
				}else if(y.equals("NB")) {
					System.out.printf("💣");
				}else if(y.equals("PnB")) {
					System.out.printf("😱");
				}
				
			}
			System.out.println();
		}
	}
	



}
