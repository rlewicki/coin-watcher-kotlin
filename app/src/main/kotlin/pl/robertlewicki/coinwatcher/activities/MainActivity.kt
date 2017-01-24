package pl.robertlewicki.coinwatcher.activities

import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import pl.robertlewicki.coinwatcher.R
import pl.robertlewicki.coinwatcher.adapters.SectionsPagerAdapter
import pl.robertlewicki.coinwatcher.interfaces.UpdateCoinDataInterface
import pl.robertlewicki.coinwatcher.models.Coin
import pl.robertlewicki.coinwatcher.utils.JsonParser

class MainActivity : AppCompatActivity(), UpdateCoinDataInterface {

    private val apiUrl = "https://api.coinmarketcap.com/v1/ticker/"
    private val apiUrlLimited = "https://api.coinmarketcap.com/v1/ticker/?limit=10"
    private val pagerAdapter = SectionsPagerAdapter(supportFragmentManager)

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
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id) {
            R.id.action_settings -> return true
            R.id.action_search -> return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun updateData(data: MutableList<Coin>) {
        pagerAdapter.refresh(data)
    }

    private fun refreshCoinsData() {
        val json = JsonParser(this)
        json.execute(apiUrl)
    }
}
