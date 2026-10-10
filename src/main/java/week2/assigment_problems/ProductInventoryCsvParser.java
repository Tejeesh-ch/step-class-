package week2.assigment_problems;

/**
 * Week 2 Assignment - Problem 3: Product Inventory CSV Parser
 *
 * Splits "ProductName,SKU,Quantity" on commas, requires exactly three
 * fields, and prints a formatted record.
 */
public class ProductInventoryCsvParser {

    /** Suggested signature: void parseInventoryRecord(String csvLine) */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",", -1);
        if (fields.length != 3 || fields[0].trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + fields[0].trim()
                + " | SKU: " + fields[1].trim()
                + " | Qty: " + fields[2].trim());
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
    }
}
