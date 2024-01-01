package DAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Controller.GameController;
import DTO.Map;
import Utils.Util;

public class MapDAO {
	List<Map> mapList = new ArrayList<Map>();
	private static MapDAO instance = new MapDAO();
	private GameController gc = GameController.getInstance(); 
	private Charset charSet = StandardCharsets.UTF_8;
	private String filePath = "src/files";
	private String curMap;
	MapDAO(){
		init();
		curMap = selectMap();
		setingMap();
	}
	
	public String[][] setingMap() {
		String[][] map;
		String[] temp = curMap.split("\n");
		map = new String[temp.length][];
		int idx = 0;
		for(String info : temp) {
			map[idx++] = info.split(",");
		}
		gc.setMap(map);
		return gc.getMap();
	}
	
	public static MapDAO getInstance() {
		return instance;
	}
	private void init() {
		loadMap("빌리지.txt");
	}
	private void loadMap(String FileName) {
		Path path = Paths.get(filePath, FileName);
		String data = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()),charSet))){
			String title = br.readLine();
			while(true) {
				String str = br.readLine();
				if (str == null)break;
				data += str + "\n";
			}
			mapList.add(new Map(title,data));
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	public String selectMap() {
		for(int i=0; i < mapList.size(); i++) {
			System.out.printf("[%d] [%s]\n",i+1,mapList.get(i).getName());
		}
		int input = Util.getValue("맵 선택 [0.뒤로가기]", 1, mapList.size())-1;
		return mapList.get(input).getMap();
	}
	
	

}
