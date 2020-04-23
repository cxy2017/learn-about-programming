public class MyArrayList<T> {
    private final int DEFUALT_SIZE = 10;
    //初始化容量
    private int initSize;
    //扩充容量
    private int increaseSize = initSize;
    //    数组大小
    private int size = 0;
    //声明一个容器数组
    private Object[] objects;

    /**
     * 在构造器中初始化数组容器
     *
     * @param initSize 初始化容量数组容器
     */
    public MyArrayList(int initSize) {
        this.initSize = initSize;
        objects = new Object[initSize];
    }

    /**
     * 使用默认数组容量初始化数组容器
     */
    public MyArrayList() {
        initSize = DEFUALT_SIZE;
        objects = new Object[initSize];
    }

    /**
     * 向数组容器中添加一个元素
     * @param object 需要添加的元素
     * @return 如果添加成功返回true
     */
    public boolean add(T object) {
        ensureCapacity();
        objects[size++] = object;
        return true;
    }

    /**
     * 确保容器中容量充足
     */
    private void ensureCapacity() {
        if (size >= increaseSize - 1) {
            Object[] temp = new Object[increaseSize += 10];
            System.arraycopy(objects, 0, temp, 0, objects.length - 1);
            objects = temp;
        }
    }

    /**
     * 获取数组容器中元素的个数
     * @return 返回size
     */
    public int size() {
        return size;
    }

    /**
     * 根据索引获取对应的元素
     * @param index 元素索引
     * @return 返回对应的元素
     */
    public T get(int index) {
        indexCheck(index);
        return (T) (objects[index]);
    }

    /**
     * 检查索引是否超出size,如果超出范围就抛出IndexOutOfBoundsException
     * @param index 需要被检查的索引
     */
    private void indexCheck(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("索引:" + index + "超出集合大小范围");
        }
    }
}
