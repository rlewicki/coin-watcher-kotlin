package pl.robertlewicki.coinwatcher.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import pl.robertlewicki.coinwatcher.fragments.CoinWatcherFragment
import pl.robertlewicki.coinwatcher.fragments.CoinSelectedFragment
import pl.robertlewicki.coinwatcher.models.Coin

class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var allCoinsFragment: CoinWatcherFragment? = null
    var selectedCoinsFragment: CoinSelectedFragment? = null

    fun refresh(data: MutableList<Coin>) {
        allCoinsFragment?.refreshView(data)
    }

    override fun getItem(position: Int): Fragment? {
        when(position) {
            0 -> {
                allCoinsFragment = CoinWatcherFragment()
                return allCoinsFragment
            }
            1 -> {
                selectedCoinsFragment = CoinSelectedFragment()
                return selectedCoinsFragment
            }
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