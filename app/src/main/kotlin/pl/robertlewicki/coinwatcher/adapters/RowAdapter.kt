package pl.robertlewicki.coinwatcher.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import pl.robertlewicki.coinwatcher.models.Coin

import pl.robertlewicki.coinwatcher.R

import kotlinx.android.synthetic.main.adapter_row.view.*

class RowAdapter constructor(private var data:MutableList<Coin>, context: Context): BaseAdapter() {

    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return data.count()
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getItem(i: Int): Any {
        return data[i]
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View? {
        var newView = view
        if(newView != null) {
            newView = layoutInflater.inflate(R.layout.adapter_row, viewGroup, false)
        }

        newView?.coinName?.text = data[i].currencyName
        newView?.coinDollarValue?.text = data[i].priceUsd
        newView?.coinPercentChange?.text = data[i].dailyPercentChange.toString()

        return newView
    }
}