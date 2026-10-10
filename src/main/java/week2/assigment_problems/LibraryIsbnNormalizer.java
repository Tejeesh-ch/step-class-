package week2.assigment_problems;

/**
 * Week 2 Assignment - Problem 4: Library ISBN Normalizer &amp; Validator
 *
 * A valid code is exactly 13 characters: 3 letters (publisher) + 4 digits
 * (year) + 6 digits (catalog). Normalization trims and uppercases only the
 * first 3 characters; validation uses Character.isLetter()/isDigit() in a
 * loop -- no regex.
 */
public class LibraryIsbnNormalizer {

    /** trims the input and uppercases only the first 3 characters. */
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: characters 4-13 must be digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder line = new StringBuilder();
        line.append('[').append(publisher).append("] YEAR: ")
            .append(year)
            .append(" | CATALOG: ").append(catalog);
        return line.toString();
    }

    private static void show(String raw) {
        System.out.println("\"" + raw + "\"  ->  " + validateAndFormat(normalizeCode(raw)));
    }

    public static void main(String[] args) {
        show(" pen2026004251 ");
        show("12N2026004251");
        show("pen202600425");
        show("PEN202600425A");
    }
}
