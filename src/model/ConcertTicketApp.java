/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import controller.ConcertTicketController;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import view.Home;
import view.Login;
import view.Register;

/**
 *
 * @author LENOVO
 */
public class ConcertTicketApp {

    /**
     * @param args the command line arguments
     */
    
    
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final ConcertDatabase concertDatabase = new ConcertDatabase();
    private static final List<TicketPurchase> ticketPurchases = new ArrayList<>();
    

    public static void main(String[] args) {
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login loginView = new Login();
                Home homeView = new Home();
                Register registerView = new Register();
                ConcertTicketController controller = new ConcertTicketController(loginView, homeView, registerView);
                loginView.setVisible(true);
            }
        });
        */
        
        int choice;
        do {
            System.out.println("\nConcert Ticket App Menu:");
            System.out.println("1. Add Concert");
            System.out.println("2. Display All Concerts");
            System.out.println("3. Search Concert by ID");
            System.out.println("4. Purchase Ticket");
            System.out.println("5. Remove Concert by ID");
            System.out.println("6. Display All Purchases");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addConcertMenu();
                    break;
                case 2:
                    displayAllConcerts();
                    break;
                case 3:
                    searchConcertById();
                    break;
                case 4:
                    purchaseTicketMenu();
                    break;
                case 5:
                    removeConcertMenu();
                    break;
                case 6:
                    displayAllPurchases();;
                    break;
                case 7:
                    System.out.println("Exiting Concert Ticket App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 7);
    }

    private static void addConcertMenu() {
        scanner.nextLine(); // consume newline
        System.out.print("Enter Artist Name: ");
        String artistName = scanner.nextLine();
        System.out.print("Enter Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Concert Date (yyyy-MM-dd): ");
        String dateStr = scanner.next();
        System.out.print("Enter Concert Location: ");
        String location = scanner.next();
        System.out.print("Enter Artist Country: ");
        String artistCountry = scanner.next();

        Concert newConcert = new ConcreteConcert(concertDatabase.getNextConcertId(), artistName, category, dateStr, location, artistCountry);
        concertDatabase.addConcert(newConcert);

        System.out.println("Concert added successfully!");
    }

    private static void displayAllConcerts() {
        System.out.println("\nAll Concerts:");
        for (int concertId : concertDatabase.getConcertMap().keySet()) {
            Concert concert = concertDatabase.getConcertById(concertId);
            concert.displayConcertDetails();
            System.out.println("--------------");
        }
    }

    private static void searchConcertById() {
        System.out.print("\nEnter Concert ID to search: ");
        int searchId = scanner.nextInt();
        Concert searchedConcert = concertDatabase.getConcertById(searchId);

        if (searchedConcert != null) {
            System.out.println("\nSearch Result:");
            searchedConcert.displayConcertDetails();
        } else {
            System.out.println("Concert not found with ID: " + searchId);
        }
    }

    private static void purchaseTicketMenu() {
        // Implement purchase ticket logic here
        scanner.nextLine(); // consume newline

        System.out.println("\nEnter Buyer Information:");
        System.out.print("Name: ");
        String buyerName = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("\nChoose Concert by ID:");
        int chosenConcertId = scanner.nextInt();
        Concert chosenConcert = concertDatabase.getConcertById(chosenConcertId);

        if (chosenConcert != null) {
            System.out.println("\nChoose Ticket Type (1 for VIP, 2 for Regular):");
            int chosenTicketType = scanner.nextInt();
            Ticket chosenTicket = (chosenTicketType == 1) ? new VipTicket(250000) : new RegularTicket(150000);

            System.out.print("\nEnter the quantity of tickets to purchase: ");
            int quantity = scanner.nextInt();

            TicketPurchase ticketPurchase = new TicketPurchase(buyerName, phoneNumber, email, chosenConcert, chosenTicket, quantity);
            ticketPurchases.add(ticketPurchase); // Menyimpan pembelian ke dalam list

            // Menampilkan hasil pembelian tiket
            System.out.println("\nTicket Purchase Details:");
            ticketPurchase.displayPurchaseDetails();
        } else {
            System.out.println("Concert not found with ID: " + chosenConcertId);
        }
    }
    
    private static void displayAllPurchases() {
        System.out.println("\nAll Ticket Purchases:");
        for (TicketPurchase ticketPurchase : ticketPurchases) {
            ticketPurchase.displayPurchaseDetails();
            System.out.println("--------------");
        }
    }
    
    private static void removeConcertMenu() {
        System.out.print("Enter Concert ID to remove: ");
        int removeConcertId = scanner.nextInt();
        Concert removedConcert = concertDatabase.getConcertById(removeConcertId);

        if (removedConcert != null) {
            concertDatabase.removeConcertById(removeConcertId);
        } else {
            System.out.println("Concert not found with ID: " + removeConcertId);
        }
    }


}

