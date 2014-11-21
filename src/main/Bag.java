package main;

import items.Item;
import java.util.ArrayList;

public class Bag {
	int size;
	ArrayList<Item> items;
	
	/**
	 * Attempts to add item to the inventory
	 * @param item the item to be added
	 * @return if the item was successfully added returns 1; else returns 0
	 */
	public boolean addItem(Item item){
		if(items.size() >= size){
			return false;
		}
		
		items.add(item);
		return true;
	}
	
	/**
	 * Removes an item from the bag
	 * @param item the item to be removed
	 * @return if the item was successfully removed returns 1; else returns 0
	 */
	public boolean removeItem(Item item){
		if(items.contains(item)){
			items.remove(item);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Creates a bag with given size
	 * @param givenSize number of item slots in said bag
	 */
	public Bag(int givenSize){
		size = givenSize;
	}
	
	/**
	 * Creates a bag with given size
	 * @param givenSize number of item slots in said bag
	 * @param givenItems A list of items, must be able to fit inside bag.
	 */
	public Bag(int givenSize, ArrayList<Item> givenItems){
		size = givenSize;
		if(givenItems.size() > size){ 
			throw new IllegalArgumentException("Too many items in given items");
		}
		items = givenItems;
	}
	
}
