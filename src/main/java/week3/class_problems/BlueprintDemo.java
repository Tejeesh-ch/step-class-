package week3.class_problems;

/**
 * Week 3 - OOP, Classes and Objects, Section 3: Class &amp; Object
 *
 * The class is the floor plan; the object is the actual room.
 * Every object gets its own copy of the instance fields, so C-214 and C-507
 * stay completely independent. Unset int fields start at 0.
 */
public class BlueprintDemo {

    /** THE FLOOR PLAN -- describes every room, is not any particular room. */
    static class HostelRoom {
        String roomNo;
        int beds;
        int occupied;

        void allot(String studentName) {
            if (occupied < beds) {
                occupied++;
                System.out.println(studentName + " allotted to room " + roomNo);
            } else {
                System.out.println("Room " + roomNo + " is full - " + studentName
                        + " goes on the waiting list");
            }
        }
    }

    public static void main(String[] args) {
        // TWO ACTUAL ROOMS built from the same plan
        HostelRoom room214 = new HostelRoom();
        room214.roomNo = "C-214";
        room214.beds = 3;

        HostelRoom room507 = new HostelRoom();
        room507.roomNo = "C-507";
        room507.beds = 2;

        room214.allot("Ravi");
        room214.allot("Karthik");
        room507.allot("Meera");

        // Filling C-214 did nothing to C-507. Separate objects, separate state.
        System.out.println("C-214 occupied: " + room214.occupied);
        System.out.println("C-507 occupied: " + room507.occupied);
    }
}
