package io.farallons.puffin.stack

/**
 * Factory for Stacks
 *
 * No implementations of Stack are threadsafe.
 */
public object StackFactory {

    @JvmStatic
    public fun <Item> createArrayStack() : Stack<Item> =  ArrayStack()

    @JvmStatic
    public fun <Item> createListStack() : Stack<Item> = ListStack()

}
