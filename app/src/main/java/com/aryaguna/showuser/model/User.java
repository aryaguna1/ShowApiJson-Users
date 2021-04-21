package com.aryaguna.showuser.model;

import com.google.gson.annotations.SerializedName;

public class User {
    //@SerializedName("id")
    private int id;
    //@SerializedName("username")
    private String username;
   //@SerializedName("name")
    private String name;
   //@SerializedName("email")
    private String email;

    public User(int id, String username, String name, String email){
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
