package np.com.healthcareapp;


import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import np.com.healthcareapp.adapter.cliniclistadapter;
import np.com.healthcareapp.model.doctor;


public class cliniclist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cliniclist);

        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Suggested Clinic");

        List<doctor> clinicListMain = new ArrayList<>();
        clinicListMain.add(new doctor("Miteri polyclinic","","","","","Bharatpur, 44207", "9855018411"));
        clinicListMain.add(new doctor("Miteri polyclinic","","","","","Bharatpur, 44207", "9855018411"));
        clinicListMain.add(new doctor("Miteri polyclinic","","","","","Bharatpur, 44207", "9855018411"));
        clinicListMain.add(new doctor("Miteri polyclinic","","","","","Bharatpur, 44207", "9855018411"));
        clinicListMain.add(new doctor("Miteri polyclinic","","","","","Bharatpur, 44207", "9855018411"));
        clinicListMain.add(new doctor("Miteri polyclinic","","","","","Bharatpur, 44207", "9855018411"));
        clinicListMain.add(new doctor("Miteri polyclinic","","","","","Bharatpur, 44207", "9855018411"));
        clinicListMain.add(new doctor("Miteri polyclinic","","","","","Bharatpur, 44207", "9855018411"));


        RecyclerView rvList = findViewById(R.id.rvClinic);
        cliniclistadapter adapter = new cliniclistadapter(clinicListMain);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);

    }
}