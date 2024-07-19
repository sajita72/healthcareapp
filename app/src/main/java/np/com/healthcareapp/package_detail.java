package np.com.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class package_detail extends AppCompatActivity {

    TextView textView,textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_packagedetail);

        textView = findViewById(R.id.tvPackageName);
        textView1 = findViewById(R.id.description);

        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("name"));
        textView1.setText(intent.getStringExtra("description"));

        }
    }



