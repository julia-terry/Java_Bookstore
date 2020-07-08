package Bookstore;

/**
 * Includes all of the necessary methods that Member objects can use
 *
 * @author Julia Terry
 */
public class Member {

    private String name;
    private double balance;

    /**
     * Constructor Makes a member object
     *
     * @param name String: the name of the member
     * @param balance Double: how much they have spent
     */
    public Member(String name, double balance) {
        this.name = name.toLowerCase();
        this.balance = balance;
    }

    /**
     * Getter
     *
     * @return String: name of member
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     *
     * @param name String: name of the member
     */
    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    /**
     * Getter
     *
     * @return double amount of money they have spent so far
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter
     *
     * @param balance Double: new balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * When a purchase has been made, it adds to this member's balance
     *
     * @param balance Double: the balance to add to their existing balance
     */
    public void purchaseMade(double balance) {
        this.balance = this.balance + balance;
    }

    /**
     * If a member's balance is over 200, the user is prompted to give them
     * their 20% off card and their balance is reduced 200 points. If a member's
     * balance is not over 200, the user is given their point number
     *
     * @return String: telling them if the user is gold status or not
     */
    public String memReward() {
        String reward = "";
        if (balance > 200) {
            reward = this.getName() + " has earned gold status! Hand them their 20% off next purchase card!";
            this.balance = this.balance - 200;
        }
        if (balance < 200) {
            reward = this.getName() + " has " + this.getBalance() + " points";
        }
        return reward;
    }

}
