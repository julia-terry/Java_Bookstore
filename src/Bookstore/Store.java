package Bookstore;

import java.util.*;

/**
 * Includes all of the necessary methods that Store objects can use
 *
 * @author Julia Terry
 */
public class Store {

    private String name;
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Premium> premium = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Cd> cds = new ArrayList<>();

    /**
     * Constructor Makes a store object
     *
     * @param name String: the name of the store
     */
    public Store(String name) {
        this.name = name;
    }

    /**
     * Creates a member and adds it to the "members" arrayList
     *
     * @param name String: the name of the member
     * @param balance Double: how much they have spent
     */
    public void addMember(String name, double balance) {
        Member newMember = new Member(name, balance);
        members.add(newMember);
    }

    /**
     * Creates a premium member and adds it to the "members" and "premium"
     * arrayLists
     *
     * @param name String: the name of the member
     * @param balance Double: how much they have spent
     * @param paid Boolean: if they have paid for the premium membership or not
     * @param paymentMethod String: what payment type they have used to pay for
     * the membership
     */
    public void addPremium(String name, double balance, boolean paid, String paymentMethod) {
        Premium newPremium = new Premium(name, balance, paid, paymentMethod);
        premium.add(newPremium);
        members.add(newPremium);
    }

    /**
     * Creates a book and adds it to the "products" and "books" arrayLists
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
    public void addBook(String type, String name, String firstName, String lastName, int quantity, double price, String genre, String isbn, String publisher, String series, boolean signed, boolean hardcover) {
        Book newBook = new Book(type, name, firstName, lastName, quantity, price, genre, isbn, publisher, series, signed, hardcover);
        products.add(newBook);
        books.add(newBook);
    }

    /**
     * Creates a cd and adds it to the "products" and "cds" arrayLists
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
    public void addCd(String type, String name, String firstName, String lastName, int quantity, double price, String genre, String asin, String label, boolean specialEd) {
        Cd newCd = new Cd(type, name, firstName, lastName, quantity, price, genre, asin, label, specialEd);
        products.add(newCd);
        cds.add(newCd);
    }

    /**
     * For each book, it is discounted
     *
     * @param discount Double: percentage that it is discounted
     */
    public void bookDiscount(double discount) {
        books.forEach((book) -> {
            book.productDiscount(discount);
        });
    }

    /**
     * For each hardcover book, it is discounted
     *
     * @param discount Double: percentage that it is discounted
     */
    public void hardcoverDiscount(double discount) {
        books.forEach((book) -> {
            book.saleHardcover(discount);
        });
    }

    /**
     * For each paperback book, it is discounted
     *
     * @param discount Double: percentage that it is discounted
     */
    public void paperbackDiscount(double discount) {
        books.forEach((book) -> {
            book.salePaperback(discount);
        });
    }

    /**
     * For each cd, it is discounted
     *
     * @param discount Double: percentage that it is discounted
     */
    public void cdDiscount(double discount) {
        cds.forEach((cd) -> {
            cd.productDiscount(discount);
        });
    }

    /**
     * For each special edition cd, it is discounted
     *
     * @param discount Double: percentage that it is discounted
     */
    public void specialEdDiscount(double discount) {
        cds.forEach((cd) -> {
            cd.saleSpecialEd(discount);
        });
    }

    /**
     * For each product, it is discounted
     *
     * @param discount Double: percentage that it is discounted
     */
    public void productDiscount(double discount) {
        products.forEach((product) -> {
            product.productDiscount(discount);
        });
    }

    /**
     * Resets the price of all books to their original price
     *
     * @param discount Double: percentage that it was discounted
     */
    public void bookResetPrice(double orgDiscount) {
        books.forEach((book) -> {
            book.resetPrice(orgDiscount);
        });
    }

    /**
     * Resets the price of all hardcover books to their original price
     *
     * @param discount Double: percentage that it was discounted
     */
    public void resetHardcoverBook(double discount) {
        books.forEach((book) -> {
            book.resetHardcover(discount);
        });
    }

    /**
     * Resets the price of all paperback books to their original price
     *
     * @param discount Double: percentage that it was discounted
     */
    public void resetPaperbackBook(double discount) {
        books.forEach((book) -> {
            book.resetPaperback(discount);
        });
    }

    /**
     * Resets the price of all cds to their original price
     *
     * @param discount Double: percentage that it was discounted
     */
    public void cdResetPrice(double orgDiscount) {
        cds.forEach((cd) -> {
            cd.resetPrice(orgDiscount);
        });
    }

    /**
     * Resets the price of all special edition cds to their original price
     *
     * @param discount Double: percentage that it was discounted
     */
    public void specialEdResetPrice(double orgDiscount) {
        cds.forEach((cd) -> {
            cd.resetSpecialEd(orgDiscount);
        });
    }

    /**
     * Returns the reward status for the specific member
     *
     * @param name String: name of the member
     * @return String: their reward status (from member.java)
     */
    public String rewardStatus(String name) {
        for (Member member : members) {
            if (member.getName() == name.toLowerCase()) {
                return member.memReward();
            }
        }
        return "";
    }

    /**
     * Returns the list of books in the series If there are no books in that
     * series, it lets the user know
     *
     * @param series String: name of the series we are looking for
     * @return String: the series list or letting the user know there are none
     */
    public String getSeriesBooks(String series) {
        ArrayList<String> seriesBooks = new ArrayList<>();
        for (Book b : books) {
            if (b.getSeries() == series) {
                seriesBooks.add(b.getName());
            }
        }
        String seriesList = seriesBooks.toString();
        if (seriesBooks.size() > 1) {
            seriesList = "We do not carry that series in our store";
        }
        return seriesList;
    }

    /**
     * Returns the list of cds or books that the author/artist made If there are
     * none by that person, it lets the user know
     *
     * @param firstName String: first name of the author/artist
     * @param lastName String: last name of the author/artist
     * @return String: the list of products or letting the user know there are
     * none
     */
    public String getAuthorProducts(String firstName, String lastName) {
        String authorName = firstName + " " + lastName;
        authorName = authorName.toLowerCase();
        ArrayList<String> authorProducts = new ArrayList<>();
        for (Product p : products) {
            if (p.getAuthor() == authorName) {
                authorProducts.add(p.getName());
            }
        }
        String authorList = authorProducts.toString();
        if (authorProducts.size() > 1) {
            authorList = "There are no products by that author in our store";
        }
        return authorList;
    }

    /**
     * Returns the name and author of all books and cds that are at or under the
     * amount the user would like Example: the user wants all products that have
     * an inventory of 2 or less
     *
     * @param minimumQuantity Int: minimum number the user wants the quantity to
     * be
     * @return String: the list of books and cds (with their respective authors)
     */
    public String inventoryCheck(int minimumQuantity) {
        ArrayList<String> productsToGet = new ArrayList<>();
        for (Product p : products) {
            if (p.getQuantity() <= minimumQuantity) {
                String addToArray = p.getName() + " by " + p.getAuthor();
                productsToGet.add(addToArray);
            }
        }
        String toGet = productsToGet.toString();
        return toGet;
    }

    /**
     * Sets all the premium members to have false on their paid or not because
     * it's a new year
     *
     * @return String: telling the user that the method has been performed
     */
    public String newYearSet() {
        for (Premium p : premium) {
            p.newYear();
        }
        return "Happy new year! All premium members have not paid to be premium this year.";
    }
    
    /**
     * Adds the new amount to the member's points after a purchase
     *
     * @param name String: name of the member
     * @param amount Double: number of points to add (how much they spent)
     */
    public void newPurchase (String name, double amount) {
        for (Member member : members) {
            if (member.getName() == name.toLowerCase()) {
                member.purchaseMade(amount);
            }
        }
    }
    
    /**
     * Sets the payment status to yes and adds the payment method
     *
     * @param name String: name of the member
     * @param paymentMethod String: how they paid for their membership
     */
    public void premiumPayment (String name, String paymentMethod) {
        for (Premium member : premium) {
            if (member.getName() == name.toLowerCase()) {
                member.setPaid(true);
                member.setPaymentMethod(paymentMethod);
            }
        }
    }
}
