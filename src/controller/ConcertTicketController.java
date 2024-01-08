/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Koneksi.db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import view.Admin;
import view.ConcertMenu;
import view.Home;
import view.Login;
import view.Purchase;
import view.Register;

/**
 *
 * @author LENOVO
 */


public class ConcertTicketController {

    private Login loginView;
    private Home homeView;
    private Register registerView;
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public ConcertTicketController(Login loginView, Home homeView, Register registerView) {
        this.loginView = loginView;
        this.homeView = homeView;
        this.registerView = registerView;
        attachEventListeners();
    }

    private void attachEventListeners() {
        loginView.getjButtonLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToLoginPage();
            }
        });

        loginView.getjButtonRegister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToRegisterPage();
            }
        });
        /*
        registerView.getjButtonSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
*/
        homeView.getjButtonAdmin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToAdminPage();
            }
        });

        homeView.getjButtonConcert().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToConcertMenu();
            }
        });

        homeView.getjButtonPurchase().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToPurchasePage();
            }
        });

        homeView.getjButtonLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
    }

    
    private void goToLoginPage() {
        loginView.setVisible(false);
        new Home().setVisible(true);
    }
    
    private void login() {
        try {
            String sql = "SELECT * FROM akun WHERE username=('"+loginView.getJusername()+"') AND password=('"+loginView.getjPassword()+"')";
            conn = (Connection)db.mycon();
            pst = conn.prepareStatement(sql);

            rs = pst.executeQuery(sql);

            if (rs.next()) {
                if (loginView.getJusername().equals(rs.getString("username")) && loginView.getjPassword().equals(rs.getString("password"))) {
                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                    loginView.setVisible(false);
                    homeView.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login Gagal");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void goToRegisterPage() {
        loginView.setVisible(false);
        new Register().setVisible(true);
    }


    private void register() {
        try{
            String sql = "INSERT INTO akun VALUES ('"+registerView.getjUsername()+"','"+registerView.getjPassword()+"')";
            conn = (Connection)db.mycon();
            pst = conn.prepareStatement(sql);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Register Berhasil");
            registerView.setVisible(false);
            loginView.setVisible(true);
            
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void goToAdminPage() {
        homeView.setVisible(false);
        new Admin().setVisible(true);
    }

    private void goToConcertMenu() {
        homeView.setVisible(false);
        new ConcertMenu().setVisible(true);
    }

    private void goToPurchasePage() {
        homeView.setVisible(false);
        new Purchase().setVisible(true);
    }

    private void logout() {
        homeView.setVisible(false);
        loginView.setVisible(true);
    }

}
