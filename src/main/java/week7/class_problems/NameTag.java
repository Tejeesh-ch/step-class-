package week7.class_problems;

/**
 * Problem 3 - The Nickname Tag
 *
 * An immutable class: the full name is taken once in the constructor,
 * split there, and stored as final fields. Nothing about the name can be
 * changed after creation, so there are no setters at all.
 */
public class NameTag {

    private final String firstName;
    private final String lastName;

    /** All the string splitting happens once, here. */
    public NameTag(String fullName) {
        if (fullName == null || !fullName.contains(" ")) {
            this.firstName = (fullName == null) ? "" : fullName;
            this.lastName = "";
        } else {
            String[] parts = fullName.split(" ", 2);
            this.firstName = parts[0];
            this.lastName = parts[1];
        }
    }

    /** Built from the stored parts -- no re-splitting on every call. */
    public String getNickname() {
        if (lastName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("getNickname() -> " + tag.getNickname());

        NameTag sameName = new NameTag("Maria Gomez");
        System.out.println("Separate objects, identical behaviour: "
                + (tag != sameName) + " / " + tag.getNickname().equals(sameName.getNickname()));
    }
}
