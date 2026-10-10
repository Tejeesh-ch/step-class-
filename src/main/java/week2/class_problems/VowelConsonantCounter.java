package week2.class_problems;

/**
 * Day 2 Live-Coding Session - Problem 1: Vowel &amp; Consonant Counter
 *
 * A library orientation kiosk counts vowels and consonants in a submitted
 * book title. Only letters and spaces; spaces are ignored.
 */
public class VowelConsonantCounter {

    /** Suggested signature: void countVowelsAndConsonants(String text) */
    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Vowels: 0 | Consonants: 0");
            return;
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (c == ' ') {
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        System.out.print("\"Java Programming\"  ->  ");
        countVowelsAndConsonants("Java Programming");

        System.out.print("\"Bridge Labz\"       ->  ");
        countVowelsAndConsonants("Bridge Labz");
    }
}
