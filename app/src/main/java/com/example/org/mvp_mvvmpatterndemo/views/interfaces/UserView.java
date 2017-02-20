package com.example.org.mvp_mvvmpatterndemo.views.interfaces;

import com.example.org.mvp_mvvmpatterndemo.model.UserInfoModel;

/**
 * Created on 16/2/17.
 */

public interface UserView {
    public void setUserData(UserInfoModel jsonString);
    public void setFullAddress(String address);
}
