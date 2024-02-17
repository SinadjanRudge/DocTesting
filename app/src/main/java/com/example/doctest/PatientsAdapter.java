package com.example.doctest;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;

public class PatientsAdapter extends FragmentStateAdapter {


    public PatientsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new UpcomingFragment();
            case 1:
                return new PendingFragment();
            case 2:
                return new StatusFragment();
            default:
                return new UpcomingFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
