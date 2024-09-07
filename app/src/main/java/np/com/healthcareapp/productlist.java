package np.com.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import np.com.healthcareapp.adapter.productlistadapter;
import np.com.healthcareapp.model.DoctorModel;
import np.com.healthcareapp.model.doctor;
import np.com.healthcareapp.remote.TokenManager;
import np.com.healthcareapp.retrofit.RetrofitService;
import np.com.healthcareapp.service.Doctor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class productlist extends AppCompatActivity {
    ArrayList<DoctorModel.Doctors> doctors = new ArrayList<>();
    productlistadapter doctorAdapter;



    RecyclerView rcList;
    String token, bearerToken;
    EditText etSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.productlist);

        TextView tvTitle = findViewById(R.id.tvTitle);
        etSearch = findViewById(R.id.search);
        String suggestion = "Suggested Doctors";
        tvTitle.setText(suggestion);

        token = TokenManager.getToken(getApplicationContext());
        bearerToken = "Bearer "+token;

        rcList = findViewById(R.id.rvdoctors);
        rcList.setLayoutManager(new LinearLayoutManager(productlist.this));

        Doctor doctorService = RetrofitService.getService(this).create(Doctor.class);
        Call<DoctorModel> call = doctorService.getDoctor(bearerToken);
        call.enqueue(new Callback<DoctorModel>() {

            @Override
            public void onResponse(Call<DoctorModel> call, Response<DoctorModel> response) {
                if(response.isSuccessful()){
                    DoctorModel responseDoctor = response.body();
                    if(responseDoctor != null && Objects.equals(responseDoctor.getStatus(), "true")){
                        ArrayList<DoctorModel.Doctors> responseArray = responseDoctor.getDoctors();
                        doctors.clear();
                        doctors.addAll(responseArray);
                        doctorAdapter = new productlistadapter(productlist.this,doctors);
                        rcList.setAdapter(doctorAdapter);
                        doctorAdapter.setOnItemClickListener(new productlistadapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(String id, String name, String specialist, String degree) {
                                Intent intent = new Intent(productlist.this, doctordetail.class);
                                intent.putExtra("id",id);
                                intent.putExtra("name",name);
                                intent.putExtra("specialist",specialist);
                                intent.putExtra("degree",degree);
                                startActivity(intent);
                            }
                        });
                        doctorAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<DoctorModel> call, Throwable throwable) {

            }
        });
        searchFilter();
    }

    protected void searchFilter(){
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                doctorAdapter.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

}