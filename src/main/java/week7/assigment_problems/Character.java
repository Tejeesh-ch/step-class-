package week7.assigment_problems;

/**
 * Problem 1 - The Health Bar
 *
 * Health is private and changed only through takeDamage() and heal().
 * Both compute the new value first and then clamp it: damage clamps at 0,
 * healing clamps at the maximum. The maximum health is final, fixed at
 * creation. There is no setter for health.
 *
 * Note: this class shadows java.lang.Character inside this package, which
 * is fine because nothing in this package needs the JDK's Character.
 */
public class Character {

    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = Math.max(1, maxHealth);
        this.health = this.maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        health -= amount;
        if (health < 0) {              // extra damage is simply wasted
            health = 0;
        }
        System.out.println("takeDamage(" + amount + ") -> health = " + health);
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        health += amount;
        if (health > maxHealth) {      // extra healing is simply wasted
            health = maxHealth;
        }
        System.out.println("heal(" + amount + ") -> health = " + health
                + (health == maxHealth ? " (capped)" : ""));
    }

    /** Read-only -- no setter for health. */
    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        System.out.println("new Character(100) -> health = " + c.getHealth());

        c.takeDamage(30);      // health = 70
        c.heal(50);            // health = 100 (capped)
        c.takeDamage(150);     // health = 0 (floored)
    }
}
