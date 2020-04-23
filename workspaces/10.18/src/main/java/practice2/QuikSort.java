package practice2;

/**
 * .现在我们的快速排序算法只能对int数组进行排序，
 * 运用多态和面向抽象编程的思想将其改写，
 * 使得：该类支持对任意自定义类型进行排序
 */
public class QuikSort {
    public static void sort(int[] arr, int low, int high) {

        int start = low;
        int end = high;
        int key = arr[low];
        int temp;
        while (start < end) {
            while (end > start && arr[end] > key)
                end--;
            if (arr[end] < key) {
                temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            while (end > start && arr[start] < key) {
                start++;
            }
            if (arr[start] > key) {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        if (start > low) sort(arr, low, start - 1);
        if (end < high) sort(arr, end + 1, high);
    }

    public static void sort(SortMark[] arr, int low, int high) {
        int start = low;
        int end = high;
        SortMark key = arr[low];
        SortMark temp;
        while (start < end) {
            while (end > start && (arr[end].equals(key) == 1))
                end--;
            if (arr[end].equals(key) == -1) {
                temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            while (end > start && (arr[start].equals(key) == -1)) {
                start++;
            }
            if (arr[start].equals(key) == 1) {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        if (start > low) sort(arr, low, start - 1);
        if (end < high) sort(arr, end + 1, high);
    }
}
