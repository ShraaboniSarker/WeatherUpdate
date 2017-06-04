package com.example.mobileappdevelop.json.FragementPageAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mobileappdevelop.json.Fragments.FragmentCurrentWeather;
import com.example.mobileappdevelop.json.Fragments.FragmentForeCase;

/**
 * Created by r3l0ad3d on 4/18/17.
 */

public class PageAdapter extends FragmentPagerAdapter {
    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentCurrentWeather();
            case 1:
                return new FragmentForeCase();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Current Weather";
            case 1:
                return "Forecast";
        }
        return super.getPageTitle(position);
    }
}
