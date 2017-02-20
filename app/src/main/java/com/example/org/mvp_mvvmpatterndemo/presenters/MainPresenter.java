package com.example.org.mvp_mvvmpatterndemo.presenters;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.org.mvp_mvvmpatterndemo.model.UserInfoModel;
import com.example.org.mvp_mvvmpatterndemo.viewmodels.UserViewModel;
import com.example.org.mvp_mvvmpatterndemo.views.interfaces.UserView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 16/2/17.
 */

public class MainPresenter {
    private UserView mUserView;
    private Context mContext;
    String JSON_URL = "https://jsonplaceholder.typicode.com/users";

    public MainPresenter(UserView userView) {
        this.mUserView = userView;
    }

    /**
     * Method used to get user info
     * @param context
     */
    public void getUserData(Context context) {
        this.mContext = context;
        sendRequest();
    }

    /**
     * Method used to hit user info service
     */
    private void sendRequest() {
        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        UserInfoModel userInfoModel = parseData(response);
                        List<UserInfoModel> list = new ArrayList<UserInfoModel>();
                        list.addAll(userInfoModel.getUserInfoModelList());
                        UserViewModel userViewModel = new UserViewModel(list);
                        mUserView.setUserData(parseData(response));
                        mUserView.setFullAddress(userViewModel.getFullAddress());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        requestQueue.add(stringRequest);
    }

    /**
     * Method used to parse the data
     * @param response
     * @return
     */
    private UserInfoModel parseData(String response) {
        UserInfoModel userInfoList = new UserInfoModel();
        List<UserInfoModel> userInfoModelList = new ArrayList<UserInfoModel>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                UserInfoModel userInfoModel = new UserInfoModel();
                userInfoModel.setName(jsonObject.getString("name"));
                userInfoModel.setEmail(jsonObject.getString("email"));
                JSONObject jsonArrayAdd = jsonObject.getJSONObject("address");
                userInfoModel.setStreet(jsonArrayAdd.getString("street"));
                userInfoModel.setSuite(jsonArrayAdd.getString("suite"));
                userInfoModel.setCity(jsonArrayAdd.getString("city"));
                userInfoModel.setZipcode(jsonArrayAdd.getString("zipcode"));
                userInfoModelList.add(userInfoModel);
            }
            userInfoList.setUserInfoModelList(userInfoModelList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfoList;
    }
}
