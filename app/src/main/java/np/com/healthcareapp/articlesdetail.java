package np.com.healthcareapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class articlesdetail extends AppCompatActivity {
    TextView textView,textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_articlesdetail);


        textView = findViewById(R.id.tvArticleName);
        textView1 = findViewById(R.id.tvArticleSpeciality);


        Intent intent = getIntent();

        textView.setText(intent.getStringExtra("name"));
        textView1.setText(intent.getStringExtra("speciality"));


        }
    }
