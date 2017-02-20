package com.example.org.mvp_mvvmpatterndemo.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.org.mvp_mvvmpatterndemo.R;
import com.example.org.mvp_mvvmpatterndemo.model.UserInfoModel;
import com.example.org.mvp_mvvmpatterndemo.presenters.MainPresenter;
import com.example.org.mvp_mvvmpatterndemo.views.interfaces.UserView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements UserView {
    @BindView(R.id.textViewName)
    TextView textViewName;

    @BindView(R.id.textViewEmail)
    TextView textViewEmail;

    @BindView(R.id.textViewAddress)
    TextView textViewAddress;
    private MainPresenter mainPresnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresnter = new MainPresenter(this);
        mainPresnter.getUserData(MainActivity.this);
    }

    /**
     * Used to set User name and email
     * @param userInfoList
     */
    @Override
    public void setUserData(UserInfoModel userInfoList) {
        List<UserInfoModel> infoList = new ArrayList<UserInfoModel>();
        infoList.addAll(userInfoList.getUserInfoModelList());
        textViewName.setText("Name : " + infoList.get(0).getName());
        textViewEmail.setText("Email : " + infoList.get(0).getEmail());
    }

    /**
     * Used to Set full address
     * @param address
     */
    @Override
    public void setFullAddress(String address) {
        textViewAddress.setText("Address : " + address);
    }
}
