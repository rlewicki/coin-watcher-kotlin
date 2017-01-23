package pl.robertlewicki.coinwatcher.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import pl.robertlewicki.coinwatcher.models.Coin

import pl.robertlewicki.coinwatcher.R

class RowAdapter : BaseAdapter() {

    private var data: MutableList<Coin> = null!!
    private var layoutInflater: LayoutInflater? = null

    fun RowAdapter(data: MutableList<Coin>, context: Context) {
        this.data = data
        layoutInflater = LayoutInflater.from(context)
    }

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
            newView = layoutInflater?.inflate(R.layout.adapter_row, viewGroup, false)
        }
        val name = view?.findViewById(R.id.coinName)
        val value = view?.findViewById(R.id.coinDollarValue)
        val percentChange = view?.findViewById(R.id.coinPercentChange)



        return newView
    }

}