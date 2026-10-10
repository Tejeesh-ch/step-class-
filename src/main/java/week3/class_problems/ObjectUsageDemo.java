package week3.class_problems;

/**
 * Week 3 - OOP, Classes and Objects, Section 5: Creating and Using Objects
 *
 * `new` allocates, the constructor initialises, the variable stores a
 * REFERENCE -- not the object itself. Copying a reference does not copy the
 * object, which is why `==` compares addresses and needs equals() when you
 * meant "same contents". null points at nothing.
 */
public class ObjectUsageDemo {

    static class IdCard {
        String name;
        String regNo;
        int libraryBooks;

        IdCard(String name, String regNo) {
            this.name = name;
            this.regNo = regNo;
        }
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", "RA2311003010123");
        IdCard duplicate = ravi;                             // SAME card, second name
        IdCard karthik = new IdCard("Ravi", "RA2311003010123"); // separate card, same details

        duplicate.libraryBooks = 3;                          // issued through the "duplicate"

        System.out.println(ravi.libraryBooks);              // 3 -- there was only ever one card
        System.out.println(ravi == duplicate);               // true  -- same object
        System.out.println(ravi == karthik);                 // false -- identical data, different object

        IdCard lost = null;                                  // a card holder with no card in it

        // System.out.println(lost.name);                     // NullPointerException

        System.out.println(lost == null);                    // true
    }
}
