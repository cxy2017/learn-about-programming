package practice2;

/**
 * 只有实现了此接口的类才能使用快速排序QuikSort
 * 任意类均可实现此接口
 */
public interface SortMark {
    /**
     * 如果相等返回0,本实例大于参数实例返回1,本实例小于参数实例-1
     *
     * @param sortMark
     * @return -1,0,1
     */
    public int equals(SortMark sortMark);
}
