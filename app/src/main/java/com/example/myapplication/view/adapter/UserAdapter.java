package com.example.myapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ItemUserBining;
import com.example.myapplication.databinding.ItemUserBining;
import com.example.myapplication.viewmodel.UserViewModel;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CusuomHolder> {
private ArrayList<UserViewModel> arrayList=new ArrayList<>();
private LayoutInflater layoutInflater;

    public UserAdapter(ArrayList<UserViewModel> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public CusuomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater==null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
           ItemUserBining itemUserBinding= DataBindingUtil.inflate(layoutInflater, R.layout.item_user,parent,false);
           return new CusuomHolder(itemUserBinding);

    }


    @Override
    public void onBindViewHolder(@NonNull CusuomHolder holder, int position) {
UserViewModel userViewModel=arrayList.get(position);
holder.bind(userViewModel);



    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class CusuomHolder extends RecyclerView.ViewHolder{

        private ItemUserBining itemUserBinding;

        public CusuomHolder(ItemUserBining itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding=itemUserBinding;
        }

        public ItemUserBining getItemUserBinding() {
            return itemUserBinding;
        }


        public void bind(UserViewModel userViewModel){
            this.itemUserBinding.setItem(userViewModel);
            this.itemUserBinding.executePendingBindings();
        }

    }
}
