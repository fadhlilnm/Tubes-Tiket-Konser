/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LENOVO
 */
public class RegularTicket implements Ticket {
    private String ticketType = "Regular";
    private double ticketPrice;

    public RegularTicket(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String getTicketType() {
        return ticketType;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }
}