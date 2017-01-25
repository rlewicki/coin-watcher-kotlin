package pl.robertlewicki.coinwatcher.activities

import android.app.ListActivity
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import pl.robertlewicki.coinwatcher.R

class SearchableActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("debug", "Searchable activity starts")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search)
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        setIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent?) {
        if(Intent.ACTION_SEARCH == intent?.action) {
            val query = intent?.getStringExtra(SearchManager.QUERY)
            performSearch(query)
        }
    }

    private fun performSearch(query: String?) {
        Log.d("debug", query)
    }
}