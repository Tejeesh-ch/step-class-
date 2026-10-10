package week3.class_problems;

/**
 * Week 3 - OOP, Classes and Objects, Section 2: Benefits
 * (Reusability, Security, Extensibility)
 *
 * Reusability  -- one FeeAccount class, unlimited objects; HostelFeeAccount
 *                inherits instead of copy-pasting.
 * Security     -- amountPaid is private; the only way in is pay(), which
 *                holds the "payment must be positive" rule.
 * Extensibility -- a new subclass adds EMI-style behaviour without touching
 *                the already-tested FeeAccount.
 */
public class BenefitsDemo {

    /** private = the counter you cannot walk behind. */
    static class FeeAccount {
        private String regNo;
        private double totalFee;
        private double amountPaid;

        public FeeAccount(String regNo, double totalFee) {
            this.regNo = regNo;
            this.totalFee = totalFee;
        }

        public void pay(double amount) {
            if (amount <= 0) {                     // THE RULE. Lives in one place.
                System.out.println("Rejected: a payment of Rs " + amount + " makes no sense");
                return;
            }
            amountPaid += amount;
            System.out.println("Rs " + amount + " received for " + regNo);
        }

        public double getDue() {                   // controlled, read-only access
            return totalFee - amountPaid;
        }
    }

    /** REUSABILITY + EXTENSIBILITY: new ability, zero edits to FeeAccount. */
    static class HostelFeeAccount extends FeeAccount {

        public HostelFeeAccount(String regNo, double totalFee) {
            super(regNo, totalFee);
        }

        public void payInTwoInstallments(double amount) {
            pay(amount / 2);                       // reusing the inherited, tested method
            pay(amount / 2);
        }
    }

    public static void main(String[] args) {
        HostelFeeAccount ravi = new HostelFeeAccount("RA2311003010123", 200000);

        ravi.pay(90000);
        ravi.pay(-5000);                           // blocked by the rule inside the class
        ravi.payInTwoInstallments(60000);

        System.out.println("Still due: Rs " + ravi.getDue());
    }
}
