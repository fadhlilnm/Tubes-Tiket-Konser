/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;
/**
 *
 * @author LENOVO
 */
public class TicketPurchase {
    private String buyerName;
    private String phoneNumber;
    private String email;
    private Concert concert;
    private Ticket ticket;
    private Date purchaseDate;
    private int quantity;

    public TicketPurchase(String buyerName, String phoneNumber, String email, Concert concert, Ticket ticket, int quantity) {
        this.buyerName = buyerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.concert = concert;
        this.ticket = ticket;
        this.quantity = quantity;
        this.purchaseDate = new Date();
    }

    public void displayPurchaseDetails() {
        double totalAmount = ticket.getTicketPrice() * quantity;
        
        System.out.println("Buyer Name: " + buyerName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        concert.displayConcertDetails();
        System.out.println("Ticket Type: " + ticket.getTicketType());
        System.out.println("Ticket Price per Unit: " + ticket.getTicketPrice());
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Purchase Date: " + purchaseDate);
    }
}
