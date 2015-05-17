package io.farallons.util.stack

import kotlin.platform.platformStatic

/**
 * Factory for Stacks
 *
 * No implementations of Stack are threadsafe.
 */
public object StackFactory {

    public platformStatic fun <Item> createArrayStack() : Stack<Item> =  ArrayStack()

    public platformStatic fun <Item> createListStack() : Stack<Item> = ListStack()

}
