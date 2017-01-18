package pl.robertlewicki.coinwatcher.activities

import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import pl.robertlewicki.coinwatcher.R
import pl.robertlewicki.coinwatcher.adapters.SectionsPagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(container)
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
}
