package io.farallons.puffin.queue

public object QueueFactory {

    @JvmStatic
    public fun <Item> createListQueue() : Queue<Item> =  ListQueue()

}
