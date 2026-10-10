package week6.class_problems;

/**
 * M2. Hostel Mess Wallet Management
 *
 * The balance is private and can never be written directly from outside.
 * topUp() rejects non-positive amounts and deduct() refuses anything larger
 * than the balance, so the balance can never go negative.
 */
public class MessWallet {

    private double balance;

    /** A negative opening balance is corrected to 0 with a warning. */
    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: negative opening balance rejected, starting at 0 instead");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
            return;
        }
        balance += amount;
        System.out.println("Balance after top-up: " + balance);
    }

    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        balance -= amount;
        System.out.println("Balance after deduction: " + balance);
    }

    /** Read-only access -- there is no setBalance() anywhere. */
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());

        System.out.println();
        MessWallet overdrawn = new MessWallet(-50);
        overdrawn.topUp(0);
    }
}
