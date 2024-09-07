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

import np.com.healthcareapp.fragment.homefragment;
import np.com.healthcareapp.remote.TokenManager;
import np.com.healthcareapp.remote.UserModel;
import np.com.healthcareapp.retrofit.RetrofitService;
import np.com.healthcareapp.service.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class login extends AppCompatActivity {

     Button btn;
    TextView text;
    EditText email, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        String token = TokenManager.getToken(getApplicationContext());
        if(token != null){
            Intent tokenIntent = new Intent(this, bottomnav.class);
            startActivity(tokenIntent);
        }



text = findViewById(R.id.registerhere);
        Intent intent = new Intent(this, registration.class);
text.setOnClickListener(v -> startActivity(intent));


        text = findViewById(R.id.forgetpass);
        Intent textIntent = new Intent(this, forgetpass.class);
        Intent loginIntent = new Intent(this, bottomnav.class);
        text.setOnClickListener(v -> startActivity(textIntent));


          email = findViewById(R.id.user);
          password = findViewById(R.id.password);
          btn = findViewById(R.id.btnlogin);


          btn.setOnClickListener( v -> {
    String userEmail = email.getText().toString();
    String userPassword = password.getText().toString();

    Login loginService = RetrofitService.getService(login.this).create(Login.class);
    UserModel userModel = new UserModel(null,null, null, userEmail, userPassword, null,null);
    Call<UserModel> call = loginService.postLogin(userModel);

    call.enqueue(new Callback<UserModel>() {
        @Override
        public void onResponse(Call<UserModel> call, Response<UserModel> response) {

            if(response.isSuccessful()){
                Log.v("login","success");
                UserModel responseUserModel = response.body();
                String token = responseUserModel.getToken();
                String success = responseUserModel.getSuccess();
               if(token != null){
                   TokenManager.saveToken(getApplicationContext(),token);
                   startActivity(loginIntent);
               }
               else{
                   Toast.makeText(login.this, "Invalid Credentials.", Toast.LENGTH_SHORT).show();
               }
            }else{
                Toast.makeText(login.this, "Invalid Credentials.", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<UserModel> call, Throwable throwable) {

        }
    });


} );


    }
}