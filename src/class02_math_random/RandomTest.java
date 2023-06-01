package class02_math_random;

import org.junit.Test;

public class RandomTest {
    /**
     * Math.random() 等概率返回[0,1)之间的double类型的小数
     * Math.random()*n n为int类型的正整数 则 Math.random()*n 等概率返回 n.xxx double类型的小数
     * (int)(Math.random()*n) 等概率返回[0, n - 1]之间的整数 注意：要在里面乘以n再转为int 不能先转int再乘n
     * (int)(Math.random()*n) + m 等概率返回[m, n]之间的整数
     */
    @Test
    public void EqualRandom() {
        System.out.println("test is beginning");

        int n = 11;
        int testTime = 10000;
        int count = 0;
        int[] arr = new int[11];

        for (int i = 0; i < testTime; i++) {
            int rand = (int)(Math.random() * n);
            arr[rand]++;
            count++;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(count);
        }

        System.out.println("test was over");
    }

    /**
     * Math.max(Math.random(), Math.random()) 以平方的概率返回[0,1)之间的double类型的小数
     * Math.max(Math.random(), Math.max(Math.random(),Math.random())) 以三次方的概率返回[0,1)之间的double类型的小数
     */
    @Test
    public void PowerRandom() {
        System.out.println("test is beginning");

        int n = 11;
        int testTime = 10000;
        double count = 0.0;
        double x = 0.8;
        for (int i = 0; i < testTime; i++) {
            //求两个随机行为中的最大值将其作为最终的随机数
            //设x为0.3 第一个Math.random()出现[0,0.3)的概率为0.3 第二个Math.random()出现[0,0.3)的概率为0.3 出现[0.3,1)的概率为0.7
            //所以我们统计随机数pow<0.3出现的概率为0.3 * 0.3
            //实现随机数返回[0,1)中x的概率为x的平方
            //想实现随机数返回[0,1)中x的概率为x的三次方 则调用两次max
            //double pow = Math.max(Math.random(), Math.max(Math.random(),Math.random()));
            double pow = Math.max(Math.random(), Math.random());
            if(pow < x) {
                count++;
            }
        }
        System.out.println(count/(double)testTime);
        System.out.println(Math.pow(x, 2));
        System.out.println("test was over");
    }

}