package week7.assigment_problems;

/**
 * Problem 5 - The Shopping Cart
 *
 * Prices live in a private array. The total is computed on request by
 * looping over it -- no separate running-total field, so it is always
 * correct the instant an item is added. The cart ID is final.
 * There is no method that returns the array of individual prices.
 */
public class Cart {

    private final String cartId;
    private final double[] prices;
    private int count;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
    }

    public void addItem(double price) {
        if (price <= 0) {
            System.out.println("Rejected: price must be positive");
            return;
        }
        if (count >= prices.length) {
            System.out.println("Cart is full: " + price + " not added");
            return;
        }
        prices[count++] = price;
    }

    /** Read-only total, summed fresh each call. */
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }

    /** Deliberately absent: there is no getPrices(). */

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("getTotal()      -> " + cart.getTotal());
        System.out.println("getItemCount()  -> " + cart.getItemCount());
        System.out.println("cartId (final)  -> " + cart.getCartId());
        System.out.println("The individual prices cannot be read from outside the class.");
    }
}
