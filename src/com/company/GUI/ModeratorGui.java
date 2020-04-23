package com.company.GUI;

import com.company.Database.DBmanager;
import com.company.Entity.Moderator;
import com.company.Entity.NewsPost;
import com.company.Entity.User;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Date;

public class ModeratorGui extends JFrame{
    JLabel addpost = new JLabel("Add post:");
    JLabel ltitle = new JLabel("title:");
    JTextField titletext = new JTextField("");
    JLabel lshortContent = new JLabel("shortContent:");
    JTextField shortContenttext = new JTextField("");
    JLabel lcontent = new JLabel("content:");
    JTextField contenttext = new JTextField("");
    JButton postBTN = new JButton("LOG IN");
    JButton backBTN = new JButton("Back");
    int moderator_id = 0 ;
    public void helpmethod(Moderator moderator){
        moderator_id = moderator.getId() ;
    }


    public ModeratorGui(){
        setLayout(null);
        setLocation(500, 100);
        setSize(570, 300);
        setTitle("Moderator page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addpost.setBounds(30, 15, 200, 30);
        add(addpost);

        ltitle.setBounds(30, 50, 80, 20);
        add(ltitle);
        titletext.setBounds(130, 50, 100, 20);
        add(titletext);

        lshortContent.setBounds(30, 80, 80, 20);
        add(lshortContent);
        shortContenttext.setBounds(130, 80, 100, 20);
        add(shortContenttext);

        lcontent.setBounds(30, 110, 80, 20);
        add(lcontent);
        contenttext.setBounds(130, 110, 100, 20);
        add(contenttext);

        backBTN.setBounds(30 , 190 , 150 , 30);
        backBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                Main.controller.regGui.setVisible(true);
            }
        });
        add(backBTN);

        postBTN.setBounds(30,140,150,30);
        postBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String titleStr = titletext.getText() ;
                String shortContentStr = shortContenttext.getText();
                String contextStr = contenttext.getText();
                Date date = new Date();
                NewsPost newsPost = new NewsPost(100 , titleStr , shortContentStr, contextStr , moderator_id , date);
                DBmanager dBmanager = new DBmanager();
                dBmanager.addNewpost(newsPost);
                titletext.setText("");
                shortContenttext.setText("");
                contenttext.setText("");
            }
        });
        add(postBTN);
    }
}
