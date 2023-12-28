package _Main;

import Controller.GameController;

public class Main {

	public static void main(String[] args) {
		GameController gc = GameController.getInstance();
		gc.run();
	}

}
