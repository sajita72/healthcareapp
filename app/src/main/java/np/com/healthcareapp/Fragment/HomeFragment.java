package np.com.healthcareapp.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import np.com.healthcareapp.medicine;
import np.com.healthcareapp.productlist;
import np.com.healthcareapp.R;
import np.com.healthcareapp.labtest;


public class HomeFragment extends Fragment {

    Activity context;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();
        return inflater.inflate(R.layout.fragment_home, container, false);

    }
    public void onStart(){
        super.onStart();


        TextView textView = (TextView) context.findViewById(R.id.lab1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, labtest.class);
                startActivity(intent);
            }
        });


        TextView textView1 = (TextView) context.findViewById(R.id.tvdoctors);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, productlist.class);
                startActivity(intent);
            }
        });

        TextView textView2 = (TextView) context.findViewById(R.id.tvmedicine);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, medicine.class);
                startActivity(intent);
            }
        });
    }

}