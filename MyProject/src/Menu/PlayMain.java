package Menu;

import Controller.GameController;
import Controller.MenuCommand;
import DTO.Player;
import Utils.Util;

public class PlayMain implements MenuCommand {
	
	
	@Override
	public void init() {
		
	}

	@Override
	public boolean update() {
		if(GameController.getInstance().getCurPlayer() == null) {
			System.out.println("캐릭터를 먼저 골라주세요.");
			GameController.getInstance().setNext(GameController.Menu.PLAYCHANGEPLAYER.getName());
			return true;
		}
		printCurPlayer();
		printMenu();
		int sel= Util.getValue("메뉴 선택", 0, 4);
		if(sel==0) {
			return false;
		}else if(sel == 1) {
			GameController.getInstance().setNext(GameController.Menu.GAMESTART.getName());
		}else if(sel == 2) {
			GameController.getInstance().setNext(GameController.Menu.PLAYINVENTORY.getName());
		}else if(sel == 3) {
			GameController.getInstance().setNext(GameController.Menu.PLAYSHOP.getName());
		}else if(sel == 4) {
			GameController.getInstance().setNext(GameController.Menu.PLAYCHANGEPLAYER.getName());
		}
		return true;
	}
	private void printCurPlayer() {
		System.out.println("=========================");
		System.out.println(GameController.getInstance().getCurPlayer());
		System.out.println("=========================");
	}
	
	private void printMenu() {
		System.out.println("[1] Game Start");
		System.out.println("[2]  인벤토리 가기");
		System.out.println("[3]  상점으로 가기");
		System.out.println("[4]  캐릭터 변경");
		System.out.println("[0]   게임 종료");
	}

}
