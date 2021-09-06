package com.example.myapplication.viewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.widget.LinearLayout;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.BR;
import com.example.myapplication.model.User;
import com.example.myapplication.view.adapter.UserAdapter;

import java.util.ArrayList;

public class UserViewModel extends BaseObservable {
    String name;
    String phone;
    Context context;
    MutableLiveData<ArrayList<UserViewModel>> ivds_com=new MutableLiveData<>();
    ArrayList<UserViewModel> arrayList=new ArrayList<>();
    int i;


    public UserViewModel(User user) {
        this.name = name;
        this.phone = phone;
    }

    public UserViewModel(Context context) {
        this.context = context;
        for (int h=0;h<5;h++){
            User user=new User("icd_com: "+h,"54855");
            UserViewModel userViewModel=new UserViewModel(user);
            arrayList.add(userViewModel);

        }
    }

    public void setI(int i) {
        this.i = i;
    }
@Bindable
    public int getI() {
        i=85;
        notifyPropertyChanged(BR.i);
        return i;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
   @Bindable
    public String getName() {

        notifyPropertyChanged(BR.name);
        return name;
    }
    @Bindable
    public String getPhone() {
        notifyPropertyChanged(BR.phone);
        return phone;
    }
    @BindingAdapter("bind:recycelerser")
    private static void recycelerViewBinder(RecyclerView recyclerView, MutableLiveData<ArrayList<UserViewModel>> arrayListMutableLiveData){
     arrayListMutableLiveData.observe((androidx.lifecycle.LifecycleOwner) recyclerView.getContext(), new Observer<ArrayList<UserViewModel>>() {
         @Override
         public void onChanged(ArrayList<UserViewModel> userViewModels) {
             UserAdapter userAdapter=new UserAdapter(userViewModels);
             recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL,false));
            recyclerView.setAdapter(userAdapter);
         }
     });
    }

    public ArrayList<UserViewModel> getArrayList() {
        return arrayList;
    }
}
