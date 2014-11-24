package items;

import java.io.*;

public interface Item {

	
	int number = 0; //item number
	String name = "Undefined"; //Item name
	File icon = null; //location of the icon
	String description = "Undefined Item"; //description/tooltip for the item
	ItemType type = null; //the type of item
	
	int durabilityMax = 0; //the max durability of item OR the number of uses it starts with
	int durabilityCur = 0; //the current durability of item OR the number of uses it has left
	
	boolean stackable = false; //can this item be stacked?
	int maxStack = 1;  //How many can we stack?
	
	/**
	 * Returns either the current or max durability of an item
	 * @param MaxCur If true then max will be returned, if false the current will be returned.
	 * @return the current or max durability of the item
	 */
	public int durability(boolean MaxCur);
	public void fix();
	public void damage();
	
	public int maxStack();
}
