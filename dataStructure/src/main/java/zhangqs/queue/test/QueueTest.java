package zhangqs.queue.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zhangqs.queue.Queue;


public class QueueTest {

    private final Logger logger = LoggerFactory.getLogger(QueueTest.class);

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}