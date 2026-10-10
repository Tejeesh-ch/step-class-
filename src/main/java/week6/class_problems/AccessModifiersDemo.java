package week6.class_problems;

/**
 * Week 6 Concept - Section 1: Access Modifiers
 *
 * The four access levels, tightest first:
 *
 *   private    -- this class only
 *   default    -- this package only (write nothing at all)
 *   protected  -- this package + subclasses anywhere
 *   public     -- everyone
 *
 * Choose the narrowest level that still lets legitimate callers do their
 * job -- every public member is a promise to every future caller.
 */
public class AccessModifiersDemo {

    /** Only AccessModifiersDemo.FeeOffice code can reach `regNo` directly. */
    static class FeeAccount {
        private String regNo;        // private   -- only this class
        double totalFee;             // default   -- this package only
        public String accountType;   // public    -- anywhere

        public FeeAccount(String regNo, double totalFee) {
            this.regNo = regNo;
            this.totalFee = totalFee;
            this.accountType = "SAVINGS";
        }

        /** The only door into a private field. */
        public String getRegNo() {
            return regNo;
        }
    }

    public static void main(String[] args) {
        FeeAccount acc = new FeeAccount("RA2311003010123", 200000);

        System.out.println(acc.totalFee);      // OK -- public
        System.out.println(acc.getRegNo());    // OK -- through a public method

        // System.out.println(acc.regNo);      -- COMPILE ERROR: regNo has private access in FeeAccount
    }
}
