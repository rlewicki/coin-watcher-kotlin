package pl.robertlewicki.coinwatcher.services

import android.os.AsyncTask
import cz.msebera.android.httpclient.client.methods.HttpGet
import cz.msebera.android.httpclient.impl.client.HttpClients

class JsonParser : AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg strings: String): String {
        return getJsonFromUrl(strings[0])
    }

    override fun onProgressUpdate(vararg progress: Void) {

    }

    override fun onPostExecute(result: String) {

    }

    private fun getJsonFromUrl(url: String): String {
        val httpClient = HttpClients.createDefault()
        val httpGetRequest = HttpGet(url)
        val httpResponse = httpClient.execute(httpGetRequest)
        val httpEntity = httpResponse.entity
        return ""
    }


}