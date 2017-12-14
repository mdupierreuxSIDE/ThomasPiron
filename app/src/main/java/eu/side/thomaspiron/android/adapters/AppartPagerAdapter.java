package eu.side.thomaspiron.android.adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.activities.UnitListActivity;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.fragments.InspirationFragment;
import eu.side.thomaspiron.android.fragments.UnitListFragment;
import eu.side.thomaspiron.android.model.Lot;
/**
 * Created by mdupierreux1 on 25/08/15.
 */
public class AppartPagerAdapter extends FragmentPagerAdapter {

    private static final String LOG_TAG = AppartPagerAdapter.class.getSimpleName();
    private Boolean mIsMaison = false;
    private Context context;
    private String mEnseCode,mSociCode;
    private List<String> mListeEtage = new ArrayList<>();
    private Integer count=1;
    public AppartPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public AppartPagerAdapter(FragmentManager fm, Context context, String ense_code, String soci_code) {
        super(fm);
        this.context = context;
        mEnseCode = ense_code;
        mSociCode = soci_code;

    }

    public AppartPagerAdapter(FragmentManager fm, Context context, List<String> etages,String ensecode,String socicode,Boolean isMaison) {
        super(fm);
        this.context = context;
        this.mListeEtage = etages;
        this.mEnseCode = ensecode;
        this.mSociCode = socicode;
        this.mIsMaison = isMaison;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return UnitListFragment.newInstance("", mEnseCode, mSociCode, position,mIsMaison);
        }
        else {
            return UnitListFragment.newInstance(mListeEtage.get(position - 1), mEnseCode, mSociCode, position,mIsMaison);
        }
    }

    @Override
    public int getCount() {
        return mListeEtage.size()+1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        if(position == 0){
            return "Tous";
        }
        else {
            return mListeEtage.get(position - 1);
        }
    }


}
