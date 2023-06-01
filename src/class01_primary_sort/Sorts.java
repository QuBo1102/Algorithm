package class01_primary_sort;

public class Sorts {
    public static void main(String[] args) {
        int[] arr = { 7, 1, 3, 5, 1, 6 };
        int N = arr.length;
        System.out.println("初始数组为");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        SelectSorting(arr, N);
        System.out.println("排序后数组为");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
//        BubbleSortingOrder2(arr,N);
//        System.out.println("排序后数组为");
//        for (int i = 0; i < N; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println(" ");
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //冒泡排序1
    static void BubbleSortingOrder1(int[] arr, int N) {
        //考虑特殊情况
        if (arr == null || N <= 1) {
            return;
        }
        //设置外圈主循环
        for (int i = 0; i < N; i++) {
            //设置内圈具体循环及判断
            for(int j = 1; j < N - i; j++) {
                if(arr[j - 1] > arr[j])
                    swap(arr, j - 1 , j);
            }
        }
    }

    //冒泡排序2
    static void BubbleSortingOrder2(int[] arr, int N) {
        //考虑特殊情况
        if (arr == null || N <= 1) {
            return;
        }
        //设置外圈主循环
        for (int i = N - 1; i >= 0; i--) {
            //设置内圈具体循环及判断
            for(int j = 1; j <= i; j++) {
                //这里要注意j<=i 如果不加等号 在最初始一次遍历时 j最多到N - 2 少遍历了最后一个元素 而且这里也不和最后的i = 0发生冲突 因为那时j大于i 不会进入for循环
                if(arr[j - 1] > arr[j])
                    //正序和逆序的差别就在这个判断这里
                    swap(arr, j - 1 , j);
            }
        }
    }

    //插入排序1
    static void InsertSorting1(int[] arr, int N) {
        //考虑特殊情况
        if (arr == null || N <= 1) {
            return;
        }
        for (int cur = 1; cur < N; cur++) {
            for (int pre = cur - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                // 不要比较 cur和 pre 而是比较 pre 和 pre + 1 避免出现 arr[-1]的情况
                // 根本就不是 cur和 pre 比较 cur 只是外围 根本上还是 pre 和 pre + 1 比较
                swap(arr, pre + 1, pre);
            }
        }
    }

    //插入排序2
    static void InsertSorting2(int[] arr, int N) {
        //考虑特殊情况
        if (arr == null || N <= 1) {
            return;
        }
        for (int i = 1; i < N; i++) {
            int pre = i - 1;

            while (pre >= 0) {
                if (arr[pre] > arr[pre + 1])
                    swap(arr, pre + 1, pre);
                pre--;
                }
            }
        }

    //选择排序
    static void SelectSorting(int[] arr, int N) {
        //考虑特殊情况
        if (arr == null || N <= 1) {
            return;
        }
        for (int i = 0; i < N; i++) {
            int maxNum = i;

            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[maxNum]) {
                    maxNum = j;
                }
                //maxNum = arr[j] > arr[maxNum] ? j : maxNum;
            }
            swap(arr, i, maxNum);
        }
    }
}



