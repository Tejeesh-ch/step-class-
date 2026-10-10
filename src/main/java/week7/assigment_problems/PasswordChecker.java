package week7.assigment_problems;

/**
 * Problem 3 - The Password Checker
 *
 * The password is taken once in the constructor, stored privately with no
 * getter that returns it, and can never be changed after creation. Only
 * the strength rating is revealed.
 */
public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        this.password = (password == null) ? "" : password;
    }

    /**
     * Under 6 characters  -> Weak
     * 6 to 9 characters   -> Medium
     * 10+ characters      -> Strong
     */
    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        }
        if (length < 10) {
            return "Medium";
        }
        return "Strong";
    }

    /** Deliberately absent: there is no getPassword(). */

    public static void main(String[] args) {
        System.out.println("new PasswordChecker(\"abcd\")        getStrength() -> "
                + new PasswordChecker("abcd").getStrength());
        System.out.println("new PasswordChecker(\"abcdefgh\")    getStrength() -> "
                + new PasswordChecker("abcdefgh").getStrength());
        System.out.println("new PasswordChecker(\"abcdefghij\")  getStrength() -> "
                + new PasswordChecker("abcdefghij").getStrength());
        System.out.println("The password itself is never returned by any method.");
    }
}
