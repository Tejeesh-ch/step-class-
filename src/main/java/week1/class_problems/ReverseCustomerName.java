package week1.class_problems;

/**
 * Problem 5 - Reverse Customer Name (Day 1 Live-Coding Session)
 *
 * The Customer Identity Verification System generates a reversed version of
 * a customer's name while keeping the original data unchanged.
 */
public class ReverseCustomerName {

    /** Suggested signature: String reverseCustomerName(String customerName) */
    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }
        char[] characters = customerName.toCharArray();
        for (int i = 0, j = characters.length - 1; i < j; i++, j--) {
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }

    public static void main(String[] args) {
        String customerName = (args.length > 0) ? args[0] : "Sunil";
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reverseCustomerName(customerName));
    }
}
