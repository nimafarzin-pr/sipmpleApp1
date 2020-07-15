package com.poolavarone.book2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.duolingo.open.rtlviewpager.RtlViewPager;
import com.google.android.material.tabs.TabLayout;
import com.poolavarone.book2.Adapter.HomeAdapter;

public class HomeFragment extends Fragment {
    View view;
    TabLayout tabLayout;
    RtlViewPager rtlViewPager;
    HomeAdapter homeAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     view= inflater.inflate(R.layout.home_fragment,container,false);

     stupViews();
      return view;
     }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void stupViews(){
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout_home);
        rtlViewPager = (RtlViewPager) view.findViewById(R.id.view_pager_id);
        //homeAdapter = new HomeAdapter(getFragmentManager());if we in activity we most use getfragmentsupportmanager
        homeAdapter = new HomeAdapter(getChildFragmentManager()); //because we in the fragment we use getchildfragment
        homeAdapter.addFragment(new Darofragment(),"دارو");
        homeAdapter.addFragment(new DamnoshFragment(),"دمنوش");
        homeAdapter.addFragment(new MiveFragment(), " میوه");
        homeAdapter.addFragment(new TebbFragment(), " طب سنتی");
        rtlViewPager.setAdapter(homeAdapter);
        tabLayout.setupWithViewPager(rtlViewPager);

    }
}
