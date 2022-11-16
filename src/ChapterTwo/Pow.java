package ChapterTwo;

public class Pow {
    public static long pow(long x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (isEven(n))
            return pow(x * x, n / 2);
        else
            return pow(x * x, n / 2) * x;
    }

    public static boolean isEven(int n) {
        if (n % 2 == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(pow(15,0));
    }
}
