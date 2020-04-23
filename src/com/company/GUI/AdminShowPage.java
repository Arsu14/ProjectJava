package com.company.GUI;

import com.company.Database.DBmanager;
import com.company.Entity.Adam;
import com.company.Entity.Admin;
import com.company.Entity.Moderator;
import com.company.Entity.User;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.print.Pageable;
import java.util.ArrayList;

public class AdminShowPage extends JFrame{
    JLabel label = new JLabel("Moderator") ;
    private  JTable allPeaple ;
    private JScrollPane scrollPane;
    private JButton backBTN = new JButton("BACK");
    public AdminShowPage(){
        setLayout(null);
        setLocation(500, 100);
        setSize(570, 300);
        setTitle("AdminShowPage page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DBmanager dBmanager = new DBmanager();
        ArrayList<Adam> alladam =  dBmanager.AdminShowPage1();
        int size1 =alladam.size();

        ArrayList<Moderator> allmoderator = dBmanager.AdminShowPage2();
        int size2 = allmoderator.size();
        String[][] date = new String[size1+size2][5];

        for(int i = 0 ; i < alladam.size() ; i++){
            String strId  = Integer.toString(alladam.get(i).getId());
            date[i][0] = strId;
            String strEmail = alladam.get(i).getEmail();
            String strName = alladam.get(i).getName();
            String strSurname = alladam.get(i).getSurname();
            String strRole = Integer.toString(alladam.get(i).getRole());
            date[i][1] = strEmail;
            date[i][2] = strName ;
            date[i][3] = strSurname ;
            date[i][4] = strRole;
        }
        for(int i = 0 ; i < allmoderator.size() ; i++){
            String strId  = Integer.toString(allmoderator.get(i).getId());
            date[i+size1][0] = strId;
            String strEmail = allmoderator.get(i).getEmail();
            String strName = allmoderator.get(i).getName();
            String strSurname = allmoderator.get(i).getSurname();
            String strRole = Integer.toString(allmoderator.get(i).getRole());
            date[i+size1][1] = strEmail;
            date[i+size1][2] = strName ;
            date[i+size1][3] = strSurname ;
            date[i+size1][4] = strRole;
        }

        String nameCol[] = {"ID", "EMAIL" , "NAME" , "SURNAME" , "ROLE"} ;

        for(int i = 0 ; i < size1+ size2 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                System.out.print(date[i][j] + " ");
            }
            System.out.println();
        }

        allPeaple = new JTable(date , nameCol);
        scrollPane =new JScrollPane(allPeaple);
        scrollPane.setBounds(10, 10, 460, 200);
        add(scrollPane);
        backBTN.setBounds(200,220,100,30);
        backBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.controller.adminGUI.setVisible(true);
                Main.controller.adminShowPage.setVisible(false);
            }
        });
        add(backBTN);

    }
}
