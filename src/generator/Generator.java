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
	public ArrayList<Item> Generate(int n, ItemType type) {
		ArrayList<Item> list = new ArrayList<Item>(n);
		String baseItems[];
		String prefixes[];
		String suffixes[];

		if (type == ItemType.ACCESSORY) {

		} else if (type == ItemType.WEAPON) {

		} else if (type == ItemType.ARMOR) {

		} else if (type == ItemType.CONSUMABLE) {

		} else if (type == ItemType.MISC) {

		} else {
			// unhandled type
			return list;
		}

		return list;
	}

	public String readFile(String Location) throws IOException {
		FileReader in = null;
		
		try {
			in = new FileReader(Location);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String buffer = in.toString();
		in.close();
		return buffer;
	}
}
