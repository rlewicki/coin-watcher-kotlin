package pl.robertlewicki.coinwatcher.interfaces

import pl.robertlewicki.coinwatcher.models.Coin

interface UpdateCoinDataInterface {
    fun updateData(data: MutableList<Coin>)
}