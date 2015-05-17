package io.farallons.util.bag

abstract class AbstractBag<Item> : Bag<Item> {

    protected abstract fun size() : Int

    override val size: Int
        get() = size()
}
