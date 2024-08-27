package np.com.healthcareapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import np.com.healthcareapp.fragment.cancellfragment;
import np.com.healthcareapp.fragment.completedfragment;
import np.com.healthcareapp.fragment.upcommingfragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    //public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
       // super(fragmentActivity);
  //  }

    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        switch (position) {
            case 0:
                return new upcommingfragment();
            case 1:
                return new completedfragment();
            case 2:
                return new cancellfragment();

            default:
                return new upcommingfragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
