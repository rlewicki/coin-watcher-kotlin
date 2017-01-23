package pl.robertlewicki.coinwatcher.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import pl.robertlewicki.coinwatcher.fragments.CoinWatcherFragment
import pl.robertlewicki.coinwatcher.fragments.CoinSelectedFragment

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when(position) {
            0 -> return CoinWatcherFragment()
            1 -> return CoinSelectedFragment()
        }
        return null
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "all"
            1 -> return "selected"
        }
        return null
    }
}