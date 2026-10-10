package week7.assigment_problems;

/**
 * Problem 4 - The Traffic Light
 *
 * The colour only moves forward through its cycle -- next() is the one and
 * only door in or out of that field. There is no method that sets the
 * colour to an arbitrary value, and the ID is final.
 */
public class TrafficLight {

    private final String id;
    private String color = "RED";        // a new light starts on red

    public TrafficLight(String id) {
        this.id = id;
    }

    /** red -> green -> yellow -> red, forever, in that exact order. */
    public void next() {
        switch (color) {
            case "RED":
                color = "GREEN";
                break;
            case "GREEN":
                color = "YELLOW";
                break;
            default:
                color = "RED";
                break;
        }
        System.out.println("next() -> " + color);
    }

    /** Read-only -- there is no setColor(). */
    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");

        System.out.println("getColor() -> " + t.getColor());
        t.next();   // RED   -> GREEN
        t.next();   // GREEN -> YELLOW
        t.next();   // YELLOW -> RED
        t.next();   // RED   -> GREEN
        System.out.println("id (final) -> " + t.getId());
    }
}
