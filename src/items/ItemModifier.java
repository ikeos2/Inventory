package items;

public class ItemModifier {
	String modifier;
	int location;
	int additionalDamageDie;
	int additionalDamage;
	boolean unbreakable;
	int additionalDurability;

	public ItemModifier(String name, int Die, int Damage, boolean Break,
			int dur, int location) {
		modifier = name;
		additionalDamageDie = Die;
		additionalDamage = Damage;
		unbreakable = Break;
		additionalDurability = dur;
		this.location = location;
	}

	
	/**
	 * Uses some prebuilt and hard coded values for testing purposes
	 * @param n selector for which prebuilt to use for debug purposes.
	 */
	public ItemModifier(int n) {
		String name = null;
		int Die = 0;
		int Damage = 0;
		boolean Break = false;
		int dur = 0;
		int location = 0;

		if (n == 1) {
			name = "Of the Bear";
			Die = 1;
			Damage = 0;
			Break = false;
			dur = 10;
			location = 2;
		}

		else if (n == 2) {
			name = "Unbreakable";
			Die = 0;
			Damage = 0;
			Break = true;
			dur = 0;
			location = 1;
		}
		
		if (n == 3) {
			name = "Of the Thorn";
			Die = 0;
			Damage = 15;
			Break = false;
			dur = 0;
			location = 2;
		}

		modifier = name;
		additionalDamageDie = Die;
		additionalDamage = Damage;
		unbreakable = Break;
		additionalDurability = dur;
		this.location = location;
	}
}
