package ChapterTwo;

public class BinarySearch {
    static int Not_Found = -1;
//compareTo 函数 正数为大于，负数为小于，返回值为0则相等
    public static <AnyType extends Comparable<? super AnyType>>
    int binarySearch(AnyType[] a, AnyType x) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else
                return mid;
        }
        return Not_Found;
    }

    public static void main(String[] args) {
        String [] str = {"Alice","Bob","Cathy","Dick","Evy","Furry"};
        System.out.println(binarySearch(str,"Bob"));
    }
}
