package class03_binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {};
        int num = 0;//要查找的数字
        System.out.println(BinarySearch(arr, num));
    }
    public static int BinarySearch(int[] arr, int num) {
        int n = arr.length;
        if (arr == null || arr.length == 0){
            return -1;//这里加一个arr.length为0时 不加好像也行
        }
        int left = 0;
        int right = n-1;

        while (left <= right) {
            //小于等于
            int middle = (left + right)/2;
            if (num < arr[middle]) {
                //是数字和arr[middle]相比 不是和middle相比
                right = middle - 1;
            }
            else if (num > arr[middle]) {
                left = middle + 1;
            }
            else if (num == arr[middle]) {
                return middle;
            }
        }
        return -1;
    }
}
