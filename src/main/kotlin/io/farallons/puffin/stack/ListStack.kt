package io.farallons.puffin.stack

import io.farallons.puffin.node.ListNode

internal class ListStack<Item>() : AbstractStack<Item>() {

    private var node : ListNode<Item>? = null

    private var listSize : Int = 0

    override
    fun empty(): Boolean {
        return node == null
    }

    override
    fun top(): Item? {
        return node?.item
    }

    override
    fun pop(): Stack<Item> {
        node = node?.next
        if (listSize > 0) listSize--
        return this
    }

    override
    fun push(item: Item): Stack<Item> {
        this.node = ListNode(item, this.node)
        listSize++
        return this
    }

    override
    fun size(): Int = listSize

    override fun iterator(): Iterator<Item> {
        return ListStackIterator(node)
    }

    private inner class ListStackIterator<Item>(var nextNode : ListNode<Item>? ) : Iterator<Item> {

        override
        fun next(): Item {
            if (nextNode != null) {
                val item = nextNode!!.item
                nextNode = nextNode!!.next
                return item
            }
            else throw IllegalArgumentException("Iterator.next() may not be called if there is no next; use hasNext() to check first")
        }

        override
        fun hasNext(): Boolean {
            return (nextNode != null)
        }

    }
}
