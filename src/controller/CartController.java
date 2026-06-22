package controller;

import dao.CartDAO;
import model.CartItem;
import java.util.List;

public class CartController {
    // Make DAO final since it shouldn't change after initialization
    private final CartDAO cartDAO = new CartDAO();

    // Store business rules as constants at the top for easy adjusting
    private static final double DISCOUNT_THRESHOLD = 2000.0;
    private static final double DISCOUNT_RATE = 0.05;

    // Adds a product to the database cart and returns true if successful
    public boolean addToCart(int userId, int productId) {
        if (userId <= 0 || productId <= 0) return false; // Basic validation
        return cartDAO.addToCart(userId, productId);
    }

    // Retrieves all items inside the active user's cart
    public List<CartItem> getCartItems(int userId) {
        return cartDAO.getCartItems(userId);
    }

    // Updates the quantity of an item already in the cart
    public boolean updateQuantity(int cartItemId, int newQuantity) {
        // Prevent users from setting a 0 or negative quantity
        if (newQuantity <= 0) {
            return false; 
            // Note: If you want '0' to remove the item automatically, 
            // you could replace 'return false;' with 'return removeItem(cartItemId);'
        }
        return cartDAO.updateQuantity(cartItemId, newQuantity);
    }

    // Removes an individual item from the cart
    public boolean removeItem(int cartItemId) {
        return cartDAO.removeItem(cartItemId);
    }

    // Clears out the entire cart table for the user
    public boolean clearCart(int userId) {
        return cartDAO.clearCart(userId);
    }

    // Calculates the subtotal of the cart items
    public double getSubTotal(List<CartItem> items) {
        // Null safety check: return 0 if the list is empty or null
        if (items == null || items.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        for (CartItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    // Applies a discount rule for values over the threshold
    public double getDiscount(double subTotal) {
        if (subTotal >= DISCOUNT_THRESHOLD) {
            return subTotal * DISCOUNT_RATE;
        }
        return 0.0;
    }

    // Compiles the final total checkout amount
    public double getTotal(List<CartItem> items) {
        if (items == null || items.isEmpty()) {
            return 0.0;
        }

        double subTotal = getSubTotal(items);
        return subTotal - getDiscount(subTotal);
    }

    // Returns the total number of combined items for the top-right badge count
    public int getCartCount(int userId) {
        return cartDAO.getCartCount(userId);
    }
}