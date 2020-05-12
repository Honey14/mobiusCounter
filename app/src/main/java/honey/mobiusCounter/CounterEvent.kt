package honey.mobiusCounter

sealed class CounterEvent {
    object Increment : CounterEvent()
    object Decrement : CounterEvent()
}