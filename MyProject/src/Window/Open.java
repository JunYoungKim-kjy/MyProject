package Window;

import Controller.GameController;
import Controller.Window;

public class Open implements Window {

	@Override
	public void init() {
		
	}

	@Override
	public boolean update() {
		
		GameController.getInstance().setNext("Main");
		return true;
	}

}
