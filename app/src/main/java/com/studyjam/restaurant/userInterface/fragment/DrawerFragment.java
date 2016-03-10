package com.studyjam.restaurant.userInterface.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.studyjam.restaurant.R;
import com.studyjam.restaurant.appModel.NavigationItem;
import com.studyjam.restaurant.userInterface.adapter.NavRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nyan Lin Tun
 */
public class DrawerFragment extends Fragment{
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private RecyclerView drawerRecycler;
    NavRecyclerAdapter navAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.drawer_list_layout,container,false);
        drawerRecycler = (RecyclerView) v.findViewById(R.id.drawer_list);
        navAdapter = new NavRecyclerAdapter(getActivity(),getData());
        drawerRecycler.setAdapter(navAdapter);
        drawerRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    public List<NavigationItem> getData(){
        List<NavigationItem> navList = new ArrayList<>();

        int[] iconId = {R.drawable.restaurant, R.drawable.restaurant, R.drawable.restaurant};
        String[] text = {"Shar Joon Pyan","KFC","Lotteria"};
        //TODO to ask iconid.length value
        for (int i = 0 ; i < iconId.length; i++){
            NavigationItem item = new NavigationItem();
            item.setIconId(iconId[i]);
            item.setText(text[i]);
            navList.add(item);
        }

        return navList;
    }
    //adding the navigation icon to the toolbar
    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar){
        mDrawerLayout = drawerLayout;
        //TODO why adding id in integer
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView){ super.onDrawerOpened(drawerView);}
            @Override
            public void onDrawerClosed(View drawerView){ super.onDrawerClosed(drawerView);}

        };
        //TODO why not support
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }
}