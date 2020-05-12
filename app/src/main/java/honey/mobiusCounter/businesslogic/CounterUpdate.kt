package honey.mobiusCounter.businesslogic

import com.spotify.mobius.Next
import com.spotify.mobius.Update
import honey.mobiusCounter.CounterEvent
import honey.mobiusCounter.model.CounterModel

class CounterUpdate :
    Update<CounterModel, CounterEvent, Nothing> { // nothing for effect as we don't have any
    override fun update(model: CounterModel, event: CounterEvent): Next<CounterModel, Nothing> {
        return Next.next(model.increment())
    }
}