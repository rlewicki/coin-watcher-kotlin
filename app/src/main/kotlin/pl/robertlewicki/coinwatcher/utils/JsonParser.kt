package pl.robertlewicki.coinwatcher.utils

import android.os.AsyncTask
import com.fasterxml.jackson.databind.ObjectMapper
import cz.msebera.android.httpclient.client.methods.HttpGet
import cz.msebera.android.httpclient.impl.client.HttpClients
import pl.robertlewicki.coinwatcher.interfaces.UpdateCoinDataInterface
import pl.robertlewicki.coinwatcher.models.Coin

class JsonParser : AsyncTask<String, Void, String>() {

    var delegate: UpdateCoinDataInterface? = null

    private val coins: MutableList<Coin> = mutableListOf()

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg urls: String): String {
        // Use this for progress bar in future if ever needed
        // publishProgress(Progress... values) is used to invoke onProgressUpdate()
        val httpClient = HttpClients.createDefault()
        val httpGetRequest = HttpGet(urls[0])
        val httpResponse = httpClient.execute(httpGetRequest)
        val httpEntity = httpResponse.entity
        return httpEntity.content.bufferedReader().use {it.readText()}
    }

    override fun onProgressUpdate(vararg progress: Void) {

    }

    override fun onPostExecute(result: String) {
        val mapper = ObjectMapper()
        val root = mapper.readTree(result)
        root.mapTo(coins) { mapper.readValue(it.toString(), Coin::class.java) }
        delegate?.UpdateData(coins)
    }
}