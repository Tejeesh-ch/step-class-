package week2.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 4: Masked Phone Number Formatter
 *
 * Validates that the number is exactly 10 digits, then builds
 * "XXXXXX-<last four>" with a StringBuilder.
 */
public class MaskedPhoneNumberFormatter {

    /** Suggested signature: String maskPhoneNumber(String phone) */
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder();
        masked.append("XXXXXX");
        masked.append("-");
        masked.append(phone, 6, 10);
        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println("\"9876543210\"  ->  " + maskPhoneNumber("9876543210"));
        System.out.println("\"98765\"       ->  " + maskPhoneNumber("98765"));
        System.out.println("\"987654321x\"  ->  " + maskPhoneNumber("987654321x"));
    }
}
