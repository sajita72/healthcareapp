package np.com.healthcareapp.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import np.com.healthcareapp.R;
import np.com.healthcareapp.doctordetail;
import np.com.healthcareapp.forgetpass;
import np.com.healthcareapp.labtest;
import np.com.healthcareapp.login;
import np.com.healthcareapp.medicinelist;
import np.com.healthcareapp.model.doctor;
import np.com.healthcareapp.productlist;
import np.com.healthcareapp.remote.TokenManager;


public class profilefragment extends Fragment {



    Activity context;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        return root;


    }


    public void onStart(){
        super.onStart();

        TextView textView = (TextView) context.findViewById(R.id.tvappo);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, productlist.class);
                startActivity(intent);
            }
        });


        TextView textVie5 = (TextView)context.findViewById(R.id.tvdoc);
        textVie5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, productlist.class);
                startActivity(i);
            }
        });


TextView textView1 = (TextView) context.findViewById(R.id.tvmed);
textView1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, medicinelist.class);
        startActivity(intent);
    }
});


        TextView textView2 = (TextView) context.findViewById(R.id.tvlog);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              TokenManager.clearToken(getContext());
                Toast.makeText(getContext(),"Logout Success",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, login.class);
                startActivity(intent);

            }
        });


    }


}