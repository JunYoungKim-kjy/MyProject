package Menu;

import Controller.GameController;
import Controller.MenuCommand;
import DAO.PlayerDAO;

public class PlayChangePlayer implements MenuCommand {

	@Override
	public void init() {
		
	}

	@Override
	public boolean update() {
		GameController.getInstance().setCurPlayer(PlayerDAO.getInstance().getPlayer());
		
		
		
		
		GameController.getInstance().setNext(GameController.Menu.PLAYMAIN.getName());
		return true;
	}

}
