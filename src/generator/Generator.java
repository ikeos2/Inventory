package generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import items.*;

public class Generator {
	/**
	 * 
	 * psudocode
	 * 
	 * 
	 * function generate(int n, itemtype type){ load base item file names for
	 * type load prefixes for item type load suffixes for item type Generate n
	 * many items of given type return array list of items. }
	 * 
	 * 
	 * 
	 * 
	 */

	/**
	 * Generates N many items of given type
	 * 
	 * @param n
	 *            number of items to generate
	 * @param type
	 *            the type of item to generate
	 * @return an arraylist of N many items
	 */
	public static ArrayList<Item> Generate(int n, ItemType type) {
		ArrayList<Item> list = new ArrayList<Item>(n);
		
		// Read the files in
		String[] buffer = {};
		try {
			buffer = readFile(type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//seperate the files again
		String base = buffer[0]; //lists all the possible base items out
		String mod = buffer[1];
		
		//create variables to store our prefixes and suffixes
		ItemModifier[] prefixes = {}; //list of all possible prefixes
		ItemModifier[] suffixes = {}; //list of all possible suffixes
		int p = 0;
		int s = 0;
		
		//split 'base' into an array of items
		String[] buffer3 = base.split("\n");
		
		for(int i = 0; i<buffer3.length; i++){
			//Weapon base file: Name ; number ; icon ; type ; durabilityMax
			
		}
		
		//split 'mod' into suffixes and prefixes
		String[] buffer1 = mod.split("\n"); //split the buffer ball
		
		for(int i =0; i < buffer1.length; i++){
			
			String[] buffer2 = buffer1[i].split(" ; ");
			//seperate out the prefixes
			if(buffer1[i].charAt(0) == 0){
				prefixes[p] = new ItemModifier(buffer2[1], Integer.parseInt(buffer2[2]), Integer.parseInt(buffer2[3]), Boolean.parseBoolean(buffer2[4]), Integer.parseInt(buffer2[5]), Integer.parseInt(buffer2[0]));
				p++;
			}
			//seperate out the suffixes
			if(buffer1[i].charAt(0) == 1){
				suffixes[s] = new ItemModifier(buffer2[1], Integer.parseInt(buffer2[2]), Integer.parseInt(buffer2[3]), Boolean.parseBoolean(buffer2[4]), Integer.parseInt(buffer2[5]), Integer.parseInt(buffer2[0]));
				s++;
			}
			
		}
		
		/*************************
		 * Important things to remember
		 * ItemModifier Array
		 *  -prefixes
		 *  -suffixes
		 * String Array
		 *  -base
		 *************************/
		
		//generate the items
		for(int i = 0; i < n; i++){
			
		}
		
		return list;
	}

	
	/**
	 * 
	 * @param type The itemtype of item you would like generate(ie WEAPON, ARMOR, MISC, etc)
	 * @return returns an array of 2 strings that contains the contents of the base and mod file for the given type
	 * @throws Exception should only happen if you give it an unsupported item type
	 */
	public static String[] readFile(ItemType type) throws Exception {
		FileReader base = null;
		FileReader mod = null;

		// allocating the files
		if (type == ItemType.ACCESSORY) {
			base = new FileReader("accessory.base");
			mod = new FileReader("accessory.mod");
		} else if (type == ItemType.WEAPON) {
			base = new FileReader("weapon.base");
			mod = new FileReader("weapon.mod");
		} else if (type == ItemType.ARMOR) {
			base = new FileReader("armor.base");
			mod = new FileReader("armor.mod");
		} else if (type == ItemType.CONSUMABLE) {
			base = new FileReader("consumable.base");
			mod = new FileReader("consumable.mod");
		} else if (type == ItemType.MISC) {
			base = new FileReader("misc.base");
			mod = new FileReader("misc.mod");
		} else {
			// unhandled type
			throw new Exception("Unhandled ItemType");
		}
		//load all the contents of the files into buffers
		String buffer[] = {};
		String baseF =  base.toString();
		String modF =  mod.toString();
		//close up the filereaders
		base.close();
		mod.close();
		//put the buffers into a masterbuffer
		buffer[0] = baseF;
		buffer[1] = modF;
		//return said masterbuffer
		return buffer;
	}
}
