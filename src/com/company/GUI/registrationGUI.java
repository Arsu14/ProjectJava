package com.company;

import com.company.Database.DBmanager;
import com.company.Entity.Adam;
import com.company.Entity.Admin;
import com.company.Entity.Moderator;
import com.company.Entity.User;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.print.Pageable;
import java.util.ArrayList;

public class registrationGUI extends JFrame {
    JLabel Authorization = new JLabel("Authorization:");
    JLabel alogin = new JLabel("login:");
    JTextField log = new JTextField("");
    JLabel apassword = new JLabel("password:");
    JTextField pass = new JTextField("");
    JButton auth = new JButton("");

    JLabel Registration = new JLabel("Registration:");
    JLabel rlogin = new JLabel("login:");
    JTextField login = new JTextField("");
    JLabel name = new JLabel("name:");
    JTextField rname = new JTextField("");
    JLabel surname = new JLabel("surname:");
    JTextField rsurname = new JTextField("");
    JLabel rpassword = new JLabel("password:");
    JTextField password = new JTextField("");
    JLabel repass = new JLabel("repeat password:");
    JTextField repassword = new JTextField("");
    JButton reg = new JButton("login");
    JButton backBTN = new JButton("Back");


    public registrationGUI(){
        setLayout(null);
        setLocation(500, 100);
        setSize(570, 300);
        setTitle("Login or registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Authorization.setBounds(70, 15, 200, 30);
        add(Authorization);

        alogin.setBounds(30, 50, 80, 20);
        add(alogin);
        log.setBounds(100, 50, 100, 20);
        add(log);

        apassword.setBounds(30, 80, 80, 20);
        add(apassword);
        pass.setBounds(100, 80, 100, 20);
        add(pass);

        auth.setBounds(55, 110, 120, 20);
        auth.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String Authlogin = log.getText();
                String Authpassword = pass.getText() ;
                DBmanager dBmanager = new DBmanager();
                User user = dBmanager.authorization(Authlogin , Authpassword);
                if(user instanceof Adam){
                    System.out.println("adam");
                    Main.controller.adamPageGui.takeAdamId((Adam) user);
                    Main.controller.adamPageGui.setVisible(true);
                    Main.controller.regGui.setVisible(false);
                }
                else if(user instanceof Moderator){
                    System.out.println("Moderator");
                    Main.controller.moderator.helpmethod((Moderator) user);
                    Main.controller.moderator.setVisible(true);
                    Main.controller.regGui.setVisible(false);
                }
                else if(user instanceof Admin){
                    System.out.println("admin");
                    Main.controller.adminGUI.setVisible(true);
                    Main.controller.regGui.setVisible(false);
                }
                else{
                    System.out.println("No men");
                }
            }
        });
        auth.setText("login");
        add(auth);

        Registration.setBounds(350, 15, 200, 30);
        add(Registration);

        rlogin.setBounds(310, 50, 80, 20);
        add(rlogin);
        login.setBounds(420, 50, 100, 20);
        add(login);

        name.setBounds(310, 80, 80, 20);
        add(name);
        rname.setBounds(420, 80, 100, 20);
        add(rname);

        surname.setBounds(310, 110, 80, 20);
        add(surname);
        rsurname.setBounds(420, 110, 100, 20);
        add(rsurname);


        rpassword.setBounds(310, 140, 80, 20);
        add(rpassword);
        password.setBounds(420,140, 100, 20);
        add(password);

        repass.setBounds(310, 170, 100, 20);
        add(repass);
        repassword.setBounds(420, 170, 100, 20);
        add(repassword);



        reg.setBounds(360, 200, 100, 20);
        reg.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String email = login.getText();
                String passwor =password.getText() ;
                String nam = rname.getText();
                String sur = rsurname.getText();
                Adam adam = new Adam(100 , email , passwor , nam , sur , 3);
                DBmanager dBmanager = new DBmanager();
                dBmanager.registrationAdam(adam);
                login.setText("");
                rname.setText("");
                surname.setText("");
                password.setText("");
                repassword.setText("");
                rsurname.setText("");
            }
            });
        add(reg);

    }
}
