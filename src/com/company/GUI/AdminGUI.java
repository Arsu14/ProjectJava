package com.company.GUI;

import com.company.Database.DBmanager;
import com.company.Entity.Adam;
import com.company.Entity.Moderator;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.print.Pageable;
import java.util.ArrayList;

public class AdminGUI extends JFrame{

    JLabel Registration = new JLabel("Add moderator:");
    JLabel rlogin = new JLabel("login:");
    JTextField login = new JTextField("");
    JLabel name = new JLabel("name:");
    JTextField rname = new JTextField("");
    JLabel surname = new JLabel("surname:");
    JTextField rsurname = new JTextField("");
    JLabel rpassword = new JLabel("password:");
    JTextField password = new JTextField("");
    JButton reg = new JButton("LOG IN");
    JButton shopBTN = new JButton("SHOW all");

    public AdminGUI(){
        setLayout(null);
        setLocation(500, 100);
        setSize(570, 300);
        setTitle("Moderator page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Registration.setBounds(30, 15, 200, 30);
        add(Registration);

        rlogin.setBounds(30, 50, 80, 20);
        add(rlogin);
        login.setBounds(130, 50, 100, 20);
        add(login);

        name.setBounds(30, 80, 80, 20);
        add(name);
        rname.setBounds(130, 80, 100, 20);
        add(rname);

        surname.setBounds(30, 110, 80, 20);
        add(surname);
        rsurname.setBounds(130, 110, 100, 20);
        add(rsurname);


        rpassword.setBounds(30, 140, 80, 20);
        add(rpassword);
        password.setBounds(130,140, 100, 20);
        add(password);

        shopBTN.setBounds(50 , 210 , 150 , 30);
        shopBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.controller.adminShowPage.setVisible(true);
                Main.controller.adminGUI.setVisible(false);
            }
        });
        add(shopBTN);

        reg.setBounds(50, 170, 150, 30);
        reg.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String email = login.getText();
                String passwor =password.getText() ;
                String nam = rname.getText();
                String sur = rsurname.getText();
                Moderator moderator = new Moderator(100 , email , passwor , nam , sur , 2);
                DBmanager dBmanager = new DBmanager();
                dBmanager.registrationModerator(moderator);
                login.setText("");
                rname.setText("");
                rsurname.setText("");
                password.setText("");
                rsurname.setText("");
            }
        });
        reg.setText("Add moderator");
        add(reg);

    }
}
