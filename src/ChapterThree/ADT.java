package ChapterThree;
/*public interface Collection <AnyType> extends Iterable<AnyType>
 * {
 * int size;
 * boolean isEmpty();
 * void clear();x
 * boolean contains (AnyType x);
 * boolean add(AnyType x);
 * java.util.Iterator <AnyType> iterator();
 * }
 *
 * public static <AnyType> void print (Collection <AnyType> coll){
 * for(AnyType item : coll)
 * System.out.println(item);
 * }
 *
 * public interface Iterator <AnyType>{
 * boolean hasNext();
 * AnyType next();
 * void remove();
 * }
 *
 * public static <AnyType> void print(Collection <AnyType> coll){
 * Iterator<AnyType> itr = coll.iterator();
 * while(itr.hasNext()){
 * AnyType item = itr.next();
 * System.out.println(item);
 * }
 *
 * public interface List<AnyType> extends Colllection<AnyType>{
 * AnyType get(int idx);
 * AnyType set(int idx,AnyType newVal);
 * void add(int idx ,AnyType x);
 * void remove(int idx);
 * ListIterator<AnyType> listIterator(int pos);
 * }
 * */


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ADT {
    public static void main(String[] args) {
    }

    public static void makeList1(List<Integer> lst, int N) {
        lst.clear();
        for (int i = 0; i < N; i++) {
            lst.add(i);
        }
    }

    public static void makeList2(List<Integer> lst, int N) {
        lst.clear();
        for (int i = 0; i < N; i++) {
            lst.add(0, i);
        }
    }

    public static int sum(List<Integer> lst, int N) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            total += lst.get(i);
        }
        return total;
    }

    public static void removeEvenVer1(List<Integer> lst) {
        int i = 0;
        while (i < lst.size()) {
            if (lst.get(i) % 2 == 0)
                lst.remove(i);
            else
                i++;
        }
    }
    //对ArrayList低效，因为调用remove需要使用二次时间。而对于LikedList同样低效，因为get和remove都需要使用二次时间

    public static void removeEvenVer2(List<Integer> lst) {
        //使用迭代器
        for (Integer x : lst) {
            if (x % 2 == 0)
                lst.remove(x);
        }
    }
    //由增强for循环中，有的项被删除因此该程序是非法的

    public static void removeEvenVer3(List<Integer> lst) {
        Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext()) {
            if (itr.next() % 2 == 0)
                itr.remove();
        }
    }
    //使用迭代器找到一个偶数值，再用迭代器的remove删除这个值
    

}