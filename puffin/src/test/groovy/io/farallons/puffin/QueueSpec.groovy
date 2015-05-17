package io.farallons.puffin

import io.farallons.puffin.queue.Queue
import io.farallons.puffin.queue.QueueFactory
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class QueueSpec extends Specification {
    @Shared
    Queue<String> queue

    def "ListQueue implementation enqueues and dequeues items correctly"() {
        given:
        queue = QueueFactory.createListQueue()


        when:
        queue.enqueue("hello")
        queue.enqueue("world")
        then:
        queue.front == "hello"
        queue.size == 2


        when:
        queue.dequeue()
        then:
        queue.front == "world"
        queue.size == 1

        when:
        queue.dequeue()
        then:
        queue.front == null
        queue.empty
        queue.size == 0
    }

    def "ListQueue iterator iterates correctly"() {
        given:
        queue = QueueFactory.createListQueue()


        when:
        queue.enqueue("hello")
        queue.enqueue("world")
        Iterator<String> it = queue.iterator()
        then:
        it.hasNext()

        when:
        String st = it.next()
        then:
        st == "hello"
        it.hasNext()

        when:
        st = it.next()
        then:
        st == "world"
        !it.hasNext()
        !queue.empty
        queue.front == "hello"
        queue.size == 2
    }

}