package com.saxion.nl.ns.ithardwaremanager.models;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User) {
            return this.email.equals(((User) obj).getEmail()) && this.password.equals(((User) obj).getPassword());
        }
        return false;
    }
}
