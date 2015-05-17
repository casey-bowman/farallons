package io.farallons.util.queue

import io.farallons.util.node.ListNode

private class ListQueue<Item> : AbstractQueue<Item>() {

    private var backNode : ListNode<Item>? = null
    private var frontNode : ListNode<Item>? = null

    private var listSize : Int = 0

    override fun front(): Item? = frontNode?.item

    override fun size(): Int = listSize

    override fun empty(): Boolean = (frontNode == null)

    override fun enqueue(item: Item): Queue<Item> {
        val newBackNode = ListNode(item, null)
        if (backNode != null) {
            backNode!!.next = newBackNode
        }
        backNode = newBackNode
        listSize++
        if(frontNode==null) {
            frontNode = backNode
        }
        return this
    }

    override fun dequeue(): Queue<Item> {
        val newFrontNode = frontNode?.next
        frontNode?.item = null
        frontNode = newFrontNode
        listSize--
        return this
    }

    override fun iterator(): Iterator<Item> {
        return ListQueueIterator(frontNode)
    }

    private inner class ListQueueIterator<Item>(var frontNode : ListNode<Item>? ) : Iterator<Item> {

        override
        fun next(): Item {
            if (frontNode != null) {
                val item = frontNode!!.item
                frontNode = frontNode!!.next
                return item
            }
            else throw IllegalArgumentException("Iterator.next() may not be called if there is no next; use hasNext() to check first")
        }

        override
        fun hasNext(): Boolean {
            return (frontNode != null)
        }

    }

}
