package io.farallons.puffin.bag

import io.farallons.puffin.stack.StackFactory

/**
 * Factory for Bags
 *
 * No implementations of Bag are threadsafe.
 */
public object BagFactory {

    @JvmStatic
    public fun <Item> createArrayStackBag() : Bag<Item> = StackBag(StackFactory.createArrayStack())

    @JvmStatic
    public fun <Item> createListStackBag() : Bag<Item> = StackBag(StackFactory.createListStack())

}