package Menu;

import Controller.GameController;
import Controller.MenuCommand;

public class PlayGame implements MenuCommand {

	@Override
	public void init() {
		
	}

	@Override
	public boolean update() {
		
		GameController.getInstance().setNext("Main");
		return true;
	}

}
