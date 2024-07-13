package zhangqs.queue.test;

import lombok.extern.slf4j.Slf4j;
import zhangqs.queue.LoopQueue;

@Slf4j
public class LoopQueueTest {

    public static void main(String[] args) {
        LoopQueue loopQueue = new LoopQueue(10);
        for(int i = 0 ; i < 10 ; i ++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.enqueue(10);
        loopQueue.enqueue(11);
    }
}