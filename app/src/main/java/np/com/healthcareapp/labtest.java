package np.com.healthcareapp;


import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import np.com.healthcareapp.adapter.packagelistadapter;
import np.com.healthcareapp.model.doctor;


public class labtest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_labtest);

        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Package List");



        List<doctor> packageListMain = new ArrayList<>();
        packageListMain.add(new doctor("Package1: Blood CheckUp","Rs 400","",""));
        packageListMain.add(new doctor("Package1: Blood CheckUp","Rs 400","",""));
        packageListMain.add(new doctor("Package1: Blood CheckUp","Rs 400","",""));
        packageListMain.add(new doctor("Package1: Blood CheckUp","Rs 400","",""));
        packageListMain.add(new doctor("Package1: Blood CheckUp","Rs 400","",""));
        packageListMain.add(new doctor("Package1: Blood CheckUp","Rs 400","",""));
        packageListMain.add(new doctor("Package1: Blood CheckUp","Rs 400","",""));
        packageListMain.add(new doctor("Package1: Blood CheckUp","Rs 400","",""));

        RecyclerView rvList = findViewById(R.id.rvPackages);
        packagelistadapter adapter = new packagelistadapter(packageListMain);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);

    }
}