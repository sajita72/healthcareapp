package np.com.healthcareapp.fragment;


import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import np.com.healthcareapp.MyViewPagerAdapter;
import np.com.healthcareapp.R;


public class appointmentfragment extends Fragment {

    Activity context;
    TabLayout tabLayout;

    TabItem tabItem1,tabItem2,tabItem3;
    ViewPager2 viewPager2;
    MyViewPagerAdapter myViewPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        context = getActivity();
        View root = inflater.inflate(R.layout.fragment_appointment, container, false);

        return root;
    }

        public void onStart(){
            super.onStart();

            tabLayout = (TabLayout) context.findViewById(R.id.tabLayout);
            viewPager2 =(ViewPager2) context.findViewById(R.id.view_pager);
tabItem1 = (TabItem) context.findViewById(R.id.tab1);
            tabItem2 = (TabItem) context.findViewById(R.id.tab2);
            tabItem3 = (TabItem) context.findViewById(R.id.tab3);




 //myViewPagerAdapter = new MyViewPagerAdapter(this);
 //viewPager2.setAdapter(myViewPagerAdapter);





            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager2.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });


        }

    }

