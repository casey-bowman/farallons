package io.farallons.util

import io.farallons.util.stack.StackFactory
import io.farallons.util.stack.Stack
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class StackSpec extends Specification {
    @Shared
    Stack<String> stack

    def "ListStack implementation pushes and pops items correctly"() {
        given:
        stack = StackFactory.createListStack()


        when:
        stack.push("hello")
        stack.push("world")
        then:
        stack.top == "world"
        stack.size == 2


        when:
        stack.pop()
        then:
        stack.top == "hello"
        stack.size == 1

        when:
        stack.pop()
        then:
        stack.top == null
        stack.empty
        stack.size == 0
    }

    def "ArrayStack implementation pushes and pops items correctly"() {
        given:
        stack = StackFactory.createArrayStack()


        when:
        stack.push("hello")
        stack.push("world")
        then:
        stack.top == "world"
        stack.size == 2


        when:
        stack.pop()
        then:
        stack.top == "hello"
        stack.size == 1


        when:
        stack.pop()
        then:
        stack.top == null
        stack.empty
        stack.size == 0
    }

    def "ListStack iterator iterates correctly"() {
        given:
        stack = StackFactory.createListStack()


        when:
        stack.push("hello")
        stack.push("world")
        Iterator<String> it = stack.iterator()
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
        !stack.empty
        stack.top == "world"
        stack.size == 2
    }

    def "ArrayStack iterator iterates correctly"() {
        given:
        stack = StackFactory.createArrayStack()

        when:
        stack.push("hello")
        stack.push("world")
        Iterator<String> it = stack.iterator()
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
        !stack.empty
        stack.top == "world"
        stack.size == 2
    }


}

