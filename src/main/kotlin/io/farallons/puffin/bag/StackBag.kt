package io.farallons.puffin.bag


import io.farallons.puffin.stack.Stack

internal class StackBag<Item>(val stack: Stack<Item>) : AbstractBag<Item>() {

    override fun add(item: Item): Bag<Item> {
        stack.push(item)
        return this
    }

    override fun size(): Int {
        return stack.size
    }

    override fun iterator(): Iterator<Item> {
        return stack.iterator()
    }

}
