package homework;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {3, 54, 21, 35, 22, 32, 123, 78, 9, 4};
        System.out.println(Arrays.toString(array));
//        �鲢����
        mergeSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
//        �۰����
        int key = 2;//���ҵĹؼ���
        for (int i = 0; i < array.length; i++) {

            System.out.println(binarySearch(array, array[i]));
        }
        System.out.println(binarySearch(array, 23));

    }

    //    �۰���ҷ��ز��ҵ�Ԫ�ص�����,���û�з���-1
    public static int binarySearch(int[] arr, int key) {
        {
            int max, min, mid;
            max = arr.length - 1;
            min = 0;
            mid = (max + min) / 2;
//            if (arr[0]==key&&mid!=min) return 0;
            while (arr[mid] != key) {
                if (arr[mid] > key)
                    max = mid - 1;
                else if (arr[mid] < key)
                    min = mid + 1;

                if (min > max)
                    return -1;
                mid = (max + min) / 2;
//                if (arr[0]==key&&mid!=min&&mid!=max) return 0;
            }
            return mid;
        }
    }

    /*public static int search(int[] array, int key, int start, int end) {
        int mid=(start+end)/2;
        while (array[mid]!=key){
                 mid=(start+end)/2;
                if (key>array[mid]){
                    end=mid-1;
                }else if(key<array[mid]){
                    start=mid+1;
                }
                if (start>end){
                    return -1;
                }
            }


        return mid;
    }*/

    public static void mergeSort(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    public static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
//        ��ָ��
        int start = low;
//        ��ָ��    hj
        int end = mid + 1;
        int k = 0;
        //����߿�ʼ�Ƚ�,����С���ȷ���temp����
        while (start <= mid && end <= high) {

            if (array[start] > array[end]) {
                temp[k++] = array[end++];
            } else {
                temp[k++] = array[start++];
            }
        }
//        ����߱ߵ������������
        while (start <= mid) {
            temp[k++] = array[start++];
        }
//        ���ұߵ������������
        while (end <= high) {
            temp[k++] = array[end++];
        }
//        ��temp���鸴�Ƶ�array������
        System.arraycopy(temp, 0, array, low, temp.length);
    }
}
