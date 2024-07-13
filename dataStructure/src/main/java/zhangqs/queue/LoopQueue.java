package zhangqs.queue;
import lombok.Getter;

import java.util.Arrays;

/**
 * 循环队列
 * @author zhangqs
 * @date 2024/06/24 06:56
 */
public class LoopQueue {

    //自定义数组
    private Object[] array;

    //循环队列长度大小 , 可以只用 front 和 tail 实现
    @Getter
    private int size;

    //循环队列的头
    private int front;

    //循环队列的尾
    private int tail;

    //初始化
    public LoopQueue(int capacity) {
        // 循环队列 默认要多浪费一个数组的 index,用来判断tail 和 front的关系
        array = new Object[capacity + 1];
        front = 0;
        tail = 0;
        size =0;
    }

    public LoopQueue(){
        //没有指定数组大小 给默认值
        array = new Object[10];
    }

    public int getCapacity(){
        // 该循环实际能承载的容量是数组的 length -1
        return array.length-1;
    }

    // 循环队列判断为空的条件 头和尾 相等
    public boolean isEmpty(){
        return  front == tail;
    }

    //循环队列判断是否已满的条件 尾+1 对数组长度取模 = 首
    public boolean isFull(){
        return (tail+1) % array.length == front;
    }

    public int size(){
        return size;
    }

    // 入队
    public void enqueue(Object item){
        // 判断 队列是否已满
        if (isFull()){
            throw new IndexOutOfBoundsException("Queue is full");
        }
        // 赋值
        array[tail] = item;
        tail = (tail + 1) % array.length;
        size++;
    }

    // 出队
    public Object dequeue(){
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        Object object = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size --;
        return object;
    }

    // 获取循环队列第一个元素
    public Object getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return array[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % array.length){
            res.append(array[i]);
            if((i + 1) % array.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }


}