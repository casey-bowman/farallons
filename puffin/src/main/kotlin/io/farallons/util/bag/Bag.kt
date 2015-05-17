package io.farallons.util.bag

/**
 * Bag with command-query separation and uniform access
 */

public trait Bag<Item> : Iterable<Item> {

    public fun add(item: Item): Bag<Item>

    public val size: Int
}
