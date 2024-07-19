package np.com.healthcareapp;


import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import np.com.healthcareapp.adapter.medicinelistadapter;
import np.com.healthcareapp.model.doctor;


public class medicinelist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_medicinelist);

        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Medicine List");



        List<doctor> medicineListMain = new ArrayList<>();

        medicineListMain.add(new doctor("Parecetamotal Medicine","","","","","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","","","","","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","","","","","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","","","","","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","","","","","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","","","","","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","","","","","",""));


        RecyclerView rvList = findViewById(R.id.rvMedicines);
        medicinelistadapter adapter = new medicinelistadapter(medicineListMain);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);

    }
}