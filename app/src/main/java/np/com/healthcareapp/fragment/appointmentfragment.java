package np.com.healthcareapp.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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


public class appointmentfragment extends Fragment {
    Context context;
    Activity activity;
    RecyclerView rcList;
    ArrayList<MyBookingModel.Message> message = new ArrayList<>();
    upcomminglistadapter bookadAdapter;
    String token, bearerToken;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_appointment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = getActivity();
        if(activity != null){
            context = activity.getApplicationContext();
        }

        token = TokenManager.getToken(getActivity());
        bearerToken = "Bearer " + token;

        rcList = view.findViewById(R.id.recview);
        rcList.setLayoutManager(new LinearLayoutManager((getActivity())));

        MyBooking bookingService = RetrofitService.getService(getContext()).create(MyBooking.class);
        Call<MyBookingModel> call = bookingService.getDoctors(bearerToken);

        call.enqueue(new Callback<MyBookingModel>() {
            @Override
            public void onResponse(Call<MyBookingModel> call, Response<MyBookingModel> response) {
                if (response.isSuccessful()){
                    MyBookingModel responseBooking = response.body();
                    if(responseBooking != null && responseBooking.getMessage() != null){
                        ArrayList<MyBookingModel.Message> responseArray = responseBooking.getMessage();
                        message.clear();
                        message.addAll(responseArray);
                       bookadAdapter = new upcomminglistadapter(requireActivity(), message);
                       rcList.setAdapter(bookadAdapter);
                        bookadAdapter.setOnCancelClickListener(new upcomminglistadapter.OnCancelClickListener() {
                            @Override
                            public void onCancelClick(String id) {
                                MyBooking bookingService = RetrofitService.getService(getContext()).create(MyBooking.class);
                                Call<MyBookingModel> call1 = bookingService.deleteAppointment(bearerToken, id);
                                call1.enqueue(new Callback<MyBookingModel>() {
                                    @Override
                                    public void onResponse(Call<MyBookingModel> call, Response<MyBookingModel> response) {
                                        if(response.isSuccessful()){
                                            MyBookingModel model = response.body();
                                            if(model != null && model.getSuccess() != null){
                                            Intent intent = new Intent(getActivity(), getActivity().getClass());
                                                Toast.makeText(getActivity(), "Appointment is cancelled.", Toast.LENGTH_SHORT).show();
                                                startActivity(intent);
                                            }
                                        }else{
                                            Toast.makeText(getActivity(), "Failed to cancel.", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<MyBookingModel> call, Throwable throwable) {
                                        Intent intent = new Intent(getActivity(), getActivity().getClass());
                                        startActivity(intent);
                                        Toast.makeText(getActivity(), "Something went wrong.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
                        bookadAdapter.notifyDataSetChanged();
                    }else if(responseBooking != null && responseBooking.getError() != null){
                        Toast.makeText(getActivity(), "No appointment found.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MyBookingModel> call, Throwable throwable) {
//                Log.v("appointmentsection", "Failure");
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();

    }
}