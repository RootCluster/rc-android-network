package org.incoder.network;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import org.incoder.network.advance.IntegrateFragment;
import org.incoder.network.original.okhttp.OkhttpFragment;
import org.incoder.network.original.retrofit.RetrofitFragment;
import org.incoder.network.original.rxjava.RxJavaFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :Jerry xu
 * @date :2018-06-11 13:00
 */
public class MainActivity extends AppCompatActivity {

    private List<Fragment> mFragments;
    private ViewPager mViewPager;
    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_okhttp:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_retrofit:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_rxjava:
                    mViewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_integrate:
                    mViewPager.setCurrentItem(3);
                    return true;
                default:
                    mViewPager.setCurrentItem(0);
                    break;
            }
            return false;
        }
    };

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == 0) {
                navigation.setSelectedItemId(R.id.navigation_okhttp);
            } else if (position == 1) {
                navigation.setSelectedItemId(R.id.navigation_retrofit);
            } else if (position == 2) {
                navigation.setSelectedItemId(R.id.navigation_rxjava);
            } else {
                navigation.setSelectedItemId(R.id.navigation_integrate);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragments = new ArrayList<>();
        mFragments.add(new OkhttpFragment());
        mFragments.add(new RetrofitFragment());
        mFragments.add(new RxJavaFragment());
        mFragments.add(new IntegrateFragment());
        navigation = findViewById(R.id.navigation);
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), mFragments));
        mViewPager.setOffscreenPageLimit(mFragments.size());
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


}
