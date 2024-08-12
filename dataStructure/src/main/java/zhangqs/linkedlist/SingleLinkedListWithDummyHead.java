package zhangqs.linkedlist;

/**
 * 使用虚拟头节点 操作单项链表
 * @author zhangqs
 * @date 2024/08/05 06:54
 */
public class SingleLinkedListWithDummyHead {

    //定一个头节点
    private Node dummyHead;

    // 单项链表的长度大小
    private int size;

    //对 单项链表进行初始化 在构造函数 定一个null 的头节点
    public SingleLinkedListWithDummyHead() {
        this.dummyHead = new Node(null);
    }

    /**
     *  使用 虚拟头节点 进行头插法
     * @param value
     */
    public void prepend(int value){
        Node newNode = new Node(value);
        newNode.next = dummyHead.next; // 虚拟头节点next的指向赋值给新的节点的next指向
        dummyHead.next = newNode; // 虚拟头节点的next 指向 真正的头节点
        size++;
    }

    /**
     * 使用尾插法
     * @param value
     * @author zhangqs
     * @date 2024/08/01 07:19
     */
    public void addLast(int value){
        Node newNode = new Node(value);
        Node tmp = dummyHead;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
        size++;
    }

    /**
     * 在指定位置添加元素
     * @param index
     * @param value
     * @author zhangqs
     * @date 2024/08/06 06:37
     */
    public void add(int index, int value){
       rangeCheckForAdd(index);
       // 使用虚拟头节点,头节点不会是null 可以省去 头节点是否为null 判断
       // 找到 需要待插入数据的那个节点位置
        Node newNode = new Node(value);
        Node tmp = dummyHead;
        // 和 没有虚拟头节点最大的区别就是 在遍历链表找到需要待插入节点的前一个节点时，index不一样
        for(int i = 0; i < index; i++){
           tmp = tmp.next;
        }
        newNode.next = tmp.next;
        tmp.next = newNode;
        size++;
    }

    /**
     * 按照index  删除元素
     * @param index
     * @author zhangqs
     * @date 2024/08/12 06:54
     */
    public void  delete(int index){
        // 判断该 index是否合法
        if (index< 0  || index > size -1){
            throw new IllegalArgumentException(" index out of range");
        }
        Node tmp = dummyHead;
        for(int i = 0; i < index; i++){
          // 找到要删除节点的上一个节点
          tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        size--;
    }

    /**
     * 按照 值进行删除
     * @param value
     * @author zhangqs
     * @date 2024/08/12 07:13
     */
    public void deleteByValue(Object value){
        Node tmp = dummyHead;
        while (tmp.next!=null){
            if (tmp.next.data == value){
                tmp.next = tmp.next.next;
                size--;
            }else {
                tmp = tmp.next;
            }
        }
    }

    /**
     * 获取 单项链表的长度
     * @return java.lang.Integer
     * @author zhangqs
     * @date 2024/08/05 07:14
     */
    public Integer getSize(){
        return size;
    }

    //创建一个私有的内部类 Node节点
    private class Node {
        public Object data;

        public Node next;

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    @Override
    public String toString() {
        // 从头节点开始遍历这个链表
        // 用一个变量 初始化赋值头节点
        Node curr = dummyHead.next;
        StringBuilder builder = new StringBuilder();
        builder.append(curr.data);
        while (curr.next!=null){
            curr =curr.next;
            builder.append("->").append(curr.data);
        }
        return builder.toString();
    }


    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
}