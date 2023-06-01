package class03_binary_search;

/**
 * 问题：给定一个无序数组，相邻位置的数字不同，找出其中的一种局部最小的情况即可 返回其下标
 *
 * 局部最小： 对于元素下标i       当满足以下条件时为局部最小
 *           i = 0              arr[0] < arr[1]
 *           i = n - 1          arr[n - 1] < arr[n - 2]
 *           0 < i < n - 1      arr[i] < arr[i - 1] && a[i] < arr[i + 1]
 *
 */
public class LocalMinimized {
    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 3, 5};
        System.out.println(LocalMinimized(arr));
    }

    public static int LocalMinimized(int[] arr) {
        int n = arr.length;
        if (arr == null || n == 1) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        } else if (arr[n - 1] < arr[n - 2]) {
            return n - 1;
        } else if (n <= 3) {
            return -1;
        }

        int l = 1, r = n - 2, k = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m - 1] <= arr[m]) {
                r = m - 1;

            } else if (arr[m + 1] <= arr[m]) {
                l = m + 1;
            } else if (arr[m] < arr[m - 1] && arr[m] < arr[m + 1]) {
                k = m;
                return k;
            }
        }
        return -1;
    }
}
