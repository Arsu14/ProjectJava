package com.company.Entity;

public class Admin extends User {
    private int role ;

    public Admin(int id, String email, String password, int role) {
        super(id, email, password);
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "role=" + role +
                '}';
    }
}
