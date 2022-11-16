package ChapterTwo;

public class MaxSumRecPro {
    public static void main(String[] args) {
        int [] a ={4,-3,5,-2,-1,2,6,-2};
        System.out.println(maxSubSumPro(a));
    }
    public static int maxSubSumPro(int a[]) {
        int maxSum = 0;
        int thisSum = 0;
        for (int j = 0; j < a.length; j++) {
            thisSum += a[j];
            if (thisSum >= maxSum)
                maxSum = thisSum;
            else if (thisSum < 0)
                thisSum = 0;
        }
    return maxSum;
    }
}
