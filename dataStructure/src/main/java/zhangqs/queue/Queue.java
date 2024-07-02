package zhangqs.queue;

import zhangqs.array.Array;

/**
 * 用数组去实现队列
 * @author zhangqs
 * @date 2024/06/18 06:49
 */
public class Queue {

    private Array array;

    // 带初始化大小的构造函数
    public Queue(int capacity) {
        array = new Array(capacity);
    }

    public Queue() {
        array = new Array();
    }

    //当前队列的size
    public int size() {
        return array.size();
    }

    // 当前队列的容量
    public int getCapacity(){
        return array.getCapacity();
    }

    //把 元素加入队列末尾
    public boolean enqueue(int value) {
        return array.addLast(value);
    }

    //把 元素从队列中取出
    public Object dequeue() {
        return array.removeFirst();
    }

    // 获取 队列的第一个元素
    public Object getFront(){
        return array.get(0);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.size() ; i ++){
            res.append(array.get(i));
            if(i != array.size() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}