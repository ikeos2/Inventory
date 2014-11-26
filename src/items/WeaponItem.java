package items;

import java.io.File;

public class WeaponItem implements Item {
	int number = 0;
	File icon = null;
	String description = "Undefined Item";
	ItemType type = ItemType.WEAPON;
	String name = "Undefined";
	ItemModifier suffix = null;
	ItemModifier prefix = null;
	// stats
	int durabilityMax = 0; // the max durability of item OR the number of uses
							// it starts with
	int durabilityCur = 0; // the current durability of item OR the number of
							// uses it has left

	int damageDie = 0;
	int damageDieSides = 0;

	boolean broken = false;
	boolean stackable = false;
	int maxStack = 1;

	/***************************
	 * 
	 * Methods - Get/Set
	 * 
	 ***************************/

	public void damage(int amount) {
		durabilityCur -= amount;
		if (durabilityCur <= 0)
			broken = true;
	}

	public void damage() {
		durabilityCur -= 1;
		if (durabilityCur <= 0)
			broken = true;
	}

	public void fix(int amount) {
		durabilityCur += amount;
		if (durabilityCur > 0)
			broken = false;
	}

	public void fix() {
		durabilityCur = durabilityMax;
		if (durabilityCur > 0)
			broken = false;
	}

	/**
	 * Returns either the current or max durability of an item
	 * 
	 * @param MaxCur
	 *            If true then max will be returned, if false the current will
	 *            be returned.
	 * @return the current or max durability of the item
	 */
	public int durability(boolean MaxCur) {
		if (MaxCur == true)
			return durabilityMax;
		return durabilityCur;
	}

	public int maxStack() {
		return 1;
	} // weapons aren't stackable

	/**
	 * Creates a new weapon
	 * 
	 * @param gDurability
	 *            the maximum/current amount of durability an item has
	 * @param gDie
	 *            the number of dice used to determine the damage this weapon
	 *            does
	 * @param gDSides
	 *            the number of sides on the dice used to determine the damage
	 *            this weapon does
	 * @param gNumber
	 *            item #
	 * @param gName
	 *            item name
	 * @param gIcon
	 *            the icon for the item
	 * @param gDescription
	 *            description of the item
	 */
	public WeaponItem(int gDurability, int gDie, int gDSides, int gNumber,
			String gName, File gIcon, String gDescription,
			ItemModifier gSuffix, ItemModifier gPrefix) {
		number = gNumber;
		name = gName;
		icon = gIcon;
		description = gDescription;

		durabilityMax = gDurability;
		durabilityCur = gDurability;
		damageDie = gDie;
		damageDieSides = gDSides;

		prefix = gPrefix;
		suffix = gSuffix;

	}
	
	
	public void addModifier(int position, ItemModifier mod){
		if(position == 0){
			prefix = mod;
		}
		if(position == 1){
			suffix = mod;
		}
	}
}
