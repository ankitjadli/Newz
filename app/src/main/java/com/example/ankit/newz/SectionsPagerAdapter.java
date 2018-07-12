package com.example.ankit.newz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class SectionsPagerAdapter extends FragmentPagerAdapter {
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {

            case 1:
                Delhi Delhifragment = new Delhi();
                return Delhifragment ;
            case 0:
                Ghaziabad Ghaziabadfragment = new Ghaziabad();
                return Ghaziabadfragment;
            case 2:
                Hindi HindiFragment = new Hindi();
                return HindiFragment;

                default:
                    return null;


        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){

        switch (position)
        {
            case 0:
                return "delhi";

            case 1:
                return  "ghaziabad";

            case 2:
                return "hindi";

                default:
                    return null;

        }


    }
}
