package ChapterThree.Pra;
//设线性表A=(a1, a2,…,am)，B=(b1, b2,…,bn)，试写一个按下列规则合并A、B为线性表C的算法，使得：
//        C= (a1, b1,…,am, bm, bm+1, …,bn) 当m≤n时；
//        C= (a1, b1,…,an, bn, an+1, …,am) 当m>n时。
//        线性表A、B、C均以单链表作为存储结构，且C表利用A表和B表中的结点空间构成。

//        输入的第一行表示测试数据的组数T，后面跟着T组输入,每组测试数据占三行。
//        测试数据的第一行有两个正整数，分别为链表A和B的长度lenA,lenB(1 <= lenA, lenB <= 1000)。
//        链表内的元素为ai,bj （-10000<= ai, bj <=10000）。
//        测试数据的后两行分别是链表A和B。

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class OJ2747 {
    public static void main(String[] args) {

        //建立两个链表
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for(int j =0;j<T;j++){
            int lenA = scanner.nextInt(), lenB = scanner.nextInt();
            LinkedList listA = new LinkedList<Integer>();
            LinkedList listB = new LinkedList<Integer>();
            for (int i = 0; i < lenA; i++) {
                listA.add(scanner.nextInt());
            }

            for (int i = 0; i < lenB; i++) {
                listB.add(scanner.nextInt());
            }

            LinkedList listC = new LinkedList<Integer>();
            listC = mergeList(listA,listB);
            for (Object o : listC)
                System.out.print(o+" ");
            System.out.println();
        }
    }

    public static LinkedList<Integer> mergeList(LinkedList<Integer> list1,LinkedList<Integer> list2){
        int len1 = list1.size();
        int len2 = list2.size();

        if(len1>=len2){
            for (int i = 0; i < len2; i++) {
                list1.add(2*i+1,list2.get(i));
            }
            return list1;
        }
        else{
            for(int i=0;i<len1;i++)
                list2.add(2*i,list1.get(i));
            return list2;
        }
    }

}
