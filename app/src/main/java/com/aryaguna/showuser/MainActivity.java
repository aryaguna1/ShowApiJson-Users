package com.aryaguna.showuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.aryaguna.showuser.model.User;
import com.aryaguna.showuser.service.ApiClient;
import com.aryaguna.showuser.service.GetService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //TextView csRecyclerView;
    RecyclerView recyclerView;
    CustomAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading");
        progressDialog.show();

        recyclerView = findViewById(R.id.CsRecyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/

        GetService getService = ApiClient.getRetrofitInstance().create(GetService.class);

        Call<List<User>> call = getService.getUsersList();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                progressDialog.dismiss();

                if (response.isSuccessful()){

                    List<User> users = response.body();
                    adapter = new CustomAdapter(MainActivity.this,users);
                    recyclerView.setAdapter(adapter);


                    return;
                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t){
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Ada yang salah .. tolong coba lagi", Toast.LENGTH_SHORT).show();
                //csRecyclerView.setText(t.getMessage());
            }
        });
    }
}