package Menu;

import Controller.GameController;
import Controller.MenuCommand;
import DTO.NPC;
import DTO.Player;
import Map.Map;

public class PlayGame implements MenuCommand {
	Player p;
	NPC n;
	String curMap;

	@Override
	public void init() {
		p = GameController.getInstance().getCurPlayer();
		n = GameController.getInstance().getNPC();
		curMap = Map.getInstance().selectMap();
	}

	@Override
	public boolean update() {
		
		GameController.getInstance().setNext("Main");
		return true;
	}

}
