package io.farallons.puffin.node

public data class ListNode<Item> (
        var item: Item,
        var next: ListNode<Item>?
)