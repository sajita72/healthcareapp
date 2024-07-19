package np.com.healthcareapp.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import np.com.healthcareapp.R;
import np.com.healthcareapp.ambulancelist;
import np.com.healthcareapp.articlelist;
import np.com.healthcareapp.cliniclist;
import np.com.healthcareapp.labtest;
import np.com.healthcareapp.medicinelist;
import np.com.healthcareapp.productlist;


public class homefragment extends Fragment {


    Activity context;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;

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


        TextView textView1 =(TextView) context.findViewById(R.id.tvdoctors);
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
                Intent intent = new Intent(context, medicinelist.class);
                startActivity(intent);
            }
        });

        TextView textView3 = (TextView) context.findViewById(R.id.tvambulance);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ambulancelist.class);
                startActivity(intent);
            }
        });

        TextView textView4 = (TextView) context.findViewById(R.id.tvclinic);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, cliniclist.class);
                startActivity(intent);
            }
        });
        TextView textView5 = (TextView) context.findViewById(R.id.tvarticle);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, articlelist.class);
                startActivity(intent);
            }
        });
    }

}