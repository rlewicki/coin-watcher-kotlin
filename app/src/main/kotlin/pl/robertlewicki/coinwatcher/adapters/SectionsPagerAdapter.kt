package pl.robertlewicki.coinwatcher.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import pl.robertlewicki.coinwatcher.fragments.CoinWatcher
import pl.robertlewicki.coinwatcher.fragments.CoinWatcherSelected

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when(position) {
            0 -> return CoinWatcher()
            1 -> return CoinWatcherSelected()
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