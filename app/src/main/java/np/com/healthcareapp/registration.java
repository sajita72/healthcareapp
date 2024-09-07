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

import java.util.Objects;

import np.com.healthcareapp.remote.TokenManager;
import np.com.healthcareapp.remote.UserModel;
import np.com.healthcareapp.retrofit.RetrofitService;
import np.com.healthcareapp.service.Register;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class registration extends AppCompatActivity {
    TextView login;
    EditText name, email, password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);


        String token = TokenManager.getToken(getApplicationContext());



       //  if (token != null) {
      //  Intent tokenIntent = new Intent(this, login.class);
       //   startActivity(tokenIntent);
      //}


        login = findViewById(R.id.tvlogin);
        Intent intent = new Intent(registration.this, login.class);
        login.setOnClickListener(v -> startActivity(intent));



        name = findViewById(R.id.user);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        btn = findViewById(R.id.btnregister);

        btn.setOnClickListener(v -> {

            String userName = name.getText().toString();
            String userEmail = email.getText().toString();
            String userPassword = password.getText().toString();

            Register registerservice = RetrofitService.getService(registration.this).create(Register.class);
            UserModel userModel = new UserModel(null, null, userName, userEmail, userPassword, null,null);
            Call<UserModel> call = registerservice.postRegister(userModel);


            call.enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                    if (response.isSuccessful()) {
                        Log.v("registrationn","success");
                        UserModel responseUserModel = response.body();
                        String token = responseUserModel.getToken();
                        String success = responseUserModel.getSuccess();
                        if (Objects.equals(success, "true")) {
                            Log.v("registrationn","true");

                            Intent intent1 = new Intent(registration.this, bottomnav.class);
                            startActivity(intent1);
                            Toast.makeText(registration.this, "Successfully registered", Toast.LENGTH_SHORT).show();


                        }
                    }
                }


                @Override
                public void onFailure(Call<UserModel> call, Throwable throwable) {
                    Log.v("registrationn",throwable.getMessage().toString());
                }

            });

        });
    }
}



