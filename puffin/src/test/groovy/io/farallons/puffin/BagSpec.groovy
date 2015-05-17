package io.farallons.puffin

import io.farallons.puffin.bag.Bag
import io.farallons.puffin.bag.BagFactory
import io.farallons.puffin.sample.Sample
import io.farallons.puffin.sample.SubSample
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise



@Stepwise
class BagSpec extends Specification {

    @Shared
    Bag<String> bag

    @Shared
    Bag<Sample> bag2

    def "ListStackBag implementation adds items correctly"() {
        when:
        bag = BagFactory.createListStackBag()
        then:
        bag.size == 0

        when:
        bag.add("hello")
        then:
        bag.size == 1

        bag.add("world")
        then:
        bag.size == 2
    }

    def "ListStackBag iterator iterates correctly"() {
        given:
        bag = BagFactory.createListStackBag()


        when:
        bag.add("hello")
        bag.add("world")
        Iterator<String> it = bag.iterator()
        then:
        it.hasNext()

        when:
        String st = it.next()
        then:
        st == "world"
        it.hasNext()

        when:
        st = it.next()
        then:
        st == "hello"
        !it.hasNext()
        bag.size == 2
    }

    def "ArrayStackBag implementation adds items correctly"() {
        when:
        bag = BagFactory.createArrayStackBag()
        then:
        bag.size == 0

        when:
        bag.add("hello")
        then:
        bag.size == 1

        bag.add("world")
        then:
        bag.size == 2
    }

    def "ArrayStackBag iterator iterates correctly"() {
        given:
        bag = BagFactory.createArrayStackBag()


        when:
        bag.add("hello")
        bag.add("world")
        Iterator<String> it = bag.iterator()
        then:
        it.hasNext()

        when:
        String st = it.next()
        then:
        st == "world"
        it.hasNext()

        when:
        st = it.next()
        then:
        st == "hello"
        !it.hasNext()
        bag.size == 2
    }




    def "ListStackBag implementation adds items correctly with subclasses"() {
        when:
        bag2 = BagFactory.createListStackBag()
        then:
        bag2.size == 0

        when:
        bag2.add(new Sample("hello"))
        then:
        bag2.size == 1

        bag2.add(new SubSample("beautiful","world"))
        then:
        bag2.size == 2
    }

    def "ListStackBag iterator iterates correctly with subclasses"() {
        given:
        bag2 = BagFactory.createListStackBag()


        when:
        bag2.add(new Sample("hello"))
        bag2.add(new SubSample("beautiful","world"))
        Iterator<String> it = bag2.iterator()
        then:
        it.hasNext()

        when:
        Sample sample = it.next()
        then:
        sample.toString() == "beautiful world"
        it.hasNext()

        when:
        sample = it.next()
        then:
        sample.toString() == "hello"
        !it.hasNext()
        bag2.size == 2
    }

    def "ArrayStackBag implementation adds items correctly with subclasses"() {
        when:
        bag2 = BagFactory.createArrayStackBag()
        then:
        bag2.size == 0

        when:
        bag2.add(new Sample("hello"))
        then:
        bag2.size == 1

        bag2.add(new SubSample("beautiful","world"))
        then:
        bag2.size == 2
    }

    def "ArrayStackBag iterator iterates correctly with subclasses"() {
        given:
        bag2 = BagFactory.createArrayStackBag()


        when:
        bag2.add(new Sample("hello"))
        bag2.add(new SubSample("beautiful","world"))
        Iterator<String> it = bag2.iterator()
        then:
        it.hasNext()

        when:
        Sample sample = it.next()
        then:
        sample.toString() == "beautiful world"
        it.hasNext()

        when:
        sample = it.next()
        then:
        sample.toString() == "hello"
        !it.hasNext()
        bag2.size == 2
    }
}