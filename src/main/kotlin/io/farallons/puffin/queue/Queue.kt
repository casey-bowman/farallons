package io.farallons.puffin.queue

public interface Queue<Item> : Iterable<Item>{

    public fun enqueue(item: Item) : Queue<Item>

    public fun dequeue() : Queue<Item>


    public val front : Item?

    public val size : Int

    public val empty : Boolean

}

