package np.com.healthcareapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import np.com.healthcareapp.adapter.ProductListAdapter;
import np.com.healthcareapp.model.doctor;

public class productlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_list);

        TextView tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText("Suggested Doctors");

        List<doctor> productListMain = new ArrayList<>();
        productListMain.add(new doctor("Purnima Thapa", "Gynecologist, Internal Medicine","MBBS,MD",""));
        productListMain.add(new doctor("Shruti Kalwar", "Gynoelogist","MBBS","https://www.shutterstock.com/image-photo/medical-concept-indian-beautiful-female-260nw-1635029716.jpg"));
        productListMain.add(new doctor("Sajita Thapa", "Gynoelogist","MBBS",""));
        productListMain.add(new doctor("Nima Thapa", "Gynoelogist","MBBS",""));
        productListMain.add(new doctor("Purnima Thapa", "Gynecologist, Internal Medicine","MBBS,MD",""));
        productListMain.add(new doctor("Shruti Kalwar", "Gynoelogist","MBBS","https://www.shutterstock.com/image-photo/medical-concept-indian-beautiful-female-260nw-1635029716.jpg"));
        productListMain.add(new doctor("Sajita Thapa", "Gynoelogist","MBBS",""));
        productListMain.add(new doctor("Nima Thapa", "Gynoelogist","MBBS",""));

        RecyclerView rvList = findViewById(R.id.rvdoctors);

        ProductListAdapter adapter = new ProductListAdapter(productListMain);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setAdapter(adapter);


    }
}