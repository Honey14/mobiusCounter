package honey.mobiusCounter.model


data class CounterModel(val startValue: Int) {


    companion object {
        fun defaultValue() = CounterModel(startValue = 0)
    }

    fun increment() = copy(startValue = startValue + 1)
}