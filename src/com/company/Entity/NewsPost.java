package com.company.Entity;

import java.util.Date;

public class NewsPost {
    private int id;
    private String title;
    private String shortContent;
    private String content;
    private int author;
    private Date postDate;

    public NewsPost(int id, String title, String shortContent, String content, int author, Date postDate) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.content = content;
        this.author = author;
        this.postDate = postDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return  title ;
    }
}
