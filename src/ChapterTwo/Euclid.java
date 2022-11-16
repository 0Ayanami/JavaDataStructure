package ChapterTwo;

public class Euclid {
    public static long gcd(long m, long n) {
        while(n!=0){
            long rem = m % n;
            m=n;
            n=rem;
        }
    return m;
    }

    public static void main(String[] args) {
        System.out.println(gcd(2000,7800));
    }
}
