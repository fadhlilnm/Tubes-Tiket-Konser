/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Home;
import view.Login;
import view.Register;

/**
 *
 * @author LENOVO
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {
        // Create instances of the views
        Login loginView = new Login();
        Home homeView = new Home();
        Register registerView = new Register();

        // Create an instance of the controller and pass the views to it
        new ConcertTicketController(loginView, homeView, registerView);

        // Show the login view initially
        loginView.setVisible(true);
    }
}

