package com.company.Database;

import com.company.Entity.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DBmanager {
    private Connection connection;

    public DBmanager() {
    }

    public void registrationAdam(Adam adam) {
        try {
            FileReader from = new FileReader("C:\\Users\\Tazhben\\Desktop\\OneLabCamunda\\untitled26\\src\\com\\company\\Database\\DBConficuration.txt");
            Scanner scanner = new Scanner(from);
            String driver = null, dbname = null, port = null, hostname = null, user = null;
            while (scanner.hasNextLine()) {//true
                dbname = scanner.next();
                port = scanner.next();
                hostname = scanner.next();
                user = scanner.next();
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(hostname + port + "/" + dbname, user, "");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO fpost.users(id , email , password , name , surname , role)"
                            + "VALUES(NULL  , ? , ? , ? , ? , ? ) ");
            preparedStatement.setString(1, adam.getEmail());
            preparedStatement.setString(2, adam.getPassword());
            preparedStatement.setString(3, adam.getName());
            preparedStatement.setString(4, adam.getSurname());
            preparedStatement.setInt(5, 3);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException | FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public User authorization(String login, String password) {
        boolean check = false;
        try {
            FileReader from = new FileReader("C:\\Users\\Tazhben\\Desktop\\OneLabCamunda\\untitled26\\src\\com\\company\\Database\\DBConficuration.txt");
            Scanner scanner = new Scanner(from);
            String driver = null, dbname = null, port = null, hostname = null, user = null;
            while (scanner.hasNextLine()) {//true
                dbname = scanner.next();
                port = scanner.next();
                hostname = scanner.next();
                user = scanner.next();
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(hostname + port + "/" + dbname, user, "");

            Statement getStatement = connection.createStatement();
            ResultSet resultSet = getStatement.executeQuery("SELECT  *from fpost.users");
            while (resultSet.next()) {
                int idBD = resultSet.getInt(1);
                String emailBD = resultSet.getString(2);
                String passwordBD = resultSet.getString(3);
                String nameBD = resultSet.getString(4);
                String surnameBd = resultSet.getString(5);
                int roleUser = resultSet.getInt(6);
                if (emailBD.compareTo(login) == 0 && passwordBD.compareTo(password) == 0) {
                    check = true;
                    if (roleUser == 1) {
                        Admin admin = new Admin(idBD, emailBD, passwordBD, roleUser);
                        return admin;
                    } else if (roleUser == 2) {
                        Moderator moderator = new Moderator(idBD, emailBD, passwordBD, nameBD , surnameBd , roleUser);
                        return moderator;
                    } else if (roleUser == 3) {
                        Adam adam = new Adam(idBD, emailBD, passwordBD, nameBD, surnameBd, roleUser);
                        return adam;
                    }
                }
            }

        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null ;
    }

    public void registrationModerator(Moderator moderator) {
        boolean check = false;
        try {
            FileReader from = new FileReader("C:\\Users\\Tazhben\\Desktop\\OneLabCamunda\\untitled26\\src\\com\\company\\Database\\DBConficuration.txt");
            Scanner scanner = new Scanner(from);
            String driver = null, dbname = null, port = null, hostname = null, user = null;
            while (scanner.hasNextLine()) {//true
                dbname = scanner.next();
                port = scanner.next();
                hostname = scanner.next();
                user = scanner.next();
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(hostname + port + "/" + dbname, user, "");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO fpost.users(id , email , password , name , surname , role)"
                            + "VALUES(NULL  , ? , ? , ? , ? , ? ) ");
            preparedStatement.setString(1, moderator.getEmail());
            preparedStatement.setString(2, moderator.getPassword());
            preparedStatement.setString(3, moderator.getName());
            preparedStatement.setString(4, moderator.getSurname());
            preparedStatement.setInt(5, 2);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Adam> AdminShowPage1() {
        boolean check = false;
        try {
            FileReader from = new FileReader("C:\\Users\\Tazhben\\Desktop\\OneLabCamunda\\untitled26\\src\\com\\company\\Database\\DBConficuration.txt");
            Scanner scanner = new Scanner(from);
            String driver = null, dbname = null, port = null, hostname = null, user = null;
            while (scanner.hasNextLine()) {//true
                dbname = scanner.next();
                port = scanner.next();
                hostname = scanner.next();
                user = scanner.next();
            }
            ArrayList<Adam> arrayList = new ArrayList<>();
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(hostname + port + "/" + dbname, user, "");

            Statement getStatement = connection.createStatement();
            ResultSet resultSet = getStatement.executeQuery("SELECT  *from fpost.users");
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String email = resultSet.getString(2) ;
                String password  = resultSet.getString(3);
                String name = resultSet.getString(4);
                String surname = resultSet.getString(5);
                int role = resultSet.getInt(6);
                if(role == 3){
                    Adam adam = new Adam(id , email , password , name , surname , role);
                    arrayList.add(adam);
                }
            }

            return arrayList;


        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null ;
    }

    public ArrayList<Moderator> AdminShowPage2() {
        boolean check = false;
        try {
            FileReader from = new FileReader("C:\\Users\\Tazhben\\Desktop\\OneLabCamunda\\untitled26\\src\\com\\company\\Database\\DBConficuration.txt");
            Scanner scanner = new Scanner(from);
            String driver = null, dbname = null, port = null, hostname = null, user = null;
            while (scanner.hasNextLine()) {//true
                dbname = scanner.next();
                port = scanner.next();
                hostname = scanner.next();
                user = scanner.next();
            }
            ArrayList<Moderator> arrayList = new ArrayList<>();
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(hostname + port + "/" + dbname, user, "");

            Statement getStatement = connection.createStatement();
            ResultSet resultSet = getStatement.executeQuery("SELECT  *from fpost.users");
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String email = resultSet.getString(2) ;
                String password  = resultSet.getString(3);
                String name = resultSet.getString(4);
                String surname = resultSet.getString(5);
                int role = resultSet.getInt(6);
                if(role == 2){
                    Moderator moderator= new Moderator(id , email , password , name , surname , role);
                    arrayList.add(moderator);
                }
            }

            return arrayList;


        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null ;
    }


    public void addNewpost(NewsPost newsPost) {
        try {
            FileReader from = new FileReader("C:\\Users\\Tazhben\\Desktop\\OneLabCamunda\\untitled26\\src\\com\\company\\Database\\DBConficuration.txt");
            Scanner scanner = new Scanner(from);
            String driver = null, dbname = null, port = null, hostname = null, user = null;
            while (scanner.hasNextLine()) {//true
                dbname = scanner.next();
                port = scanner.next();
                hostname = scanner.next();
                user = scanner.next();
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(hostname + port + "/" + dbname, user, "");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO fpost.newpost(id , title , shortContent, content , author_id , postDate)"
                            + "VALUES(NULL  , ? , ? , ? , ? , ? ) ");
            preparedStatement.setString(1, newsPost.getTitle());
                preparedStatement.setString(2, newsPost.getShortContent());
            preparedStatement.setString(3, newsPost.getContent());
            preparedStatement.setInt(4, newsPost.getAuthor());
            java.util.Date postDate = newsPost.getPostDate();
            preparedStatement.setDate(5,  new java.sql.Date(postDate.getTime()));
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }}


    public ArrayList<NewsPost> allPost(){
        ArrayList<NewsPost> arrayList = new ArrayList<>();
        try {
            FileReader from = new FileReader("C:\\Users\\Tazhben\\Desktop\\OneLabCamunda\\untitled26\\src\\com\\company\\Database\\DBConficuration.txt");
            Scanner scanner = new Scanner(from);
            String driver = null, dbname = null, port = null, hostname = null, user = null;
            while (scanner.hasNextLine()) {//true
                dbname = scanner.next();
                port = scanner.next();
                hostname = scanner.next();
                user = scanner.next();
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(hostname + port + "/" + dbname, user, "");

            Statement getStatement = connection.createStatement();
            ResultSet resultSet = getStatement.executeQuery("SELECT  *from fpost.newpost");
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String title = resultSet.getString(2) ;
                String shortContent  = resultSet.getString(3);
                String content = resultSet.getString(4);
                int author_id = resultSet.getInt(5);
                Date postDate  = resultSet.getDate(6);
                NewsPost newsPost = new NewsPost(id , title , shortContent , content ,author_id , postDate);
                arrayList.add(newsPost);

            }
            return arrayList;

        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }return null;
    }


    public void AddCommentToPost(Comments comments){
        try {
            FileReader from = new FileReader("C:\\Users\\Tazhben\\Desktop\\OneLabCamunda\\untitled26\\src\\com\\company\\Database\\DBConficuration.txt");
            Scanner scanner = new Scanner(from);
            String driver = null, dbname = null, port = null, hostname = null, user = null;
            while (scanner.hasNextLine()) {//true
                dbname = scanner.next();
                port = scanner.next();
                hostname = scanner.next();
                user = scanner.next();
            }

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(hostname + port + "/" + dbname, user, "");

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO fpost.comments(id , author_id , post_id, comment , Date_comment )"
                            + "VALUES(NULL  , ? , ? , ? , ? ) ");
            preparedStatement.setInt(1, comments.getAdam_id());
            preparedStatement.setInt(2, comments.getNewpost_id());
            preparedStatement.setString(3, comments.getComment());
            java.util.Date postDate = comments.getCommentPostDate();
            preparedStatement.setDate(4,  new java.sql.Date(postDate.getTime()));
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (ClassNotFoundException | SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }




}











