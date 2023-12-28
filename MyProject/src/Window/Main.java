package Window;

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
import Controller.Window;

public class Main implements Window{
	private String filePath = "src/files";
	private Charset charSet = StandardCharsets.UTF_8;
	@Override
	public void init() {
	}

	@Override
	public boolean update() {
		printMenu();
		System.out.println("[1] GAME START");
		System.out.println("[2]   S H O P ");
		System.out.println("[3]   OPTION  ");
		System.out.println("[4]     END   ");
		
		GameController.getInstance().setNext("Open");
		return true;
	}

	private void printMenu() {
		Path path = Paths.get(filePath, "Title.txt");
		String data = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()),charSet))){
			while(true) {
				data = br.readLine();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (data == null)break;
				System.out.println(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
