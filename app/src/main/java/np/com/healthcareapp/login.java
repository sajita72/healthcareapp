package np.com.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import np.com.healthcareapp.remote.RetrofitService;
import np.com.healthcareapp.remote.apiutils;
import np.com.healthcareapp.remote.ocemservice;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class login extends AppCompatActivity {

    protected Button button;
    TextView text;
    EditText etemail, etpassword;
    String stemail, stPassword;
    Intent homeIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);


button= findViewById(R.id.button2);
button.setOnClickListener(new View.OnClickListener() {
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