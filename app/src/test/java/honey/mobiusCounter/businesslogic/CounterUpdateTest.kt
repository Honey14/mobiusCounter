package honey.mobiusCounter.businesslogic

import com.spotify.mobius.test.NextMatchers.*
import com.spotify.mobius.test.UpdateSpec
import com.spotify.mobius.test.UpdateSpec.assertThatNext
import honey.mobiusCounter.CounterEvent
import honey.mobiusCounter.model.CounterModel
import org.junit.Test

class CounterUpdateTest {
    private val spec = UpdateSpec(CounterUpdate())
    private val model = CounterModel.defaultValue()

    @Test
    fun `whenever increment button is clicked, then increment the value`() {
        spec
            .given(model)
            .whenEvent(CounterEvent.Increment)
            .then(
                assertThatNext(
                    hasModel(model.increment()),
                    hasNoEffects()
                )
            )
    }

    @Test
    fun `whenever decrement button is clicked, then decrement the value`() {
        spec
            .given(model)
            .whenEvent(CounterEvent.Decrement)
            .then(
                assertThatNext(
                    hasModel(model.decrement()),
                    hasNoEffects()
                )
            )
    }
    
    @Test
    fun `do nothing, when the incremented value reaches ten`() {
        // when given number is 0 and event occurred is increment, then do nothing
        spec
            .given(model)
            .whenEvent(CounterEvent.Increment)
            .then(
                assertThatNext(
                    hasModel(model.increment()),
                    hasNoEffects()
                )
            )
    }
}