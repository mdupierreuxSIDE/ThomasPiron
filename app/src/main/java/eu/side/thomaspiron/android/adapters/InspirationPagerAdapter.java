package eu.side.thomaspiron.android.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import eu.side.thomaspiron.android.fragments.InspirationFragment;

/**
 * Created by mdupierreux1 on 18/08/15.
 */
public class InspirationPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 5;
    private String tabTitles[] = new String[] {
            "De 150K à 200K €"
            , "De 200K à 250K €"
            , "De 250K à 300K €"
            , "De 300K à 350K €"
            , "Plus de 350K €"};
    private Context context;

    public InspirationPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return InspirationFragment.newInstance("150000","200000",1);
            case 1:
                return InspirationFragment.newInstance("200001","250000",2);
            case 2:
                return InspirationFragment.newInstance("250001","300000",3);
            case 3:
                return InspirationFragment.newInstance("300001","350000",4);
            case 4:
                return InspirationFragment.newInstance("350001","10000000",5);
            case 5:
                return InspirationFragment.newInstance("400000","10000000",6);
        }
        return InspirationFragment.newInstance("0","0",0);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}