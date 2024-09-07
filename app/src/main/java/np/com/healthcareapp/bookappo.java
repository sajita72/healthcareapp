package np.com.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

import np.com.healthcareapp.fragment.appointmentfragment;
import np.com.healthcareapp.model.AppointmentModel;
import np.com.healthcareapp.remote.TokenManager;
import np.com.healthcareapp.remote.UserModel;
import np.com.healthcareapp.retrofit.RetrofitService;
import np.com.healthcareapp.service.Booking;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class bookappo extends AppCompatActivity {

  private Button btn;
  EditText name,email,address;
  String doctorId, doctorName,doctorSpecialist, token , bearerToken, date, time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bookappo);




        token = TokenManager.getToken(getApplicationContext());
        bearerToken = "Bearer " + token;

        Intent loginIntent = new Intent(this, bottomnav.class);
        name = findViewById(R.id.etname);
      email = findViewById(R.id.etemail);
      address = findViewById(R.id.etaddress);
      btn = findViewById(R.id.btnsave);


        Intent intent = getIntent();
        doctorId= intent.getStringExtra("id");
        doctorName= intent.getStringExtra("name");
        doctorSpecialist= intent.getStringExtra("specialist");
        date = intent.getStringExtra("date");
        time = intent.getStringExtra("time");

        btn.setOnClickListener( v -> {
            String userName = name.getText().toString();
            String userEmail = email.getText().toString();
            String userAddress = address.getText().toString();

            Booking bookingService = RetrofitService.getService(bookappo.this).create(Booking.class);
            AppointmentModel appointmentModel = new AppointmentModel(bearerToken,null,userName,userEmail,userAddress,null, doctorId, null, null, null, date, time, null);
            Log.v("appointment", appointmentModel.getDate_appointment() + " " + appointmentModel.getDoctor_id());
            Call<AppointmentModel> call = bookingService.postAppointment(bearerToken, appointmentModel );

            call.enqueue(new Callback<AppointmentModel>() {
                @Override
                public void onResponse(Call<AppointmentModel> call, Response<AppointmentModel> response) {
                    if(response.isSuccessful()){
                        AppointmentModel responseAppointment = response.body();
                        if(responseAppointment != null && Objects.equals(responseAppointment.getError(), "this time slot is not available")){
                            Toast.makeText(bookappo.this, "Time slot already booked.", Toast.LENGTH_SHORT).show();
                        }else{
                            String id = responseAppointment.getId();
                            if(id != null){
                                startActivity(loginIntent);
                                Toast.makeText(bookappo.this,"successfully booked",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(bookappo.this, "Something is off", Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<AppointmentModel> call, Throwable throwable) {
                    Log.v("appointment", throwable.getMessage());
                    Toast.makeText(bookappo.this, "Failure unsuccess", Toast.LENGTH_SHORT).show();
                }
            });


        });




    }
}