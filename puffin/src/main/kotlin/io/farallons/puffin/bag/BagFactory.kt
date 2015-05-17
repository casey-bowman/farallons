package io.farallons.puffin.bag

import io.farallons.puffin.stack.StackFactory
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