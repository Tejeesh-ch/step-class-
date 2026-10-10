package week1.assigment_problems;

/**
 * Week 1 Assignment - Problem 4: The Warehouse Inventory Balancer
 *
 * Totals two storage sections, reports Balanced / Not Balanced, and locates
 * the single highest quantity across both sections.
 */
public class WarehouseInventoryBalancer {

    /** Suggested signature: void analyzeInventory(int[] sectionA, int[] sectionB) */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length != sectionB.length) {
            System.out.println("Both sections must be non-null arrays of equal length.");
            return;
        }

        int totalA = 0;
        for (int value : sectionA) {
            totalA += value;
        }
        int totalB = 0;
        for (int value : sectionB) {
            totalB += value;
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        // Track the running maximum; scanning A first keeps "Section A" preferred on ties.
        int highest = Integer.MIN_VALUE;
        String highestLocation = "";
        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestLocation = "Section A, Item " + (i + 1);
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestLocation = "Section B, Item " + (i + 1);
            }
        }

        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: " + highest + " (" + highestLocation + ")");
    }

    public static void main(String[] args) {
        System.out.print("A={20,15,30}, B={25,10,30}  ->  ");
        analyzeInventory(new int[] { 20, 15, 30 }, new int[] { 25, 10, 30 });

        System.out.print("A={10,20},     B={5,90}     ->  ");
        analyzeInventory(new int[] { 10, 20 }, new int[] { 5, 90 });
    }
}
