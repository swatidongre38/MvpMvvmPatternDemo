package com.example.org.mvp_mvvmpatterndemo.viewmodels;

import com.example.org.mvp_mvvmpatterndemo.model.UserInfoModel;

import java.util.List;

/**
 * Created on 20/2/17.
 */

public class UserViewModel {

    List<UserInfoModel> userInfoList;
    public UserViewModel(List<UserInfoModel> list){
        this.userInfoList = list;
    }
    public String getFullAddress() {
        String fullAddress = userInfoList.get(0).getStreet() +
                " "+ userInfoList.get(0).getSuite() +
                " "+ userInfoList.get(0).getCity()+
                " "+userInfoList.get(0).getZipcode();
        return fullAddress;
    }


}
