package generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import items.*;

public class WeaponGenerator {

	/**
	 * Generates N many items of given type
	 * 
	 * @param n
	 *            number of items to generate
	 * @param type
	 *            the type of item to generate
	 * @return an arraylist of N many items
	 * @throws Exception
	 */
	public static Item[] Generate(int n, ItemType type) throws Exception {
		Item[] list = {};

		// Read the files in
		String[] buffer = {};
		try {
			buffer = readFile(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// seperate the files again
		String base = buffer[0]; // lists all the possible base items out
		String mod = buffer[1];

		// create variables to store our base, prefixes, and suffixes
		WeaponItem[] items = {};
		ItemModifier[] prefixes = {}; // list of all possible prefixes
		ItemModifier[] suffixes = {}; // list of all possible suffixes
		int p = 0;
		int s = 0;

		// split 'base' into an array of items
		String[] buffer3 = base.split("\n");
		//iterate through all the items and create items for each
		for (int i = 0; i < buffer3.length; i++) {
			items[i] = new WeaponItem(Integer.parseInt(buffer3[1]),
					Integer.parseInt(buffer3[2]), Integer.parseInt(buffer3[3]),
					Integer.parseInt(buffer3[4]), buffer3[0], new File(
							buffer3[5]), buffer3[6], null, null);
		}

		// split 'mod' into suffixes and prefixes
		String[] buffer1 = mod.split("\n"); // split the buffer ball

		for (int i = 0; i < buffer1.length; i++) {

			String[] buffer2 = buffer1[i].split(" ; ");
			// seperate out the prefixes
			if (buffer1[i].charAt(0) == 0) {
				prefixes[p] = new ItemModifier(buffer2[1],
						Integer.parseInt(buffer2[2]),
						Integer.parseInt(buffer2[3]),
						Boolean.parseBoolean(buffer2[4]),
						Integer.parseInt(buffer2[5]),
						Integer.parseInt(buffer2[0]));
				p++;
			}
			// seperate out the suffixes
			if (buffer1[i].charAt(0) == 1) {
				suffixes[s] = new ItemModifier(buffer2[1],
						Integer.parseInt(buffer2[2]),
						Integer.parseInt(buffer2[3]),
						Boolean.parseBoolean(buffer2[4]),
						Integer.parseInt(buffer2[5]),
						Integer.parseInt(buffer2[0]));
				s++;
			}

		}

		/*************************
		 * Important things to remember ItemModifier Array -prefixes -suffixes
		 * Item Array -base
		 *************************/
		Random rand = new Random();

		// generate the items
		for (int i = 0; i < n; i++) {
			/**
			 * TODO: this ONLY works for weapons at the moment psudo code
			 * Determine if it gets a prefix(1 in 10) - add rules for this and
			 * line below for things like potions which will have no
			 * prefix/suffix Determine if it gets a suffixes( 1 in 5) pick an
			 * item add prefix + suffix to item add item to list
			 * 
			 */
			int pre = rand.nextInt(10) + 1;
			int suf = rand.nextInt(5) + 1;
			WeaponItem temp = null;
			ItemModifier temp2 = null;//prefix
			ItemModifier temp3 = null; //suffix

			if (pre == 2) {
				// there is a prefix
				temp2 = prefixes[rand.nextInt(prefixes.length) + 1];
			}
			if (suf == 5) {
				// there is a suffix
				temp3 = suffixes[rand.nextInt(suffixes.length) + 1];
			}

			temp = items[rand.nextInt(items.length) + 1];
			temp.addModifier(0, temp2);
			temp.addModifier(1, temp3);

		}

		return list;

	}

	/**
	 * 
	 * @param type
	 *            The itemtype of item you would like generate(ie WEAPON, ARMOR,
	 *            MISC, etc)
	 * @return returns an array of 2 strings that contains the contents of the
	 *         base and mod file for the given type
	 * @throws Exception
	 *             should only happen if you give it an unsupported item type
	 */
	public static String[] readFile(ItemType type) throws Exception {
		FileReader base = null;
		FileReader mod = null;

		// allocating the files

		base = new FileReader("weapon.base");
		mod = new FileReader("weapon.mod");

		// load all the contents of the files into buffers
		String buffer[] = {};
		String baseF = base.toString();
		String modF = mod.toString();
		// close up the filereaders
		base.close();
		mod.close();
		// put the buffers into a masterbuffer
		buffer[0] = baseF;
		buffer[1] = modF;
		// return said masterbuffer
		return buffer;
	}
}