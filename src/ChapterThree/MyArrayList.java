package ChapterThree;

import org.omg.CORBA.Any;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
    public static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private AnyType[] theItems;

    public MyArrayList() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    public AnyType set(int idx, AnyType newVal) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        AnyType old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size())
            return;
        AnyType[] old = theItems; //用old存储原始数组的数据
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];//拷贝数据到扩充容量的新数组中
        }
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }//添加的表的末端

    public void add(int idx, AnyType x) {
        if (theItems.length == size())
            ensureCapacity(size() * 2 + 1);
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];//各个元素向后移动一位
        }
        theItems[idx] = x;
        theSize++;
    }

    public AnyType remove(int idx) {
        AnyType removeItem = theItems[idx];
        for (int i = idx; i < size(); i++)
            theItems[i] = theItems[i + 1];//各个元素向前移动一位
        theSize--;
        return removeItem;
    }

    public java.util.Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<AnyType> {
        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public AnyType next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            return theItems[current++];
        }

        public void remove() {
            MyArrayList.this.remove(--current);
        }

    }//将ArrayListIterator放在MYArrayList内部使得在内部类中可以使用外部类的theItems
}
