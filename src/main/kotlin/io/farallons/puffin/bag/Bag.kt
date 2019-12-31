package io.farallons.puffin.bag

/**
 * Bag with command-query separation and uniform access
 */

public interface Bag<Item> : Iterable<Item> {

    public fun add(item: Item): Bag<Item>

    public val size: Int
}
