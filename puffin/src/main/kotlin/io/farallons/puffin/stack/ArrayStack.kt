package io.farallons.puffin.stack


private class ArrayStack<Item>() : AbstractStack<Item>() {

    var array : Array<Item?> = arrayOfNulls<Any>(1) as Array<Item?>

    var stackSize : Int = 0
    var arraySize : Int = 1
    var quarterArraySize : Int = 0



    override
    fun empty(): Boolean {
        return (stackSize==0)
    }


    override
    fun top(): Item? {
        if (empty()) return null
        return array.get(stackSize-1)
    }


    override
    fun pop(): Stack<Item> {
        if (!empty()) {

            array.set(stackSize-1, null)
            stackSize--
            downSizeArrayIfNecessary()
        }
        return this
    }

    override
    fun push(item: Item): Stack<Item> {
        upSizeIfNecessary()
        stackSize++
        array.set(stackSize-1, item)
        return this
    }

    private fun upSizeIfNecessary() {
        if (needToUpSizeArray()) {
            resizeArray(2*stackSize)
        }
    }

    private fun downSizeArrayIfNecessary() {
        if (needToDownSizeArray()) {
            resizeArray(stackSize/2)
        }
    }

    private fun needToUpSizeArray() : Boolean {
        return stackSize == arraySize
    }

    private fun needToDownSizeArray() : Boolean {
        return stackSize < quarterArraySize
    }

    private fun resizeArray(newArraySize : Int) {
        var oldArray : Array<Item?> = array
        array = arrayOfNulls<Any>(newArraySize) as Array<Item?>
        if (!empty()) {
            for (i in  0..(stackSize-1)) {
                array.set(i, oldArray.get(i))
            }
        }
        arraySize = newArraySize
        quarterArraySize = arraySize / 4
    }

    override
    fun size(): Int = stackSize

    override
    fun iterator(): Iterator<Item> {
        return ArrayStackIterator(array)
    }

    // array should work but there seems to be a bug affecting access to the outer class field, so arrayRef is workaround
    private inner class ArrayStackIterator<Item>(var arrayRef : Array<Item?> ) : Iterator<Item> {

        var nextIndex : Int = stackSize-1

        override
        fun next(): Item {
            if (nextIndex>=0) {
                val item : Item = arrayRef.get(nextIndex)!!
                nextIndex--
                return item!!
            }
            else throw IllegalArgumentException("Iterator.next() may not be called if there is no next; use hasNext() to check first")
        }

        override
        fun hasNext(): Boolean {
            return (nextIndex >=0)
        }

    }

}
