package com.studyjam.restaurant.userInterface.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.studyjam.restaurant.R;
import com.studyjam.restaurant.userInterface.adapter.TabFragmentAdapter;
import com.studyjam.restaurant.userInterface.fragment.DrawerFragment;

public class MainActivity extends AppCompatActivity {
  private TabFragmentAdapter mTabFragmentAdapter;
  private ViewPager mViewPager;
  private DrawerLayout mDrawerLayout;
  private TabLayout mTabLayout;
  private Toolbar toolbar;
  DrawerFragment mDrawerFragment;
  ActionBarDrawerToggle mDrawerToogle;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setTitle("စားမယ် ဝါးမယ်");
    toolbar.setTitleTextColor(getResources().getColor(R.color.toolbarcolor));
    setSupportActionBar(toolbar);

    mDrawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
    mDrawerFragment.setUp((DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

    mTabLayout = (TabLayout) findViewById(R.id.tab_layout);

    //TODO ask about the work flow all the code below

    mTabFragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager());
    mViewPager = (ViewPager) findViewById(R.id.pager);
    mViewPager.setAdapter(mTabFragmentAdapter);
    mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

      @Override public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
      }

      @Override public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override public void onTabReselected(TabLayout.Tab tab) {

      }
    });

    mTabLayout.setupWithViewPager(mViewPager);
    mTabLayout.getTabAt(0).setText("Vall lr");
    mTabLayout.getTabAt(1).setText("Vall vl");
  }
}
