package id.sch.smktelkom_mlg.afinal.xirpl1253437.tabunganku;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Detail1 tab1 = new Detail1();
                return tab1;
            case 1:
                Detail2 tab2 = new Detail2();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
