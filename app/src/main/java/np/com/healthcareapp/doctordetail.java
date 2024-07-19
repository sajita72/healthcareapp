package np.com.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;



public class doctordetail extends AppCompatActivity {

    TextView textView,textView1,textView2,textView3;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctordetail);

            textView = findViewById(R.id.tvProductName);
            textView1 = findViewById(R.id.tvProductSpeciality);
            textView2= findViewById(R.id.tvProductDegree);
            textView3 = findViewById(R.id.tvdescription);


            Intent intent = getIntent();
            textView.setText(intent.getStringExtra("name"));
            textView1.setText(intent.getStringExtra("speciality"));
            textView2.setText(intent.getStringExtra("degree"));
            textView3.setText(intent.getStringExtra("description"));

        }
    }
