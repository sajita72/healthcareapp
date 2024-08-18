package np.com.healthcareapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import np.com.healthcareapp.adapter.articlelistadapter;

import np.com.healthcareapp.model.doctor;

public class articlelist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_articlelist);

        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Recent Articles");

        List<doctor> articleListMain = new ArrayList<>();

        articleListMain.add(new doctor("Stress and Mental health", "Stress is a feeling of tension or pressures","","","","","",""));
        articleListMain.add(new doctor("Stress and Mental health", "Stress is a feeling of tension or pressures","","","","","",""));
        articleListMain.add(new doctor("Stress and Mental health", "Stress is a feeling of tension or pressures","","","","","",""));
        articleListMain.add(new doctor("Stress and Mental health", "Stress is a feeling of tension or pressures","","","","","",""));
        articleListMain.add(new doctor("Stress and Mental health", "Stress is a feeling of tension or pressures","","","","","",""));
        articleListMain.add(new doctor("Stress and Mental health", "Stress is a feeling of tension or pressures","","","","","",""));


        RecyclerView rvList = findViewById(R.id.rvarticle);

        articlelistadapter adapter = new articlelistadapter(articleListMain);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);


    }
}