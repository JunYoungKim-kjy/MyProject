package DTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Inventory {
	
	List<Item> ownItem = new ArrayList<Item>(); 
	Map<Part,Item> curItem = new HashMap<Part,Item>();
	public enum Part{
		Necklace,Ring,Earring,Gloves,Shoes
	}
	Inventory(){
		curItem.put(Part.Necklace, null);
		curItem.put(Part.Earring, null);
		curItem.put(Part.Gloves, null);
		curItem.put(Part.Ring, null);
		curItem.put(Part.Shoes, null);
	}
	public List<Item> getOwnItem() {
		return ownItem;
	}
	public void setOwnItem(List<Item> ownItem) {
		this.ownItem = ownItem;
	}
	public Map<Part, Item> getCurItem() {
		return curItem;
	}
	public void setCurItem(Map<Part, Item> curItem) {
		this.curItem = curItem;
	}
	public boolean isWearItem() {
		
		if(curItem.get(Part.Necklace)!=null ||
		curItem.get(Part.Earring)!= null ||
		curItem.get(Part.Gloves)!= null ||
		curItem.get(Part.Ring) != null ||
		curItem.get(Part.Shoes)!= null){
			return true;
		}
		return false;
	}
	public int getAddSpeed() {
		int speed = 0;
		Iterator<Part> keys = curItem.keySet().iterator();
		while(keys.hasNext()) {
			Part  key = keys.next();
			Item value = curItem.get(key);
			if(value == null)continue;
			speed += value.getSpeed();
		}
		return speed; 
	}
	public int getAddPower() {
		int power = 0;
		Iterator<Part> keys = curItem.keySet().iterator();
		while(keys.hasNext()) {
			Part  key = keys.next();
			Item value = curItem.get(key);
			if(value == null)continue;
			power += value.getPower();
		}
		return power; 
	}
	public int getAddBCnt() {
		int bCnt = 0;
		Iterator<Part> keys = curItem.keySet().iterator();
		while(keys.hasNext()) {
			Part  key = keys.next();
			Item value = curItem.get(key);
			if(value == null)continue;
			bCnt += value.getbCnt();
		}
		return bCnt; 
	}
	
	
	
	
	
	
}
