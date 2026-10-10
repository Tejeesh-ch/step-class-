package week2.assigment_problems;

/**
 * Week 2 Assignment - Problem 2: Word Reversal Encoder
 *
 * The "mirror text" mini-game reverses every word individually while
 * keeping the word order the same: "hello club" -> "olleh bulc".
 */
public class WordReversalEncoder {

    /** Suggested signature: String reverseEachWord(String sentence) */
    public static String reverseEachWord(String sentence) {
        if (sentence == null) {
            return null;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder();
            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversedWord.append(words[i].charAt(j));
            }
            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(' ');
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = (args.length > 0) ? String.join(" ", args) : "hello club";
        System.out.println("\"" + input + "\"  ->  " + reverseEachWord(input));
    }
}
