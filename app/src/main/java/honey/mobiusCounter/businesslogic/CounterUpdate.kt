package honey.mobiusCounter.businesslogic

import com.spotify.mobius.Next
import com.spotify.mobius.Next.noChange
import com.spotify.mobius.Update
import honey.mobiusCounter.CounterEvent
import honey.mobiusCounter.model.CounterModel

class CounterUpdate :
    Update<CounterModel, CounterEvent, Nothing> { // nothing for effect as we don't have any
    override fun update(model: CounterModel, event: CounterEvent): Next<CounterModel, Nothing> {
        return when (event) {
            CounterEvent.Increment -> incrementTilTen(model)
            CounterEvent.Decrement -> Next.next(model.decrement())
        }
    }

    private fun incrementTilTen(model: CounterModel): Next<CounterModel, Nothing> {
        val incrementedModel = model.increment()
        return if (incrementedModel.startValue <= 10) {
            Next.next(model.increment())
        } else {
            noChange()
        }
    }


}