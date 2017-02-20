package com.example.org.mvp_mvvmpatterndemo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16/2/17.
 */

public class UserInfoModel {

    private String name , email, street, suite, city, zipcode;

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    List<UserInfoModel> userInfoModelList = new ArrayList<UserInfoModel>();

    public List<UserInfoModel> getUserInfoModelList() {
        return userInfoModelList;
    }

    public void setUserInfoModelList(List<UserInfoModel> userInfoModelList) {
        this.userInfoModelList = userInfoModelList;
    }
}
