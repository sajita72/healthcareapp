package np.com.healthcareapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import np.com.healthcareapp.fragment.appointmentfragment;
import np.com.healthcareapp.fragment.homefragment;
import np.com.healthcareapp.fragment.profilefragment;

public class bottomnav extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    homefragment homeFragment = new homefragment();
    appointmentfragment appointmentFragment = new appointmentfragment();
    profilefragment profileFragment = new profilefragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bottomnav);


        bottomNavigationView = findViewById(R.id.bottomnav);
        frameLayout = findViewById(R.id.container);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int itemID = menuItem.getItemId();

                if (itemID == R.id.home){
                    loadFragment(new homefragment(),false);

                } else if (itemID == R.id.appointment) {
                    loadFragment(new appointmentfragment(),false);

                }else {
                    loadFragment(new profilefragment(),false);
                }


                return true;
            }
        });
        loadFragment(new homefragment(),true);


    }

    private void loadFragment(Fragment fragment,boolean isAPPinitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAPPinitialized){
            fragmentTransaction.add(R.id.container, fragment);

        }else{
            fragmentTransaction.replace(R.id.container,fragment);
        }

        fragmentTransaction.commit();

    }

}