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

        medicineListMain.add(new doctor("Parecetamotal Medicine","It contain the active substance acetylcysteine and has a  mucolytic      effect in the respiratory tract .","","",""," .vomiting   .nausea      .fever","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","It contain the active substance. ","","","",".runnynose.vomiting   .vomiting","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","It contain the active substance.","","","",".nausea     .fever .vomiting","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","It contain the active substance.","","","",".nausea      .fever .vomiting","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","It contain the active substance.","","","",".nausea    .fever .vomiting","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","It contain the active substance acetylcysteine and has a mucolytic effect in the respiratory tract.","","","",".nausea .fever .vomiting","",""));
        medicineListMain.add(new doctor("Parecetamotal Medicine","It contain the active substance acetylcysteine and has a mucolytic effect in the respiratory tract.","","","",".nausea .fever .vomiting","",""));


        RecyclerView rvList = findViewById(R.id.rvMedicines);
        medicinelistadapter adapter = new medicinelistadapter(this,medicineListMain);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);

    }
}