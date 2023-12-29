package Menu;

import Controller.GameController;
import Controller.MenuCommand;
import DAO.MapDAO;
import DTO.NPC;
import DTO.Player;
import Utils.Util;

public class PlayGame implements MenuCommand {
	private Player p;
	private NPC n;
	private String curMap;
	private int pX;
	private int pY;
	private int nX;
	private int nY;
	private String[][] map;

	@Override
	public void init() {
		p = GameController.getInstance().getCurPlayer();
		n = GameController.getInstance().getNPC();
		curMap = MapDAO.getInstance().selectMap();
		setMap();
		setUnit();
		
	}
	private void setUnit() {
		int playerLimit = 5;
		int NPCLimit = map[0].length-5;
		while(true) {
			int rY = Util.rd.nextInt(map.length);
			int rX = Util.rd.nextInt(playerLimit);
			if(!map[rY][rX].equals("0")) {
				continue;
			}
			map[rY][rX] = "P";
			pY = rY;
			pX = rX;
			break;
		}
		while(true) {
			int rY = Util.rd.nextInt(map.length);
			int rX = Util.rd.nextInt(5)+NPCLimit;
			if(!map[rY][rX].equals("0")) {
				continue;
			}
			map[rY][rX] = "N";
			nY = rY;
			nX = rX;
			break;
		}
	}
	private boolean action(String key) {
		int pX = this.pX;
		int pY = this.pY;
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
			if(!installBoom())return false;
			Thread boomTimer = new Thread(()->{
				boom(this.pY,this.pX,p.getPower());
				
			});
			
			
			
			
		} else {
			return false;
		}
		
		if(map[this.pY][this.pX].equals("PnB")) {
			map[this.pY][this.pX] = "PB";
		}else {
			map[this.pY][this.pX] = "0";
		}
		this.pY = pY;
		this.pX = pX;
		map[this.pY][this.pX] = "P";
		
		return true;
		
		
	}
	private void boom(int bY,int bX, int power) {
		for(int i= 0; i< power ; i+=1) {
			int y = bY+i;
			int x = bX+i;
			if(bY+i < 0 || bY+i >map.length)continue;
			if(bX+i < 0 || bX+i >map[0].length)continue;
			if(map[y][x].equals("P")){
				System.out.println("플레이어 죽음");
				return;
			}
			if(map[y][x].equals("N")) {
				System.out.println("NPC 죽음");
				return;
			}
			if(!map[y][x].equals("RH")||!map[y][x].equals("BH")||!map[y][x].equals("YH")||!map[y][x].equals("T")) {
				map[y][x] = "0";
			}
			switch (map[y][x]) {
			case "P" : System.out.println("플레이어 죽음");
						break;
			case "N" : System.out.println("NPC 죽음");
						break;
			case "PnB" : boom(y,x,power);
						break;
			case "PB" : boom(y,x,power);
						break;
			case "NB" : boom(y, x, GameController.getInstance().getNPC().getPower());
						break;
			}
//			if(map[y][x].equals("PnB")||map[y][x].equals("PB")) {
//				boom(y, x, power);
//			}
//			if(map[y][x].equals("NB")) {
//				boom(y, x, GameController.getInstance().getNPC().getPower());
//			}
//			map[bY][bX+y]
			
		}
		
		
	}
	private boolean installBoom() {
		int installY = this.pY;
		int installX = this.pX;
		int power = GameController.getInstance().getCurPlayer().getPower();
		map[installY][installX] = "PnB";
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
			
			
			
		}		

	}
	@Override
	public boolean update() {
		run();
		GameController.getInstance().setNext("Main");
		return true;
	}
	private void setMap() {
		String[] temp = curMap.split("\n");
		map = new String[temp.length][];
		int idx = 0;
		for(String info : temp) {
			map[idx++] = info.split(",");
		}
	}
	private void printMap() {
		for(String[] x : map) {
			for(String y : x) {
				if(y.equals("0")) {
					System.out.printf("  ");
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
class Boom implements Runnable{
	int y;
	int x;
	int power;
	String[][] map;
	Boom(int y, int x,int power,String[][] map){
		this.y=y;
		this.x=x;
		this.power=power;
		this.map = map;
	}
	
	@Override
	public void run() {
		for(int i= 0; i< power ; i+=1) {
			int y = bY+i;
			int x = bX+i;
			if(bY+i < 0 || bY+i >map.length)continue;
			if(bX+i < 0 || bX+i >map[0].length)continue;
			if(map[y][x].equals("P")){
				System.out.println("플레이어 죽음");
				return;
			}
			if(map[y][x].equals("N")) {
				System.out.println("NPC 죽음");
				return;
			}
			if(!map[y][x].equals("RH")||!map[y][x].equals("BH")||!map[y][x].equals("YH")||!map[y][x].equals("T")) {
				map[y][x] = "0";
			}
			switch (map[y][x]) {
			case "P" : System.out.println("플레이어 죽음");
						break;
			case "N" : System.out.println("NPC 죽음");
						break;
//			case "PnB" : Boom(y,x,power);
//						break;
//			case "PB" : boom(y,x,power);
//						break;
//			case "NB" : boom(y, x, GameController.getInstance().getNPC().getPower());
//						break;
			}
//			if(map[y][x].equals("PnB")||map[y][x].equals("PB")) {
//				boom(y, x, power);
//			}
//			if(map[y][x].equals("NB")) {
//				boom(y, x, GameController.getInstance().getNPC().getPower());
//			}
//			map[bY][bX+y]
			
		}
		
	}
	
}
