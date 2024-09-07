package np.com.healthcareapp.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.Objects;

import np.com.healthcareapp.R;
import np.com.healthcareapp.adapter.upcomminglistadapter;

import np.com.healthcareapp.model.MyBookingModel;
import np.com.healthcareapp.remote.TokenManager;
import np.com.healthcareapp.retrofit.RetrofitService;

import np.com.healthcareapp.service.MyBooking;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class upcommingfragment extends Fragment {

Context context;

Activity activity;
    ArrayList<MyBookingModel.Message> doctors = new ArrayList<>();
  upcomminglistadapter bookadAdapter;


    RecyclerView rcList;

    String token,bearerToken;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_upcommingfragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        token = TokenManager.getToken(context.getApplicationContext());
        bearerToken = "Bearer" + token;

        rcList = view.findViewById(R.id.recview);
        rcList.setLayoutManager(new LinearLayoutManager((getActivity())));

        //retrofit

        MyBooking bookingService = RetrofitService.getService(getContext()).create(MyBooking.class);
        Call<MyBookingModel> call = bookingService.getDoctors(bearerToken);




    }


}





