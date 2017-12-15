package com.bestteam.videolibr;

/**
 * Created by Arkadi on 30/11/2017.
 */

public class User
{
    private String userName, PassWord, email, fName, Lname, city, street;
    private int index;

    public User(String userName, String passWord, int index) {
        this.userName = userName;
        PassWord = passWord;
        this.email = null;
        this.fName = null;
        this.Lname = null;
        this.city = null;
        this.street = null;
        this.index = index;
    }

    public User(String userName, String passWord, String email, String fName, String lname, String city, String street,int index) {
        this.userName = userName;
        PassWord = passWord;
        this.email = email;
        this.fName = fName;
        Lname = lname;
        this.city = city;
        this.street = street;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
