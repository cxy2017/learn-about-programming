package sort;


import java.util.Random;


public class ArraysDemo {
    public static void main(String[] args) {
// 1.     ��ȡ����Ϊ5,Ԫ��������ɵ�����
        function1();
// 2.     ����һ��������5������,����������,���Ȼ��ת,�ٴ����
        function12();
// 3.     ����һ������Ϊ10������,����������,����ѡ�������㷨���д�С�������
//        Ȼ���ٶ���ʹ��ð�������㷨���дӴ�С����
        function3();
// 4.     ��3ʹ�ù鲢�Ϳ��������㷨
        function14(function3());
    }

    private static void function14(int[] arr4) {
//        ��������
        int[] arr4C = arr4.clone();
        printlnArray(arr4);
        quickSort(arr4);
        printlnArray(arr4);
//        �鲢����
        mergeSort(arr4C);
        printlnArray(arr4C);
        System.out.println("--------------------------------------");

    }

    private static void mergeSort(int[] arr) {
        mergeSorts(arr, 0, arr.length - 1);
    }

    private static int[] mergeSorts(int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        if (low < high) {
            //�ݹ�
            mergeSorts(arr, low, mid);
            mergeSorts(arr, mid + 1, high);
            //�ؼ������鲢
            merge(arr, low, mid, high);
        }
        return arr;
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        //����һ����������,�洢����������
        int[] temp = new int[high - low + 1];
        //��ָ��
        int i = low;
        //��ָ��
        int j = mid + 1;
        //������������
        int k = 0;
        //����С��Ԫ�ش洢���������
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        //�����ʣ���Ԫ�ش��뻺������
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        //���ұ�ʣ���Ԫ�ش��뻺������
        while (j <= high) {
            temp[k++] = arr[j++];
        }
        //�û������鸲��ԭ������Ԫ��
        System.arraycopy(temp, 0, arr, low, temp.length);
    }

    //    ��������
    private static void quickSort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        sort(arr, start, end);

    }

    private static void sort(int[] arr, int low, int high) {
        int start = low;
        int end = high;
        int key = arr[low];
        int temp;
        while (start < end) {
            //�Ӻ���ǰ�Ƚ�
            while (arr[end] > key && end > start)
                end--;
            if (arr[end] < key) {
                temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            //��ǰ����Ƚ�
            while (arr[start] < key && end > start)
                start++;
            if (arr[start] > key) {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        //�ݹ�,�Է���,��������,ֱ�������ٷ�Ϊֹ
        if (start > low) sort(arr, low, start - 1);
        if (end < high) sort(arr, end + 1, high);

    }

    private static int[] function3() {
        //��ȡ����Ϊ10,Ԫ��������ɵ�����
        int[] arr3 = getArray(10);
        int[] arr4 = arr3.clone();
        //�������
        printlnArray(arr3);
        //ѡ������
        selectionSort(arr3);
        //�������
        printlnArray(arr3);
        //ð������
        bubbleSort(arr3);
        //�������
        printlnArray(arr3);
        System.out.println("--------------------------------------");
        return arr4;
    }

    private static void function12() {
        //��ȡ����Ϊ5,Ԫ��������ɵ�����
        int[] arr2 = getArray(5);
        //�������
        System.out.print("arr2");
        printlnArray(arr2);
        //��ת����
        int[] arr2R = reverseArray(arr2);
        //�������
        printlnArray(arr2R);
        System.out.println("--------------------------------------");
    }

    private static void function1() {
        //��ȡ����Ϊ5,Ԫ��������ɵ�����
        int[] arr1 = getArray(5);
        //��ȡ��Сֵ
        int min = getMin(arr1);
        //�������
        System.out.print("arr1");
        printlnArray(arr1);
        System.out.println("������Сֵ" + min);
        System.out.println("--------------------------------------");
    }

    //    ð������ (����)
    private static void bubbleSort(int[] arr) {
        int temp;
        for (int j = arr.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] < arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

    }

    //    ѡ������ (����)
    private static void selectionSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //    ��ת����
    private static int[] reverseArray(int[] arr) {
        int temp;
        int i = 0;
        for (int j = arr.length - 1; i < j; j--) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
        }
        return arr;
    }

    //    �������
    public static void printlnArray(int[] arr) {
        System.out.print("����Ԫ����{");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("}");
    }

    //    ��ȡ��Сֵ
    private static int getMin(int[] arr) {
        int min = arr[0];
        for (int i : arr) {
            //3.    ���ҳ������е���Сֵ
            min = i < min ? i : min;
        }
        return min;
    }

    //��ȡָ����������,��Ϊ����ÿ��Ԫ�ظ����������
    public static int[] getArray(int length) {
        int[] arr = new int[length];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            //2.    Ȼ��������ÿһλ�����������
            arr[i] = r.nextInt(1000);
        }
        return arr;
    }
}
