package zhangqs.linkedlist;


import java.util.LinkedList;

// 实现一个单项链表
public class SingleLinkedList {

    //定一个头节点
    private Node head;

    // 单项链表的长度大小
    private int size;

    //对 单项链表进行初始化 在构造函数 定一个null 的头节点
    public SingleLinkedList() {
        this.head = null;
    }

    /**
     * 尾插法  在链表的尾部插入节点，传入Node节点需要的值
     * @param value
     */
    public void add(int value){
        Node node = new Node(value);
        // 判断头节点 是否为 null
        if (head ==null){
            head =node;
        }else {
            Node temp = head;
            while (temp.next!=null){
                temp =temp.next;
            }
            // 退出while 循环以后 说明当前temp 代表temp是链表的最后一个节点 把当前入参 Node 节点 赋值给最后一个节点的next域
            temp.next = node;
        }
        size++;
    }

    /**
     *  头插法 ，更新头节点
     * @param value
     */
    public void prepend(int value){
        Node newHead = new Node(value);
        if (head == null) {
            head = newHead; // 链表为空，新节点成为头节点
        } else {
            newHead.next = head; // 新节点指向原头节点
            head = newHead; // 更新头节点为新节点
        }
        size++;
    }


    /**
     * 获取指定位置的元素
     * @param index
     */
    public Node get(int index){
        // 判断该index 是否合法

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
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

    /**
     * 根据位置 删除链表的节点
     * @param index
     */
    public void delete(int index){
        // 判断该 index是否合法
        if (index< 0  || index > size -1){
            throw new IllegalArgumentException(" index out of range");
        }
        // 如果链表为空
        if (head ==null){
            return;
        }
        // 删除的是首节点
        if (index == 0 ){
           head =head.next;
        }
        // 头节点赋值给变量cur
        Node pre = head;
        Node curr = head.next;
        for (int i = 1; i <index-1; i++) {
            pre = curr;
            curr =curr.next;
        }
        //当前的 curr 已经是最后一个节点 curr.next 为null
        pre.next =curr.next;
        curr.next =null;
        size--;
    }

    /**
     *  按照 值 删除链表中的元素
     * @param value
     */
    public void deleteByValue (int value){
       // 需要判断头节点的是否为null 且头节点的值是否和传入的value 值相等
        while (head!=null && head.data ==value){ // 存在 一种情况 1->1->1->1 这种值都是一样的重复链表
           head =head.next;
           size--;
        }
       // 记录链表的头节点
       Node pre = head;
       Node curr = head.next;
       // 判断当前头节点 不为nul 且 curr 节点 不为null
       while (pre!=null && curr!=null){
           if (curr.data ==value){
               pre.next = curr.next;  // 删除当前节点
               size--;
           }else {
               pre = curr;
           }
           curr = curr.next;  // 始终后移curr
       }
    }

    /**
     * 在指定位置插入元素
     * @param index
     * @param value
     */
    public void add(int index,int value){
        // 1. 校验需要插入的位置是否存在
        rangeCheckForAdd(index);
        // 2. 判断头节点是否为 null
        if (head ==null){
            throw new IllegalArgumentException("Index out of range.");
        }
        // 3. 如果当前插入的位置是在头节点处
        if (index == 0){
            prepend(value);
        }else {
            // 3.1 找到当前需要插入的节点数据的原节点的数据 ，所以需要遍历链表
            Node curr = head;
            for (int i = 0; i < index-1; i++) {
                curr =curr.next;
            }
            Node node = new Node(value);
            node.next =curr.next;
            curr.next = node;
            size++;
        }


    }

    @Override
    public String toString() {
        // 判断 head 节点是否为null 为null 返回一个空的字符串
        if (head == null){
            return "";
        }
        // 从头节点开始遍历这个链表
        // 用一个变量 初始化赋值头节点
        Node curr = head;
        StringBuilder builder = new StringBuilder();
        builder.append(head.data);
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


    //创建一个私有的内部类 Node节点
    private class Node {
        public int data;

        public Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }

        @Override
        public String toString() {
           return String.valueOf(data);
        }
    }
}