package io.farallons.util.queue

import kotlin.platform.platformStatic

public object QueueFactory {
    public platformStatic fun <Item> createListQueue() : Queue<Item> =  ListQueue()

}
