package class03_binary_search;

/**
 * 问题：给定一个按顺序排列的数组nums和目标值target，要求找到数组中 >= target的最左的位置
 */
public class LessThanOrEqualTheLeft {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4,5,6};
        int target = 2;
        System.out.println(LessThanOrEqual(nums, target));
    }
    public static int LessThanOrEqual(int[] nums, int target) {
        int n = nums.length, l = 0, r = n - 1, k = -1;
        while (l <= r) {
            int m = (l + r)/2;
            if (nums[m] >= target) {
                r = m - 1;
                k = m;// 这里不需要加额外的条件了 因为本身这个循环就是在往里收缩的
            } else if (nums[m] < target) {
                l = m + 1;
            }
//            else if (nums[m] == target) {
//                l = m;
//                if (k < l)
//                    k = l;
//            }
        }
        return k;
    }
}

