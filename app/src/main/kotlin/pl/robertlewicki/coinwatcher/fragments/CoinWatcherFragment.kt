package pl.robertlewicki.coinwatcher.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.robertlewicki.coinwatcher.R
import pl.robertlewicki.coinwatcher.models.Coin

import kotlinx.android.synthetic.main.fragment_coin_watcher.*
import pl.robertlewicki.coinwatcher.adapters.RowAdapter

class CoinWatcherFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_coin_watcher, container, false)
        return rootView
    }

    fun refreshView(data: MutableList<Coin>) {
        val rowAdapter = RowAdapter(data, context)
        allCoinList.adapter = rowAdapter
    }
}