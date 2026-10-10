package week6.class_problems;

/**
 * M4. Library ID Card Management
 *
 * Proves that assigning a second variable does NOT copy the object: two
 * names, one single card. Changing it through the second name is visible
 * through the first, while a separately constructed card with identical
 * values is still a different object.
 */
public class IdCard {

    private final String name;
    private int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;                       // points at the SAME object

        duplicate.booksIssued = 3;                     // changed through the second name

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        IdCard separate = new IdCard("Ravi", 3);       // identical values, different object
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
