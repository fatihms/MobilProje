package com.example.mobilproje;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder> {

    List<UserListModel> userList;

    public UserListAdapter(List<UserListModel> p_userList){
        userList = p_userList;
    }

    @NonNull
    @Override
    public UserListAdapter.UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        UserListViewHolder userListViewHolder = new UserListViewHolder(view);
        return userListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.UserListViewHolder holder, int position) {
        holder.userImage.setImageResource(userList.get(position).imageID);
        holder.userName.setText("Kullanıcı Adı: "+userList.get(position).userName);
        holder.userPassword.setText("Parola: "+userList.get(position).password);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserListViewHolder extends RecyclerView.ViewHolder{

        TextView userName, userPassword;
        ImageView userImage;

        public  UserListViewHolder(@NonNull View itemView){
            super(itemView);

            userName = itemView.findViewById(R.id.tv_userName);
            userPassword = itemView.findViewById(R.id.tv_userPassword);
            userImage = itemView.findViewById(R.id.iv_listProfile);
        }

    }

}
