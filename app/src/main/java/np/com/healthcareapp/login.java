package np.com.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
            Intent tokenIntent = new Intent(this, homefragment.class);
            startActivity(tokenIntent);
        }




         text = findViewById(R.id.forgetpass);
        Intent textIntent = new Intent(this, forgetpass.class);
        Intent loginIntent = new Intent(this, homefragment.class);
        text.setOnClickListener(v -> startActivity(textIntent));


          email = findViewById(R.id.user);
          password = findViewById(R.id.password);
          btn = findViewById(R.id.btnlogin);



btn.setOnClickListener( v -> {
    String userEmail = email.getText().toString();
    String userPassword = password.getText().toString();

    Login loginService = RetrofitService.getService(login.this).create(Login.class);
    UserModel userModel = new UserModel(null, null, null, userEmail, userPassword);
    Call<UserModel> call = loginService.postLogin(userModel);

    call.enqueue(new Callback<UserModel>() {
        @Override
        public void onResponse(Call<UserModel> call, Response<UserModel> response) {

            if(response.isSuccessful()){
                UserModel responseUserModel = response.body();
                String token = responseUserModel.getToken();
                String success = responseUserModel.getSuccess();
                if(Objects.equals(success, "true")){
                    TokenManager.saveToken(getApplicationContext(),token);
                    Intent intent = new Intent(login.this,homefragment.class);
                    startActivity(intent);
                }
            }
        }

        @Override
        public void onFailure(Call<UserModel> call, Throwable throwable) {

        }
    });


} );
















//
        btn= findViewById(R.id.btnlogin);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(login.this, bottomnav.class);
        startActivity(intent);
    }
});



        text= findViewById(R.id.registerhere);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, registration.class);
                startActivity(intent);
            }
        });



        text= findViewById(R.id.forgetpass);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent intent = new Intent(login.this, forgetpass.class);
           startActivity(intent);
            }
        });


      //  etemail = findViewById(R.id.user);
        //  etpassword = findViewById(R.id.password);
        //  button = findViewById(R.id.button2);
        // homeIntent = new Intent(this, bottomnav.class);

        // button.setOnClickListener(new View.OnClickListener() {
        //  @Override
        //  public void onClick(View v) {
        //   stemail = etemail.getText().toString();
        //   stPassword = etpassword.getText().toString();

        //  ocemservice ocem = RetrofitService.getService(login.this).create(ocemservice.class);
           //     apiutils utils = new apiutils(null,null,stemail,stPassword);

             //   Call<apiutils> call = ocem.postLogin(utils);

               // call.enqueue(new Callback<apiutils>() {
                 //   @Override
                   // public void onResponse(Call<apiutils> call, Response<apiutils> response) {

                   // }
                    //@Override
                    //public void onFailure(Call<apiutils> call, Throwable throwable) {

                    //}
                //});
            //}
        //});






    }
}