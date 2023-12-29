package Controller;

import java.util.HashMap;
import java.util.Map;

import DTO.NPC;
import DTO.Player;
import Menu.*;


public class GameController {
	public static enum Menu {
		MAIN("Main"),
		GAMESTART("GameStart"),
		PLAYMAIN("PlayMain"),
		PLAYSHOP("PlayShop"),
		PLAYINVENTORY("PlayInventory"),
		PLAYCHANGEPLAYER("ChangePlayer"),
		OPTION("Option"),
		CHANGEMODE("ChangeMode");
		
		private String name;
		Menu(String name){
			this.name = name;
		}
		public String getName() {
			return name;
		}
		
	}
	private Player curPlayer;
	private NPC NPC;
	private String next="";
	private static  GameController instance = new GameController();
	private Map<String,MenuCommand> windowList = new HashMap<String, MenuCommand>();
	private GameController() {
		init();
	}
	
	public static GameController getInstance() {
		return instance;
	}
	public NPC getNPC() {
		return NPC;
	}
	private void init() {
		windowList.put(Menu.MAIN.getName(), new Main());
		windowList.put(Menu.GAMESTART.getName(), new PlayGame());
		windowList.put(Menu.PLAYMAIN.getName(), new PlayMain());
		windowList.put(Menu.PLAYCHANGEPLAYER.getName(), new PlayChangePlayer());
		windowList.put(Menu.PLAYSHOP.getName(), new PlayShop());
		windowList.put(Menu.PLAYINVENTORY.getName(), new PlayInventory());
		windowList.put(Menu.OPTION.getName(), new OptionMain());
		windowList.put(Menu.CHANGEMODE.getName(), new OptionChangeMode());
		NPC = new NPC(1, 1, 1, "탱구" , "옷");
		this.next = "Main"; 
	}
	public void setNext(String next) {
		this.next=next;
	}
	public void run() {
		while(true) {
			MenuCommand window = windowList.get(next);
			window.init();
			if(!window.update())break;
		}
		
	}
	public void setCurPlayer(Player p) {
		this.curPlayer = p;
	}
	public Player getCurPlayer() {
		return curPlayer;
	}
}
