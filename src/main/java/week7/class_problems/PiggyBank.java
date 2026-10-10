package week7.class_problems;

/**
 * Problem 1 - The Piggy Bank
 *
 * The savings amount is private and changed ONLY by deposit() and
 * withdraw(). A withdrawal larger than the current savings is rejected,
 * not applied. The ID is final, fixed the moment the object is created.
 * There is no method anywhere that sets savings directly.
 */
public class PiggyBank {

    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;                 // final -- locked in place forever, right from the constructor
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive");
            return;
        }
        savings += amount;
        System.out.println("deposited " + amount + " -> savings = " + savings);
    }

    public void withdraw(double amount) {
        if (amount > savings) {
            System.out.println("withdraw " + amount + " -> rejected, savings stays " + savings);
            return;
        }
        savings -= amount;
        System.out.println("withdrew " + amount + " -> savings = " + savings);
    }

    /** Read-only -- there is no setSavings() anywhere in this class. */
    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        System.out.println("new PiggyBank(\"PB-1\")   -> savings = " + pb.getSavings());
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
        System.out.println("final savings        -> " + pb.getSavings());
        System.out.println("id (final)           -> " + pb.getId());
    }
}
