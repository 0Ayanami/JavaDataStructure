package ChapterTwo;
//寻找最大子序列
public class MaxSumRec {
    public static void main(String[] args) {
        int [] a = {4,-3,5,-2,-1,2,6,-2};
        System.out.println(maxSumRec(a,0,a.length-1));
    }
    private static int maxSumRec(int[] a, int left, int right) {
        if (left == right)    //左右相等，则数组中只有一个数字。
            if (a[left] > 0)
                return a[left];
            else
                return 0;

        int center = (left + right) / 2;
        int maxLeftSum = maxSumRec(a, left, center);//利用递归求出左半部分最大子序列
        int maxRightSum = maxSumRec(a, center + 1, right);//同上

        int LeftBorderSum = 0, MaxLeftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            LeftBorderSum += a[i];
            if (LeftBorderSum > MaxLeftBorderSum)
                MaxLeftBorderSum = LeftBorderSum;
        }//求出到左边界子序列和

        int RightBorderSum = 0, MaxRightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            RightBorderSum += a[i];
            if(RightBorderSum > MaxRightBorderSum)
                MaxRightBorderSum = RightBorderSum;
        }//求出从右边界子序列和

        return max3(maxLeftSum,maxRightSum,MaxLeftBorderSum+MaxRightBorderSum);

    }

    private static int max3(int a, int b,int c) {
        if(a>=b&&a>=c)
            return a;
        else if (b>a&&b>=c)
            return b;
        else
            return c;
    }
}
