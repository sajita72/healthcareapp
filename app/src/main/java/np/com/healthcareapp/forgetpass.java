package np.com.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import np.com.healthcareapp.remote.TokenManager;
import np.com.healthcareapp.remote.UserModel;
import np.com.healthcareapp.retrofit.RetrofitService;
import np.com.healthcareapp.service.ForgetPass;
import np.com.healthcareapp.service.Login;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class forgetpass extends AppCompatActivity {
    Button button;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forgetpass);





        button = findViewById(R.id.button2);
        email = findViewById(R.id.ettext);

        button.setOnClickListener(v ->{
            String userEmail = email.getText().toString();

            ForgetPass forgetPassService = RetrofitService.getService(forgetpass.this).create(ForgetPass.class);
          //  UserModel userModel = new UserModel(null,null, null, userEmail, null, null);
         //   Call<UserModel> call = forgetPassService.postLogin(userModel);




        //    call.enqueue(new Callback<UserModel>() {
              //  @Override
                //public void onResponse(Call<UserModel> call, Response<UserModel> response) {

                  //  if(response.isSuccessful()){
                //        Log.v("login","success");
                  //      UserModel responseUserModel = response.body();
                    //    String token = responseUserModel.getToken();
                      //  String success = responseUserModel.getSuccess();
                        //if(Objects.equals(success, "true")){
                          //  Log.v("login","true");
                         //   TokenManager.saveToken(getApplicationContext(),token);
                       // }

            //        }
              //  }

                //@Override
              //  public void onFailure(Call<UserModel> call, Throwable throwable) {

                //}
            //});


        });



    }
}