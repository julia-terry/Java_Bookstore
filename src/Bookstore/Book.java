package Bookstore;

import java.util.*;

/**
 * Includes all of the necessary methods that Book objects can use
 * Extends product class
 *
 * @author Julia Terry
 */
public class Book extends Product {

    private String isbn;
    private String publisher;
    private String series;
    private boolean signed;
    private boolean hardcover;
    private double discount;

    /**
     * Constructor Makes a book object
     *
     * @param type String: the of product (book or cd)
     * @param name String: the title of the book
     * @param firstName String: first name of the author
     * @param lastName String: last name of the author
     * @param quantity Int: how many the store has
     * @param price Double: how much it is
     * @param genre String: what the genre is
     * @param isbn String: isbn
     * @param publisher String: publisher
     * @param series String: series name
     * @param signed Boolean: true if it is a signed edition, false if it isn't
     * @param hardcover Boolean: true if it is hardcover, false if it isn't
     */
    public Book(String type, String name, String firstName, String lastName, int quantity, double price, String genre, String isbn, String publisher, String series, boolean signed, boolean hardcover) {
        super(type, name, firstName, lastName, quantity, price, genre);
        this.isbn = isbn;
        this.publisher = publisher;
        this.series = series;
        this.signed = signed;
        this.hardcover = hardcover;
    }

    /**
     * Getter
     *
     * @return String: isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Setter
     *
     * @param isbn String: isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Getter
     *
     * @return String: name of publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Setter
     *
     * @param publisher String: name of publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Getter
     *
     * @return String: series it is associated with
     */
    public String getSeries() {
        return series;
    }

    /**
     * Setter
     *
     * @param series String: series it is associated with
     */
    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * Getter
     *
     * @return Boolean: if the book has been signed by the author or not
     */
    public boolean isSigned() {
        return signed;
    }

    /**
     * Setter
     *
     * @param signed Boolean: whether or not the book is signed
     */
    public void setSigned(boolean signed) {
        this.signed = signed;
    }

    /**
     * Getter
     *
     * @return Boolean: if the book is hardcover or not
     */
    public boolean isHardcover() {
        return hardcover;
    }

    /**
     * Setter
     *
     * @param hardcover Boolean: whether the book is hardcover or not
     */
    public void setHardcover(boolean hardcover) {
        this.hardcover = hardcover;
    }

    /**
     * Sets a new price to only the hardcover books
     *
     * @param discount Double: the amount the user wants to discount the books
     */
    public void saleHardcover(double discount) {
        if (this.isHardcover() == true) {
            double sale = this.getPrice() * discount;
            this.setPrice(sale);
        }
    }

    /**
     * Sets a new price to only the paperback books
     *
     * @param discount Double: the amount the user wants to discount the books
     */
    public void salePaperback(double discount) {
        if (this.isHardcover() == false) {
            double sale = this.getPrice() * discount;
            this.setPrice(sale);
        }

    }

    /**
     * Resets the price to its original value before the discount (only
     * hardcover books)
     *
     * @param discount Double: the amount the user discounted the books
     */
    public void resetHardcover(double discount) {
        if (this.isHardcover() == true) {
            this.resetPrice(discount);
        }
    }

    /**
     * Resets the price to its original value before the discount (only
     * paperback books)
     *
     * @param discount Double: the amount the user discounted the books
     */
    public void resetPaperback(double discount) {
        if (this.isHardcover() == false) {
            this.resetPrice(discount);
        }
    }
}
