package com.aryaguna.showuser;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aryaguna.showuser.model.User;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.AdapterHolder>{

    private Context context;
    private List<User> userList;

    private String pathImage ="https://woodfibreinsulation.co.uk/wp-content/uploads/2017/04/blank-profile-picture-973460-1-1.png";

    public CustomAdapter(Context context, List<User> userList){
        this.context = context;
        this.userList = userList;

    }
    @NonNull
    @Override
    public CustomAdapter.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        AdapterHolder holder = new AdapterHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.AdapterHolder holder, int position) {
        final User getUserList = userList.get(position);
        String name = getUserList.getName();
        int id = getUserList.getId();

        holder.tvName.setText(""+name);
        holder.tvId.setText("Id : "+id);

        Glide.with(holder.mView.getContext())
                .load(pathImage)
                .apply(new RequestOptions().fitCenter())
                .into(holder.ivIcon);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "loading...", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra( "id",getUserList.getId());
                intent.putExtra("name", getUserList.getName());
                intent.putExtra("username", getUserList.getUsername());
                intent.putExtra("email", getUserList.getEmail());
                intent.putExtra("phone", getUserList.getPhone());
                intent.putExtra("website", getUserList.getWebsite());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView tvUsername, tvName, tvEmail, tvId, tvPhone, tvWebsit;
        ImageView ivIcon;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            tvUsername = mView.findViewById(R.id.tv_username);
            tvName = mView.findViewById(R.id.tv_name);
            tvEmail = mView.findViewById(R.id.tv_email);
            tvId = mView.findViewById(R.id.tv_id);
            tvPhone = mView.findViewById(R.id.tv_phone);
            tvWebsit = mView.findViewById(R.id.tv_website);
            ivIcon = mView.findViewById(R.id.iv_icon);
        }
    }
}
