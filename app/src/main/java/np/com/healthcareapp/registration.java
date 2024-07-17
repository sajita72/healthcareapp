package np.com.healthcareapp;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import np.com.healthcareapp.remote.apiutils;
import np.com.healthcareapp.remote.ocemservice;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class registration extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);

        text = findViewById(R.id.textView6);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(registration.this, login.class);
//                startActivity(intent);

                ocemservice service = apiutils.getocemservice();
                Call<ResponseBody> responseBodyCall = service.validateregistration("shruti", "shrut@gmail.com", "shruti@123");
                responseBodyCall.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse( Call<ResponseBody> call,  Response<ResponseBody> response) {
                        Log.v("RESPONSE_FROM_SERVER", response.raw().toString());
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseBody> call, Throwable throwable) {
                        Log.v("ERROR_FROM_SERVER", throwable.toString());
                    }
                });

            }
        });
    }



}