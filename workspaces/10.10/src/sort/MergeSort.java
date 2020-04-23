package sort;


public class MergeSort {
    public static void main(String[] args) {
        int[] arr = ArraysDemo.getArray(10);
        ArraysDemo.printlnArray(arr);
        arr = sort(arr, 0, arr.length - 1);
        ArraysDemo.printlnArray(arr);
    }

    private static int[] sort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
        return arr;
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, low, temp.length);
    }
}
