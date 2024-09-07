package np.com.healthcareapp;


import android.os.Bundle;


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





        List<doctor> packageListMain = new ArrayList<>();

        packageListMain.add(new doctor("Package1: Full body checkup","Package includes","","","Amphetamine Morphine Canabiniodes             Blood Tests ","","",""));
        packageListMain.add(new doctor("Package2: Thyroid checkup","Package includes","","","CBC Morphine Canabiniodes            Blood Tests","","",""));
        packageListMain.add(new doctor("Package3: Bone,Joint checkup","Package includes","","","Canabiniodes Morphine Amphetamine          Blood Tests","","",""));
        packageListMain.add(new doctor("Package4: Diabetes checkUp","Package includes","","","Amphetamine Calcium Canabiniodes            Blood Tests","","",""));
        packageListMain.add(new doctor("Package5: Women Health checkup","Package includes","","","Amphetamine Morphine Canabiniodes            Blood Tests","","",""));
        packageListMain.add(new doctor("Package6: Child Health checkup","Package includes","","","Amphetamine Morphine Canabiniodes           Cocaine  Blood Tests","","",""));
        packageListMain.add(new doctor("Package7: Blood CheckUp","Package includes","","","Amphetamine Morphine Canabiniodes           Cocaine  Blood Tests","","",""));
        packageListMain.add(new doctor("Package8: Blood CheckUp","Package includes","","","Amphetamine Morphine Canabiniodes           Cocaine  Blood Tests","","",""));






        RecyclerView rvList = findViewById(R.id.rvPackages);
        packagelistadapter adapter = new packagelistadapter(this,packageListMain);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);

    }
}