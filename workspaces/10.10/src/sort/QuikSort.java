package sort;


public class QuikSort {
    public static void main(String[] args) {
        int[] arr = ArraysDemo.getArray(10);
        ArraysDemo.printlnArray(arr);
        sort(arr, 0, arr.length - 1);
        ArraysDemo.printlnArray(arr);
    }

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
}
