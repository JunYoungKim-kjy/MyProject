package Menu;

import Controller.MenuCommand;

public class OptionMain implements MenuCommand {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update() {
		System.out.println("[1] NPC 난이도 업");
		System.out.println("[2] NPC 난이도 다운");
		System.out.println("[0] 뒤로가기");
		return false;
	}

}
