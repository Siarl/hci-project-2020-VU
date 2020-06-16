package nl.vanrsmln.wilkin.hci2020.ui.repairs;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import nl.vanrsmln.wilkin.hci2020.R;

public class RepairSectionsPagerAdapter extends FragmentPagerAdapter {
    private static final String TAG = "RepairSectionsPagerAdap";

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_current_repairs, R.string.tab_your_repairs};
    private final Context mContext;

    public RepairSectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return RepairFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}