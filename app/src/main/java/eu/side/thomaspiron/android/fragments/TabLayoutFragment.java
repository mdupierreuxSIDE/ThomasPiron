package eu.side.thomaspiron.android.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eu.side.thomaspiron.android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabLayoutFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public TabLayoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab_layout, container, false);
        initToolbar(rootView);
        setupTabLayout(rootView);
        return rootView;
    }

    private void initToolbar(View v) {
        final ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
        }

    }

    private void setupTabLayout(View v){
        tabLayout = (TabLayout) v.findViewById(R.id.sliding_tabs);
        viewPager = (ViewPager) v.findViewById(R.id.pager);

        viewPager.setAdapter(new SectionPagerAdapter(getActivity().getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CardRecyclerFragment();
                case 1:
                default:
                    return new CardRecyclerFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "MAISONS";
                case 1:
                default:
                    return "TERRAINS";
            }
        }
    }


}
