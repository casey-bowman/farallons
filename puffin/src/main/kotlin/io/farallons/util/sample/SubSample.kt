package io.farallons.util.sample

public class SubSample(val st1: String, val st2:String) : Sample(st1) {

    override
    public fun toString() : String = st1 + " " + st2
}
