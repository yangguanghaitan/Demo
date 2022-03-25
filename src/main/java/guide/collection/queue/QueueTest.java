package guide.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueTest {
    public static void main(String[] args) {
        Deque d=new ArrayDeque();
        d.add("a123");
        d.add("b");
        d.add("fd");
        d.add("bjj");
        System.out.println(d.pollFirst());
        System.out.println(d.peekLast());
        System.out.println(d.size());
    }
}
