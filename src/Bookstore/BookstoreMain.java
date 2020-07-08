package Bookstore;

import java.util.Scanner;

/**
 * The code to go through all of the menu options
 * 
 * @author Julia Terry
 */
public class BookstoreMain {

    /**
     * Test harness program 
     * 
     * Members Menu
     * Guided member addition: addMember()
     * Guided premium member addition: addPremium()
     * *Check reward status ($200 spent = 20% off next purchase): rewardStatus()
     * Existing member purchase (to keep track of their points): newPurchse()
     * Premium member paid for membership: premiumPayment
     * 
     * New Sale Menu
     * Sale on all books: bookDiscount
     * Sale on hardcover books: hardcoverDiscount()
     * Sale on paperback books: paperbackDiscount()
     * Sale on all cds: cdDiscount()
     * Sale on special edition cds: specialEdDiscount()
     * 
     * Inventory Menu
     * *Search inventory by author/artist: getAuthorProducts()
     * *Search inventory by series: getSeriesBooks()
     * *Low inventory list: inventoryCheck()
     * 
     * Reset Menu
     * Reset paperback books to original price: resetPaperbackBook()
     * Reset hardback books to original price: resetHardcoverBook()
     * Reset all books to original price: bookResetPrice()
     * Reset special edition cds to original price: specialEdResetPrice
     * Reset all cds to original price: cdResetPrice()
     * *Reset premium member status to false for the new membership year: newYearSet()
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int firstResponse;
        int secondResponse;
        int thirdResponse;
        Store myStore = new Store("My new store");
        
        // TODO: add books, members, and cds here to test
        
        Scanner myScanner= new Scanner(System.in);
        System.out.println("Please type in the number associated with the menu you would like to choose: \n 1. Members \n 2. New Sale \n 3. Inventory \n 4. Reset");
        firstResponse = myScanner.nextInt();
        
        //Members menu
        if(firstResponse == 1){
            System.out.println("Please type in the number associated with the action you wish to perform: \n 1. Add member \n 2. Add premium member \n 3. Check member points \n 4. New member purchase \n 5. Premium membership payment (for existing memberss)");
            secondResponse = myScanner.nextInt();
            //Add new member
            if(secondResponse == 1){
                System.out.println("Please enter their full name:");
                String memberName = myScanner.nextLine();
                myStore.addMember(memberName, 0);
            }
            //Add new premium member
            if(secondResponse == 2){
                boolean paymentStatus = false;
                String payment = "N/A";
                
                System.out.println("Please enter their full name:");
                String memberName = myScanner.nextLine();
                myScanner.next();
                System.out.println("Have they paid the membership fee? (Y/N)");
                String paymentResponse = myScanner.next();
                if(paymentResponse == "Y"){
                    paymentStatus = true;
                    System.out.println("Please enter the payment method they used:");
                    payment = myScanner.nextLine();
                }
                if(paymentResponse == "N"){
                    paymentStatus = false;
                }
                
                myStore.addPremium(memberName, 0, paymentStatus, payment);
            }
            //Check reward status
            if(secondResponse == 3){
                System.out.println("Please enter the full name of the customer:");
                String memberName = myScanner.nextLine();
                myStore.rewardStatus(memberName);          
            }
            //New member purchase
            if(secondResponse == 4){
                System.out.println("Please enter the full name of the customer:");
                String memberName = myScanner.nextLine();
                myScanner.next();
                System.out.println("Please enter the full amount of their purchase:");
                double checkoutPrice = myScanner.nextDouble();
                myStore.newPurchase(memberName, checkoutPrice);
            }
            //Premium member paid for membership
            if(secondResponse == 5){
                System.out.println("Please enter the full name of the customer:");
                String memberName = myScanner.nextLine();
                myScanner.next();
                System.out.println("Please enter the payment method:");
                String paymentMethod = myScanner.nextLine();
                myScanner.next();
                myStore.premiumPayment(memberName, paymentMethod);
            }
        }
        
        //New sale menu
        if(firstResponse == 2){
            System.out.println("Please type in the number associated with the product type you would like to put on sale: \n 1. Books \n 2. Cds");
            secondResponse = myScanner.nextInt();
            //Sale on books
            if(secondResponse == 1){
                System.out.println("Please type in the number assocted with the specific sale you would like to choose: \n 1. All books \n 2. Hardcover books \n 3. Paperback books");
                thirdResponse = myScanner.nextInt();
                
                System.out.println("Please type in the percentage off (ex: 20% off = \" 20 \" )");
                double percentageOff = myScanner.nextDouble();
                //Sale on all books
                if(thirdResponse == 1){
                    myStore.bookDiscount(percentageOff);
                }
                //Sale on hardcover books
                if(thirdResponse == 2){
                    myStore.hardcoverDiscount(percentageOff);
                }
                //Sale on paperback books
                if(thirdResponse == 3){
                    myStore.paperbackDiscount(percentageOff);     
                }
            }
            //Sale on cds
            if(secondResponse == 2){
                System.out.println("Please type in the number assocted with the specific sale you would like to choose: \n 1. All cds \n 2. Special edition cds");
                thirdResponse = myScanner.nextInt();
                //Sale on all cds
                if(thirdResponse == 1){
                    myStore.cdDiscount(thirdResponse);
                }
                //Sale on special edition cds
                if(thirdResponse == 2){
                    myStore.specialEdDiscount(thirdResponse);
                }
            }
        }
        
        //Inventory menu
        if(firstResponse == 3){
            System.out.println("Please type in the number associated with the action you wish to perform: \n 1. Search Inventory \n 2. Low Inventory List");
            secondResponse = myScanner.nextInt();
            //Search inventory
            if(secondResponse == 1){
                System.out.println("Please type in the number assocted with how you wish to search for your product: \n 1. By author/artist \n 2. By series");
                thirdResponse = myScanner.nextInt();
                //Search by author/artist
                if(thirdResponse == 1){
                    System.out.println("Please type in the author/artist's first name: ");
                    String firstName = myScanner.nextLine();
                    firstName = firstName.toLowerCase();
                    myScanner.next();
                    System.out.println("Please type in the author/artist's last name: ");
                    String lastName = myScanner.nextLine();
                    lastName = lastName.toLowerCase();
                    myScanner.next();
                    myStore.getAuthorProducts(firstName, lastName);
                    
                }
                //Search by series
                if(thirdResponse == 2){
                    System.out.println("Please enter the name of the series:");
                    String series = myScanner.nextLine();
                    myStore.getSeriesBooks(series);
                }
            }
            //Low inventory list
            if(secondResponse == 2){
                System.out.println("Please enter the minimum amount of each product you would like to have");
                System.out.println("Ex: If you want a list of products to order where you only have 1 copy or less of each, type \" 1 \"");
                int quantity = myScanner.nextInt();
                myStore.inventoryCheck(quantity);
            }    
        }
        
        //Reset menu
        if(firstResponse == 4){
            System.out.println("Please type in the number associated with the action you wish to perform: \n 1. End of sale: reset sale product price to original \n 2. New year: make all premium members's status not paid");
            secondResponse = myScanner.nextInt();
            //Reset sale
            if(secondResponse == 1){
                System.out.println("Please type in the number associated with the product you originally put on sale: \n 1. Paperback books \n 2. Hardcover books \n 3. All books  \n 4. Special edition cds  \n 5. All cds");
                thirdResponse = myScanner.nextInt();
                
                System.out.println("Please type in the number original sale percentage (ex: 20% off = 20)");
                double orgSaleNumber = myScanner.nextDouble();
                //Reset paperback
                if(thirdResponse == 1){
                    myStore.resetPaperbackBook(orgSaleNumber);
                }
                //Reset hardcover
                if(thirdResponse == 2){
                    myStore.resetHardcoverBook(orgSaleNumber);
                }
                //Reset all books
                if(thirdResponse == 3){
                    myStore.bookResetPrice(orgSaleNumber);
                }
                //Reset special edition cds
                if(thirdResponse == 4){
                    myStore.specialEdResetPrice(orgSaleNumber);
                }
                //Reset all cds
                if(thirdResponse == 5){
                    myStore.cdResetPrice(orgSaleNumber);
                }
            }
            //Reset premium member status
            if(secondResponse == 2){
                myStore.newYearSet();
            }
        }
    }
}

    

