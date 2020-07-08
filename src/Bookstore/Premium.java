package Bookstore;

/**
 * Includes all of the necessary methods that Premium objects can use 
 * Extends member class
 *
 * @author Julia Terry
 */
public class Premium extends Member {

    private boolean paid;
    private String paymentMethod;

    /**
     * Constructor Makes a premium member object
     *
     * @param name String: the name of the member
     * @param balance Double: how much they have spent
     * @param paid Boolean: if they have paid for the premium membership or not
     * @param paymentMethod String: what payment type they have used to pay for
     * the membership
     */
    public Premium(String name, double balance, boolean paid, String paymentMethod) {
        super(name, balance);
        this.paid = paid;
        this.paymentMethod = paymentMethod;
    }

    /**
     * Getter
     *
     * @return Boolean: if the member has paid or not
     */
    public boolean isPaid() {
        return paid;
    }

    /**
     * Setter
     *
     * @param paid Boolean: if the member has paid or not
     */
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    /**
     * Getter
     *
     * @return String: payment method
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Setter
     *
     * @param paymentMethod String: payment method
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Resets all premium members so that they have not paid their premium
     * membership
     */
    public void newYear() {
        this.setPaid(false);
    }
}
