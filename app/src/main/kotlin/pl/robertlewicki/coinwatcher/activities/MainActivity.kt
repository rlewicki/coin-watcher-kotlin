package pl.robertlewicki.coinwatcher.activities

import android.app.SearchManager
import android.content.Context
import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.support.v7.widget.SearchView

import kotlinx.android.synthetic.main.activity_main.*
import pl.robertlewicki.coinwatcher.R
import pl.robertlewicki.coinwatcher.adapters.SectionsPagerAdapter
import pl.robertlewicki.coinwatcher.interfaces.UpdateCoinDataInterface
import pl.robertlewicki.coinwatcher.models.Coin
import pl.robertlewicki.coinwatcher.utils.JsonParser
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(), UpdateCoinDataInterface {

    private val apiUrl = "https://api.coinmarketcap.com/v1/ticker/"
    private val apiUrlLimited = "https://api.coinmarketcap.com/v1/ticker/?limit=250"
    private val pagerAdapter = SectionsPagerAdapter(supportFragmentManager)

    private var searchView : SearchView? = null
    private var coins : MutableList<Coin>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        container.adapter = pagerAdapter
        tabs.setupWithViewPager(container)
        refreshCoinsData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu.findItem(R.id.action_search)
        searchView = menuItem.actionView as SearchView
        searchView!!.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                queryCoins(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id) {
            R.id.action_settings -> return true
            R.id.action_search -> return true
            R.id.action_refresh -> refreshCoinsData()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun updateData(data: MutableList<Coin>) {
        coins = data
        pagerAdapter.refresh(data)
    }

    private fun refreshCoinsData() {
        Log.d("debug", "Refreshing coins data.")
        val json = JsonParser(this)
        json.execute(apiUrl)
    }

    private fun queryCoins(query: CharSequence) {
        val queriedCoins: MutableList<Coin> = coins!!
                .filter {
                    it.currencyName!!.contains(query, true)
                }
                .toMutableList()
        pagerAdapter.refresh(queriedCoins)
    }
}
