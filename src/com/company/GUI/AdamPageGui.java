package com.company.GUI;

import com.company.Database.DBmanager;
import com.company.Entity.Adam;
import com.company.Entity.Comments;
import com.company.Entity.NewsPost;
import com.company.Main;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Date;

public class AdamPageGui extends JFrame  {

    private JLabel nameofUser;
    private JLabel textLabe ;
    private JLabel jcomboboxlabel ;
    private JComboBox comboBox;
    private JTextField commenttext;
    private JButton buttonAddComment;
    private JButton backBTN;

    private int adam_id = 0 ;
    private String adamInformation;
    public void takeAdamId(Adam adam){
        adam_id = adam.getId();
        adamInformation = adam.getName();
    }


    public AdamPageGui(){
        setLayout(null);
        setLocation(500, 100);
        setSize(570, 300);
        setTitle("Adam page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jcomboboxlabel = new JLabel("All post:");
        jcomboboxlabel.setBounds(45 , 30 , 60 , 30);
        add(jcomboboxlabel);

        nameofUser = new JLabel();
        nameofUser.setText("User: " + adamInformation);
        nameofUser.setBounds(0 , 0 , 120 , 30);
        add(nameofUser);

        DBmanager dBmanager = new DBmanager();
        comboBox = new JComboBox(new DefaultComboBoxModel(dBmanager.allPost().toArray()));
        comboBox.setBounds(150 , 30 , 180 , 30);
        add(comboBox);


        textLabe = new JLabel("Enter comment:");
        textLabe.setBounds(45 , 70 , 60 , 30);
        add(textLabe);

        commenttext = new JTextField();
        commenttext.setBounds(150 , 70 , 180 , 30);
        add(commenttext);

        backBTN = new JButton("Back");
        backBTN.setBounds(150 , 160 , 120 , 30);
        backBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);
                Main.controller.regGui.setVisible(true);
            }
        });
        add(backBTN);

        buttonAddComment = new JButton("ADD COMMENT");
        buttonAddComment.setBounds(150 , 110 , 120 , 30 );
        buttonAddComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewsPost newsPost  = (NewsPost) comboBox.getSelectedItem();
                String comment = commenttext.getText();
                DBmanager dBmanager = new DBmanager();
                int post_id = newsPost.getId();
                Date date = new Date();
                Comments comments = new Comments(100 , adam_id ,post_id, comment,date );
                dBmanager.AddCommentToPost(comments);
                commenttext.setText("");
            }
        });
        add(buttonAddComment);


    }


}
