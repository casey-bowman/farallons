package io.farallons.util.queue

abstract class AbstractQueue<Item> : Queue<Item> {

    protected abstract fun front() : Item?

    protected abstract fun size() : Int

    protected abstract fun empty(): Boolean

    override val front: Item?
        get() = front()

    override val size: Int
        get() = size()

    override val empty : Boolean
        get() = empty()

}