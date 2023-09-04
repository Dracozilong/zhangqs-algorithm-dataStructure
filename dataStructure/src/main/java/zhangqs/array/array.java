package zhangqs.array;

/**
 *  实现一个 数组
 *  新增 删除 查找
 */
public class array {

    // 成员变量 不需要final 修饰 不需要在定义的时候初始化
    // 通过构造函数 对 数组 以及 大小进行初始化
    // 需要 默认值的时候 需要 在类初始化的时候 通过final 和 static 进行初始化

    // 定一个空数组
    public Object[] objects;

    // 数组个数
    public int size;

    //默认的空数组
    public static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public array() {
        this.objects = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public array(int size) {
        // 初始化数组
        if (size > 0){
            this.objects = new Object[size];
        } else if (size == 0) {
           this.objects = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal size: "+ size);
        }
    }

}