package zhangqs.array;

/**
 *  实现一个 数组
 *  新增 删除 查找
 */
public class Array {

    // 成员变量 不需要final 修饰 不需要在定义的时候初始化。
    // 通过构造函数 对 数组 以及 大小进行初始化。
    // 需要 默认值的时候 需要 在类初始化的时候 通过final 和 static 进行初始化。
    // 如果一个变量既不在初始化的时候定义，也不在变量创建的时候初始化，那么该变量的创建毫无意义。

    // 定一个空数组
    private Object[] objects;

    // 数组个数
    private int size;

    //默认的空数组
    public static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public Array() {
        this.objects = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public Array(int initialCapacity) {
        // 初始化数组
        if (initialCapacity > 0){
            this.objects = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
           this.objects = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal size: "+ size);
        }
    }

    // 当前数组的成员个数
    public int size(){
        return size;
    }

    // 获取当前集合的容量
    public int getCapacity(){
        return objects.length;
    }


    // add 新增 按照顺序新增
    public boolean add(Object o){
        //动态扩容
        if (size == objects.length){ //当前数组的空间满了
            resize( 2* objects.length);
        }
        objects[size++]= o;
        return true;
    }

    // add 新增 在对应的位置新增元素
    public boolean add(int index ,Object o){
        //判断 index 数据是否正常
        rangeCheckForArray(index);
        //动态扩容
        if (size == objects.length){ //当前数组的空间满了
            resize( 2* objects.length);
        }

        // 当前下标的值往后移一位
        for (int i = size-1; i >=index; i--){
            objects[i+1]=objects[i];
        }
        objects[index]=o;
        size++;
        return true;
    }

    public Object get(int index){
       // 校验index 边界值
        if (index< 0  || index > size -1){
            return  -1;
        }
        return objects[index];
    }

    // 根据下标删除元素
    public Object delete (int index){
        //判断 index 数据是否正常
        rangeCheckForArray(index);;
        Object object = objects[index];
        //写法1  直接 在原数组上修改 返回true
        for (int i = index+1;i < size;++i){
            objects[i-1] =objects[i];
        }
        size--;
        if (size == objects.length / 2 ){
            resize(objects.length / 2);
        }


//        ////写法二  直接创建返回一个新的数组
//        Object[] elements = new Object[size-1];
//        int dex = 0;
//        for (int i =0;i<size;i++){
//            if (index == i){
//                continue;
//            }else {
//                elements[dex++]=objects[i];
//            }
//        }
//        size--;
//        objects =elements;
        return object;
    }


    private void rangeCheckForArray(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }


    // 动态扩容/缩容 数组大小
    private void resize(int capacity){
        Object[] newObjects = new Object[capacity];
        for (int i =0;i<size;i++){
            newObjects[i] = objects[i];
        }
        objects = newObjects;
    }

    //数组边界校验
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }


}