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

import np.com.healthcareapp.remote.TokenManager;
import np.com.healthcareapp.remote.UserModel;
import np.com.healthcareapp.retrofit.RetrofitService;
import np.com.healthcareapp.service.PostOTP;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class otp extends AppCompatActivity {

    EditText otp1, otp2, otp3, otp4;
    String stOTP1, stOTP2, stOTP3, stOTP4,stOTP, token, role;


    String email;
    protected Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp);


        Intent intent2 = new Intent(otp.this, bottomnav.class);


        otp1 = findViewById(R.id.etOTP1);
        otp2 = findViewById(R.id.etOTP2);
        otp3 = findViewById(R.id.etOTP3);
        otp4 = findViewById(R.id.etOTP4);


        button= findViewById(R.id.btnsend);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");



       //  PostOTP postOTP = RetrofitService.getService(otp.this).create(PostOTP.class);

 button.setOnClickListener(v ->{
     stOTP1 = otp1.getText().toString();
     stOTP2 = otp2.getText().toString();
     stOTP3 = otp3.getText().toString();
     stOTP4 = otp4.getText().toString();
     stOTP = stOTP1+stOTP2+stOTP3+stOTP4;


     PostOTP postOTP = RetrofitService.getService(otp.this).create(PostOTP.class);
    UserModel userModel = new UserModel(null,null,null,email,null,null,stOTP);

     Call<UserModel> call = postOTP.postOTP(userModel);
     call.enqueue(new Callback<UserModel>() {
         @Override
         public void onResponse(Call<UserModel> call, Response<UserModel> response) {



             if(response.isSuccessful()){
                 Log.v("otp","success");
                 UserModel responseUserModel = response.body();
                 String token = responseUserModel.getToken();
                 String success = responseUserModel.getSuccess();
                 if(token != null){
                     TokenManager.saveToken(getApplicationContext(),token);
                     startActivity(intent2);

                 }


             }
         }

         @Override
         public void onFailure(Call<UserModel> call, Throwable throwable) {

         }
     });



 });

    }
}
