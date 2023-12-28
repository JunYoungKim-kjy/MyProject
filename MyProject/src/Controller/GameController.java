package Controller;

import java.util.HashMap;
import java.util.Map;

import Window.*;


public class GameController {
	public enum window {
		MAIN("Main"),GAMESTART("GameStart"),SHOP("Shop"),OPTION("Option");
		
		private String name;
		window(String name){
			this.name = name;
		}
		public String getName() {
			return name;
		}
		
	}
	private String next="";
	private static  GameController instance = new GameController();
	private Map<String,Window> windowList = new HashMap<String, Window>();
	private GameController() {
		init();
	}
	
	public static GameController getInstance() {
		return instance;
	}
	private void init() {
		windowList.put("Main", new Main());
		windowList.put("gameStart", new GameStart());
		windowList.put("Open", new Open());
		
		this.next = "Main"; 
	}
	public void setNext(String next) {
		this.next=next;
	}
	public void run() {
		while(true) {
			Window window = windowList.get(next);
			window.init();
			if(!window.update())break;
		}
		
	}
}
