package np.com.healthcareapp;


import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import np.com.healthcareapp.adapter.ambulancelistadapter;
import np.com.healthcareapp.adapter.ambulancelistadapter;
import np.com.healthcareapp.model.doctor;


public class ambulancelist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ambulancelist);

        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Suggested Ambulance");

        List<doctor> ambulanceListMain = new ArrayList<>();
        ambulanceListMain.add(new doctor("Bharatpur -2, 44203","","","","","Chitwan and nearby","9805198123",""));
        ambulanceListMain.add(new doctor("Bharatpur -2, 44203","","","","","Chitwan and nearby","9805198123",""));
        ambulanceListMain.add(new doctor("Bharatpur -2, 44203","","","","","Chitwan and nearby","9805198123",""));
        ambulanceListMain.add(new doctor("Bharatpur -2, 44203","","","","","Chitwan and nearby","9805198123",""));
        ambulanceListMain.add(new doctor("Bharatpur -2, 44203","","","","","Chitwan and nearby","9805198123",""));
        ambulanceListMain.add(new doctor("Bharatpur -2, 44203","","","","","Chitwan and nearby","9805198123",""));
        ambulanceListMain.add(new doctor("Bharatpur -2, 44203","","","","","Chitwan and nearby","9805198123",""));


        RecyclerView rvList = findViewById(R.id.rvAmbulance);
        ambulancelistadapter adapter = new ambulancelistadapter(ambulanceListMain);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);

    }
}