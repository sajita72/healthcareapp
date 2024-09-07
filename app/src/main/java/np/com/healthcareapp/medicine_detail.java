package np.com.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class medicine_detail extends AppCompatActivity {
    TextView textView,textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.medicine_detail);


        textView = findViewById(R.id.tvPackageName);
        textView1 = findViewById(R.id.description);
        textView2 = findViewById(R.id.tvsideeffect);

//        Log.v("testtt",intent.getDataString());
//        textView.setText(intent.getStringExtra("name"));
//        textView1.setText(intent.getStringExtra("description"));
//        textView2.setText(intent.getStringExtra("price"));




        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("name"));
        textView1.setText(intent.getStringExtra("speciality"));
        textView2.setText(intent.getStringExtra("price"));


        }
    }
