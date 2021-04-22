package com.aryaguna.showuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    private String pathImage ="https://woodfibreinsulation.co.uk/wp-content/uploads/2017/04/blank-profile-picture-973460-1-1.png";

    TextView tvUsername, tvName, tvEmail, tvPhone, tvWebsite;
    ImageView ivIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvUsername = findViewById(R.id.tv_username);
        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvPhone = findViewById(R.id.tv_phone);
        tvWebsite = findViewById(R.id.tv_website);
        ivIcon = findViewById(R.id.iv_icon);

        getIncomingExtra();
    }
    public void getIncomingExtra(){
        if (getIntent().hasExtra("name") && getIntent().hasExtra("username") && getIntent().hasExtra("email") && getIntent().hasExtra("phone") && getIntent().hasExtra("website")){
            String name = getIntent().getStringExtra("name");
            String username = getIntent().getStringExtra("username");
            String email = getIntent().getStringExtra("email");
            String phone = getIntent().getStringExtra("phone");
            String website = getIntent().getStringExtra("website");

            setDataActivity(name, username, email, phone, website);
        }
    }
    private void setDataActivity(String name, String username, String email, String phone, String website){

        tvName.setText("Name : "+name);
        tvUsername.setText("Username : "+username);
        tvEmail.setText("Email : "+email);
        tvPhone.setText("Phone : "+phone);
        tvWebsite.setText("Website : "+website);

        Glide.with(this).asBitmap()
                .load(pathImage)
                .apply(new RequestOptions().fitCenter())
                .into(ivIcon);

    }
}