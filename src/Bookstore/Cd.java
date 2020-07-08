package Bookstore;

/**
 * Includes all of the necessary methods that Cd objects can use
 * Extends product class
 *
 * @author Julia Terry
 */
public class Cd extends Product {

    private String asin;
    private String label;
    private boolean specialEd;

    /**
     * Constructor Makes a Cd object
     *
     * @param type String: the of product (book or cd)
     * @param name String: the title of the book
     * @param firstName String: first name of the author
     * @param lastName String: last name of the author
     * @param quantity Int: how many the store has
     * @param price Double: how much it is
     * @param genre String: what the genre is
     * @param asin String: asin
     * @param label String: label name
     * @param specialEd Boolean: true if it is a special edition cd, false if it
     * isn't
     */
    public Cd(String type, String name, String firstName, String lastName, int quantity, double price, String genre, String asin, String label, boolean specialEd) {
        super(type, name, firstName, lastName, quantity, price, genre);
        this.asin = asin;
        this.label = label;
        this.specialEd = specialEd;
    }

    /**
     * Getter
     *
     * @return String: asin
     */
    public String getAsin() {
        return asin;
    }

    /**
     * Setter
     *
     * @param asin String: asin
     */
    public void setAsin(String asin) {
        this.asin = asin;
    }

    /**
     * Getter
     *
     * @return String: label of the cd
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter
     *
     * @param label String: label of the cd
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter
     *
     * @return Boolean: if the cd is a special edition copy or not
     */
    public boolean isSpecialEd() {
        return specialEd;
    }

    /**
     * Setter
     *
     * @param specialEd Boolean: if the cd is a special edition copy or not
     */
    public void setSpecialEd(boolean specialEd) {
        this.specialEd = specialEd;
    }

    /**
     * Sets a new price to only the special edition cds
     *
     * @param discount Double: the amount the user wants to discount the cds
     */
    public void saleSpecialEd(double discount) {
        if (this.isSpecialEd() == true) {
            this.productDiscount(discount);
        }
    }

    /**
     * Resets the price to its original value before the discount (only special
     * edition cds)
     *
     * @param discount Double: the amount the user discounted the cds
     */
    public void resetSpecialEd(double discount) {
        if (this.isSpecialEd() == true) {
            this.resetPrice(discount);
        }
    }

}
