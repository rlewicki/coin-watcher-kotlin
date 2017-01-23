package pl.robertlewicki.coinwatcher.models

import com.fasterxml.jackson.annotation.JsonProperty

class Coin {
    @JsonProperty("id")                 var id: String = ""
    @JsonProperty("name")               var currencyName: String = ""
    @JsonProperty("symbol")             var symbol: String = ""
    @JsonProperty("rank")               var rank: String = ""
    @JsonProperty("price_usd")          var priceUsd: String = ""
    @JsonProperty("price_btc")          var priceBtc: String = ""
    @JsonProperty("24h_volume_usd")     var dailyVolumeUsd: String = ""
    @JsonProperty("market_cap_usd")     var marketCapUsd: String = ""
    @JsonProperty("available_supply")   var availableSupply: String = ""
    @JsonProperty("total_supply")       var totalSupply: String = ""
    @JsonProperty("percent_change_1h")  var hourlyPercentChange: Float = 0.toFloat()
    @JsonProperty("percent_change_24h") var dailyPercentChange: Float = 0.toFloat()
    @JsonProperty("percent_change_7d")  var weeklyPercentChange: String = ""
    @JsonProperty("last_updated")       var lastUpdated: String = ""
}
