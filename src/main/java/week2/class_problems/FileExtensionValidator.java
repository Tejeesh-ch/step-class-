package week2.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 3: File Extension Validator
 *
 * Finds the last '.' with lastIndexOf(), extracts the extension with
 * substring() and compares it case-insensitively against pdf / docx / zip.
 */
public class FileExtensionValidator {

    /** Suggested signature: String validateFileExtension(String filename) */
    public static String validateFileExtension(String filename) {
        if (filename == null) {
            return "Rejected -- invalid file type";
        }

        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected -- invalid file type";
        }

        String extension = filename.substring(dotIndex + 1);
        if (extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected -- invalid file type";
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String name : args) {
                System.out.println("\"" + name + "\"  ->  " + validateFileExtension(name));
            }
            return;
        }
        System.out.println("\"Assignment1.PDF\"  ->  " + validateFileExtension("Assignment1.PDF"));
        System.out.println("\"notes.txt\"        ->  " + validateFileExtension("notes.txt"));
        System.out.println("\"report.docx\"      ->  " + validateFileExtension("report.docx"));
        System.out.println("\"archive\"          ->  " + validateFileExtension("archive"));
    }
}
