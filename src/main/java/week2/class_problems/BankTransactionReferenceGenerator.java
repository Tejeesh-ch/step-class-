package week2.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 5: Bank Transaction Reference
 * Generator &amp; Validator
 *
 * A valid reference is exactly 14 characters: 3 letters (bank code) +
 * 6 digits (ddMMyy) + 5 digits (sequence). No regex -- only
 * Character.isLetter() / isDigit().
 */
public class BankTransactionReferenceGenerator {

    /** trims the input and uppercases only the first 3 characters. */
    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: characters 4-14 must be digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);   // ddMMyy
        String sequence = reference.substring(9);  // 5 digits

        StringBuilder line = new StringBuilder();
        line.append('[').append(bankCode).append("] DATE: ")
            .append(date, 0, 2).append('/')
            .append(date, 2, 4).append('/')
            .append(date, 4, 6)
            .append(" | SEQ: ").append(sequence);
        return line.toString();
    }

    private static void show(String raw) {
        String normalized = normalizeReference(raw);
        System.out.println("\"" + raw + "\"  ->  " + validateAndFormat(normalized));
    }

    public static void main(String[] args) {
        show(" hdf03022600042 ");
        show("12F03022600042");
        show(" hdf0302260004");
        show("HDF0302260004A");
    }
}
