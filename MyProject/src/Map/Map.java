package Map;

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

import Utils.Util;

public class Map {
	List<String> mapList = new ArrayList<String>();
	private static Map instance = new Map(); 
	private static Charset charSet = StandardCharsets.UTF_8;
	private static String filePath = "src/Files";
	
	Map(){
		init();
	}
	
	public static Map getInstance() {
		return instance;
	}
	private void init() {
		loadMap("map1.txt");
	}
	private void loadMap(String FileName) {
		Path path = Paths.get(filePath, FileName);
		String data = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()),charSet))){
			while(true) {
				String str = br.readLine();
				if (str == null)break;
				data += str + "\n";
			}
			mapList.add(data);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public String selectMap() {
		int input = Util.getValue("맵 선택", 0, mapList.size());
		return mapList.get(input);
	}
	

}
