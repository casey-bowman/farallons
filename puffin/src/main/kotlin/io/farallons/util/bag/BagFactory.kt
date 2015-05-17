package io.farallons.util.bag

import io.farallons.util.stack.StackFactory
import kotlin.platform.platformStatic

/**
 * Factory for Bags
 *
 * No implementations of Bag are threadsafe.
 */
public object BagFactory {

    public platformStatic fun <Item> createArrayStackBag() : Bag<Item> = StackBag(StackFactory.createArrayStack())

    public platformStatic fun <Item> createListStackBag() : Bag<Item> = StackBag(StackFactory.createListStack())

}