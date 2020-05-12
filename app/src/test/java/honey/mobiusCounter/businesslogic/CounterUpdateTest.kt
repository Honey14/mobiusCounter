package honey.mobiusCounter.businesslogic

import com.spotify.mobius.test.NextMatchers.hasModel
import com.spotify.mobius.test.NextMatchers.hasNoEffects
import com.spotify.mobius.test.UpdateSpec
import com.spotify.mobius.test.UpdateSpec.assertThatNext
import honey.mobiusCounter.CounterEvent
import honey.mobiusCounter.model.CounterModel
import org.junit.Test

class CounterUpdateTest {

    @Test
    fun `whenever increment button is clicked, then increment the value`() {
        val spec = UpdateSpec(CounterUpdate())
        val model = CounterModel.defaultValue()
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