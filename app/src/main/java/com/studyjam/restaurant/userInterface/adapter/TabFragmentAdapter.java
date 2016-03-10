package com.studyjam.restaurant.userInterface.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.studyjam.restaurant.userInterface.fragment.DrinkFragment;

/**
 * Created by Ethical on 3/9/16.
 */
public class TabFragmentAdapter extends FragmentStatePagerAdapter{

    public TabFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DrinkFragment ff = new DrinkFragment();
                return ff;
            case 1:
                DrinkFragment df = new DrinkFragment();
                return df;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
