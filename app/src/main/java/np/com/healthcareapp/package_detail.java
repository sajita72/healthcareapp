package np.com.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class package_detail extends AppCompatActivity {

    TextView textView,textView1,textView2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_packagedetail);

        textView = findViewById(R.id.tvPackageName);
        textView1 = findViewById(R.id.description);
        textView2 = findViewById(R.id.speciality);
        button = findViewById(R.id.button2);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("name"));
        textView1.setText(intent.getStringExtra("description"));
        textView2.setText(intent.getStringExtra("specilaity"));

       // button.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Intent intent1 = new Intent(package_detail.this, bookappo.class);
          //      startActivity(intent1);
       //     }
     //   });

        }
    }



