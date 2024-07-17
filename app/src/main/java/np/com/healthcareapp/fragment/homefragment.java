package np.com.healthcareapp.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import np.com.healthcareapp.R;
import np.com.healthcareapp.labtest;
import np.com.healthcareapp.medicine;
import np.com.healthcareapp.productlist;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homefragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homefragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homefragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static homefragment newInstance(String param1, String param2) {
        homefragment fragment = new homefragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
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


        TextView textView1 = context.findViewById(R.id.tvdoctors);
        textView1.setOnClickListener(v -> {
            Intent intent = new Intent(context, productlist.class);
            startActivity(intent);
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