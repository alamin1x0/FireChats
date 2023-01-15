package com.developeralamin.firechat.model;

public class UserModel {

    private String name,address,email,phone, profileurl, userid;


    public UserModel() {
    }

    public UserModel(String name, String address, String email, String phone, String profileurl, String userid) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.profileurl = profileurl;
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileurl() {
        return profileurl;
    }

    public void setProfileurl(String profileurl) {
        this.profileurl = profileurl;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}



