package io.farallons.util.stack

abstract class AbstractStack<Item> : Stack<Item> {

    protected abstract fun top() : Item?

    protected abstract fun size() : Int

    protected abstract fun empty() : Boolean

    override val top: Item?
        get() = top()

    override val size: Int
        get() = size()

    override val empty: Boolean
        get() = empty()

}