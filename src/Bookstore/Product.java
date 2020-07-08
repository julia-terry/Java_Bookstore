package Bookstore;

import java.util.*;

/**
 * Includes all of the necessary methods that Product objects can use
 *
 * @author Julia Terry
 */
public class Product {

    private String type;
    private String name;
    private String firstName;
    private String lastName;
    private int quantity;
    private double price;
    private String genre;

    /**
     * Constructor Makes a product object
     *
     * @param type String: the of product (book or cd)
     * @param name String: the title of the book
     * @param firstName String: first name of the author
     * @param lastName String: last name of the author
     * @param quantity Int: how many the store has
     * @param price Double: how much it is
     * @param genre String: what the genre is
     */
    public Product(String type, String name, String firstName, String lastName, int quantity, double price, String genre) {
        this.type = type;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.quantity = quantity;
        this.price = price;
        this.genre = genre;
    }

    /**
     * Getter
     *
     * @return String: type of product (book or cd)
     */
    public String getType() {
        return type;
    }

    /**
     * Setter
     *
     * @param type String: type of product (book or cd)
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter
     *
     * @return String: name of product
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param name String: name of product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     *
     * @return String: name of author
     */
    public String getAuthor() {
        String name = this.firstName + " " + this.lastName;
        name = name.toLowerCase();
        return name;
    }

    /**
     * Setter
     *
     * @param firstName String: author's first name
     * @param lastName String: author's last name
     */
    public void setAuthor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Getter
     *
     * @return Int: how many there are in the store
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter
     *
     * @param quantity Int: how many there are in the store
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter
     *
     * @return Double: price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter e
     *
     * @param price Double: price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter
     *
     * @return String: name of genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Setter
     *
     * @param genre String: name of genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Resets the price of the product to reflect the sale
     *
     * @param discount Double: amount the user wants to discount their product
     */
    public void productDiscount(double discount) {
        double discountDecimal = 1 - (discount / 100);
        this.price = this.price * discountDecimal;
    }

    /**
     * Resets the price of the product to reflect the price before the sale
     *
     * @param discount Double: amount the user originally discounted their
     * product
     */
    public void resetPrice(double originalDiscount) {
        double resetDecimal = 1 + (originalDiscount / 100);
        this.price = this.price * resetDecimal;
    }
}
