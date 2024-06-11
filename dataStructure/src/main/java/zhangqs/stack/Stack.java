package zhangqs.stack;
import zhangqs.array.Array;


/**
 * 栈 可以使用 数组/链表 形式去表示
 * @author zhangqs
 * @date 2024/06/04 06:41
 */
public class Stack {

    //  1.栈是一种先进后出的数据结构，常用的使用场景，例如 计算器 撤销操作 只有一个入口进出
    //  2. 初始化 入栈 出栈 查看栈顶元素 判断栈是否为空

    // 使用数组实现
    private Array array;

    // 标志位 记录当前的栈顶的位置
    private int top;

    // 使用 数组指定容量 进行初始化
    public Stack(int capacity) {
        array = new Array(capacity);
        //初始化栈顶标志位为 -1 top初始化为-1 意味着栈没有有效的元素索引，因为数组的有效索引从0开始，初始化为-1可以确保操作边界条件更加容易，能正确的表示空栈和满栈的状态
        top = -1;
    }

    // 使用 数组 进行初始化
    public Stack(){
        array = new Array();
        top = -1;
    }

    //入栈
    public boolean push(int value) {
        // 先判断一下 当前栈是否已漫
        if (isFull()){
            throw new StackOverflowError("stack is full");
        }
        // 使用数组的add功能 默认添加到最后一个
        top++;
        array.add(value);
        return true;
    }

    //出栈
    public Object pop(){
       //判断当前栈是否为空
        if (isEmpty()){
            throw new IllegalStateException("stack is empty");
        }
        Object o = array.delete(top);
        top--;
        return o;
    }

    // 判断是否为空
    public boolean isEmpty(){
      return top == -1;
    }

    //判断是否栈已满
    public boolean isFull(){
        return top == getCapacity() -1 ;
    }

    public int size(){
        return top+1;
    }

    public int getCapacity(){
        return array.getCapacity();
    }
}