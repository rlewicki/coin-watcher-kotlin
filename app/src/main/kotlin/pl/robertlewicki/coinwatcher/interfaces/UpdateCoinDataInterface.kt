package pl.robertlewicki.coinwatcher.interfaces

import pl.robertlewicki.coinwatcher.models.Coin

interface UpdateCoinDataInterface {
    fun UpdateData(data: MutableList<Coin>)
}