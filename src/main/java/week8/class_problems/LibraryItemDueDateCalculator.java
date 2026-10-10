package week8.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Problem 2 - Library Item Due Date Calculator
 *
 * Each item type decides its own borrowing period; the main loop treats
 * every item uniformly through the LibraryItem interface.
 *
 * Business rules: BOOK 14 days, DVD 7 days, MAGAZINE 3 days.
 * The "current date" is fixed at 2023-10-26 for this exercise.
 */
public class LibraryItemDueDateCalculator {

    static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    interface LibraryItem {
        String title();
        LocalDate dueDate();
    }

    static class Book implements LibraryItem {
        private final String title;
        Book(String title) { this.title = title; }
        public String title() { return title; }
        public LocalDate dueDate() { return CURRENT_DATE.plusDays(14); }
    }

    static class Dvd implements LibraryItem {
        private final String title;
        Dvd(String title) { this.title = title; }
        public String title() { return title; }
        public LocalDate dueDate() { return CURRENT_DATE.plusDays(7); }
    }

    static class Magazine implements LibraryItem {
        private final String title;
        Magazine(String title) { this.title = title; }
        public String title() { return title; }
        public LocalDate dueDate() { return CURRENT_DATE.plusDays(3); }
    }

    static LibraryItem itemFor(String type, String title) {
        switch (type) {
            case "BOOK":     return new Book(title);
            case "DVD":      return new Dvd(title);
            case "MAGAZINE": return new Magazine(title);
            default:         return null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (!in.hasNextLine()) {
            System.out.println("No input provided.");
            return;
        }

        int n = Integer.parseInt(in.nextLine().trim());
        for (int i = 0; i < n && in.hasNextLine(); i++) {
            String line = in.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            if (firstSpace < 0) {
                continue;
            }
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).trim()
                    .replaceAll("^\"|\"", "");

            LibraryItem item = itemFor(type, title);
            if (item == null) {
                continue;
            }
            System.out.println(item.title() + ": " + item.dueDate());
        }
    }
}
