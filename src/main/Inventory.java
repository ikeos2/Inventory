package main;

import items.*;
import generator.*;

public class Inventory {

	Bag first;
	Item sword;
	static WeaponItem[] items;
	
	public static void main(String[] args) {
		try {
			items = (WeaponItem[]) WeaponGenerator.Generate(2, ItemType.WEAPON);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(items);
	}

}
