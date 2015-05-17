package io.farallons.util.stack

/**
 * Stack with command-query separation and uniform access
 */
public trait Stack<Item> : Iterable<Item>{

    public fun pop() : Stack<Item>

    public fun push(item : Item) : Stack<Item>

    public val top : Item?

    public val empty : Boolean

    public val size : Int

}
