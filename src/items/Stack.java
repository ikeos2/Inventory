package items;

public class Stack {
	Item item; // the item the stack is made of
	int quantity; // number of items in the stack

	public int getQuantity() {
		return quantity;
	}

	public Item getItem() {
		return item;
	}

	/**
	 * add items to a stack
	 * 
	 * @param n
	 *            the number of items you wish to add
	 * @param gItem
	 *            the type of item you wish to add
	 * @return 0 - item was added successfully
	 * 		  -1 - different items or stack is full and no items were added
	 *         n - any positive num = n means the stack was filled with the given items and there was surplus
	 * 
	 */
	public int addItem(int n, Item gItem) {
		if (gItem != item) {
			return -1;
		} // items are not the same

		if (quantity + n > item.maxStack()) {
			quantity = item.maxStack();
			return n - item.maxStack();
		} // too many items

		quantity += n;
		return 0;
	}

	public Stack(Item gItem, int n) {
		item = gItem;
		quantity = n;
	}
}
