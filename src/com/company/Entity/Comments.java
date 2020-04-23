package com.company.Entity;

import java.util.Date;

public class Comments {
    private int id ;
    private int adam_id ;
    private int newpost_id ;
    private String comment ;
    private Date commentPostDate ;

    public Comments(int id, int adam_id, int newpost_id, String comment, Date commentPostDate) {
        this.id = id;
        this.adam_id = adam_id;
        this.newpost_id = newpost_id;
        this.comment = comment;
        this.commentPostDate = commentPostDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdam_id() {
        return adam_id;
    }

    public void setAdam_id(int adam_id) {
        this.adam_id = adam_id;
    }

    public int getNewpost_id() {
        return newpost_id;
    }

    public void setNewpost_id(int newpost_id) {
        this.newpost_id = newpost_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCommentPostDate() {
        return commentPostDate;
    }

    public void setCommentPostDate(Date commentPostDate) {
        this.commentPostDate = commentPostDate;
    }
}
