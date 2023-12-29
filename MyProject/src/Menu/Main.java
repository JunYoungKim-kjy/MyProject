package Menu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import Controller.GameController;
import Controller.MenuCommand;
import Utils.Util;

public class Main implements MenuCommand{
	private String filePath = "src/files";
	private Charset charSet = StandardCharsets.UTF_8;
	@Override
	public void init() {
	}

	@Override
	public boolean update() {
		Util.printMenu();
		System.out.println("[1]   P L A Y ");
		System.out.println("[2]   OPTION  ");
		System.out.println("[0]     END   ");
		
		int sel = Util.getValue("메뉴 선택", 0, 2);
		if (sel==0) {
			return false;
		}else if(sel== 1) {
			GameController.getInstance().setNext(GameController.Menu.PLAYMAIN.getName());
		}else if(sel== 2) {
			GameController.getInstance().setNext(GameController.Menu.OPTION.getName());
		}
		
		return true;
	}

		
}
