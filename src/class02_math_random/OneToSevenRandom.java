package class02_math_random;

/**
 * 本题：已知一个函数/方法 f，等概率返回[1,5]间的随机整数，要求在不使用Math.Random的限制下，
 *      写一个函数能等概率返回[1,7]
 * 思路：将已知的函数修改为[0,1]等概率二分类器f1（意思就是返回0的概率和返回1的概率相等）
 *      当f的返回值为1和2时，f1为0；当f的返回值为4和5时，f1为1；当f的返回值为3时，重新回到f
 *      （这里的返回值为几都是一样的 只要是等概率即可）
 *      再利用移位符实现函数返回值从1到7 (f1() << 2) (f1() << 1) f1左移两位实现百位为 f1左移一位实现个位
 *
 * 问题：已知已知为[3.15](a,b) 要求设置新函数等概率返回[18,60]([x,y])
 * 通用解法：将已知的函数按照相等概率为返回值为[0,1](a到a+b/2为1 a到a+b/2为0 中间有剩余数字就重新返回随机数) 有多余的就重做
 *         再通过移位找到题目要求的区间范围[0,42]([0,y-x])（可能比题目要求大不过没关系）
 *         再通过if语句设置区间范围为题目要求的范围 超出题目要求范围的就重做
 */

public class OneToSevenRandom {
    public static void main(String[] args) {
        System.out.println("test is beginning");

        int n = 8;
        int testTime = 10;
        int count = 0;
        int[] arr = new int[n];

        for (int i = 0; i < testTime; i++) {
            arr[f2()]++;
            //System.out.println(f2());
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i + " is " + arr[i] + " times");
        }

    }

    public static int f() {
        int x =(int)(Math.random() * 5) + 1;
        return x;
    }

    public static int f1() {
        int ret;
        do {
            ret = f();
        } while (f() == 3);

//        return ret < 3 ? 0 : 1;

        if (f() < 3) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int f2() {
        return ((f1() << 2) + (f1() << 1) + f1());
    }

    /**
     * 问题：函数f返回0的概率为p，返回1的概率为1-p，要求新函数g返回0和1的概率均且等为50%
     * 解法：做2次f函数，做出概率相等的两种情况，一种返回0，一种返回1
     *      第一次  第二次    处理      概率         返回值
     *      0       0       舍弃      p*p         重做2次f
     *      1       1       舍弃      (1-p)*(1-p) 重做2次f
     *      0       1       留下      p*(1-p)     返回0
     *      1       0       留下      p*(1-p)     返回1
     */

}
