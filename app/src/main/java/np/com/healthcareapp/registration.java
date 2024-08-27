package np.com.healthcareapp;


import android.content.Intent;
import android.os.Bundle;
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



public class registration extends AppCompatActivity implements View.OnClickListener {
    TextView login;
    EditText name, email, password;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);


        String token = TokenManager.getToken(getApplicationContext());
       if(token != null){
           Toast.makeText(registration.this,"registration success",Toast.LENGTH_SHORT);
       }
          //  Intent tokenIntent = new Intent(this, np.com.healthcareapp.login.class);
           // startActivity(tokenIntent);




        name = findViewById(R.id.user);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.tvlogin);
        btn = findViewById(R.id.btnregister);

        login.setOnClickListener(this);
        btn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {


        int id = v.getId();

        if (id == R.id.btnregister) {
            registerUser();
        } else {
            if (id == R.id.tvlogin) {
                switchOnLogin();
            }
        }

    }

    private void registerUser() {

        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        Register registerservice = RetrofitService.getService(registration.this).create(Register.class);
        UserModel userModel = new UserModel(null, null, userName, userEmail, userPassword);
        Call<UserModel> call = registerservice.postRegister(userModel);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                if(response.isSuccessful()){
                    UserModel responseUserModel = response.body();
                    String token = responseUserModel.getToken();
                    String success = responseUserModel.getSuccess();
                    if(Objects.equals(success, "true")){
                        TokenManager.saveToken(getApplicationContext(),token);
                        Intent intent = new Intent(registration.this,login.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable throwable) {

            }
        });


    }

    private void switchOnLogin() {
        Intent i = new Intent(registration.this, login.class);
        startActivity(i);
    }


}
