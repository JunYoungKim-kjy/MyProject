package Menu;

import Controller.GameController;
import Controller.MenuCommand;
import DTO.Player;

public class PlayMain implements MenuCommand {
	Player curPlayer;
	
	@Override
	public void init() {
		
	}

	@Override
	public boolean update() {
		if(curPlayer == null) {
			System.out.println("캐릭터를 먼저 골라주세요.");
			GameController.getInstance().setNext(GameController.Menu.PLAYCHANGEPLAYER.getName());
		}
		return false;
	}

}
