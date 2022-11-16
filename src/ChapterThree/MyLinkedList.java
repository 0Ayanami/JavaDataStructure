package ChapterThree;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList <AnyType> implements Iterable<AnyType>{
    private static class Node<AnyType>
    {
        public Node(AnyType d,Node<AnyType> p,Node<AnyType> n)
        {data = d;prev = p; next = n;}
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;
    }
    public MyLinkedList(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    private void doClear() {
        beginMaker = new Node<AnyType>(null,null,null);
        endMaker = new Node<AnyType>(null,beginMaker,null);
        beginMaker.next=endMaker;

        theSize = 0;
        modCount++;
    }

    public int size(){
    return theSize;
    }
    public boolean isEmpty()
    {return size()==0;}

    public boolean add(AnyType x){
        add(size(),x);return true;
    }
    public void add (int idx,AnyType x){
        addBefore(getNode(idx,0,size()),x);
    }
    public AnyType get(int idx){
        return getNode(idx).data;
    }
    public AnyType set(int idx,AnyType newVal){
        Node<AnyType> p = getNode(idx);
        AnyType oldVal = p.data;
        p.data= newVal;
        return oldVal;
    }
    public AnyType remove(int idx){
        return remove(getNode(idx));
    }

    private void addBefore(Node<AnyType> p ,AnyType x){
        Node<AnyType> newNode = new Node<>(x,p.prev,p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }
    private AnyType remove(Node<AnyType> p){
        p.prev.next= p.next;
        p.next.prev=p.prev;
        theSize--;
        modCount++;
        return p.data;
    }
    private Node<AnyType> getNode(int idx){
        return getNode(idx,0,size()-1);
    }
    private Node<AnyType> getNode(int idx,int lower,int upper){
        Node<AnyType> p ;
        if(idx<lower||idx>upper)
            throw new IndexOutOfBoundsException();

        if(idx<size()/2){
            p=beginMaker.next;
            for(int i=0;i<idx;i++)
                p=p.next;
        }
        else{
            p=endMaker;
            for (int i = size(); i > idx; i--) {
                p=p.prev;
            }
        }
        return p;
    }
    public Iterator<AnyType> iterator(){

        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<AnyType>{
        private Node<AnyType> current = beginMaker.next;
        private int expectedModCount = modCount;
        private boolean okToremove = false;

        public boolean hasNext(){
            return current != endMaker;
        }

        public AnyType next(){
            if(modCount != expectedModCount)
                throw new java.util.ConcurrentModificationException();
            if(!hasNext())
                throw new java.util.NoSuchElementException();

            AnyType nextItem = current.data;
            current=current.next;
            okToremove=true;
            return nextItem;
        }

        public void remove(){
            if(modCount!=modCount)
                throw new java.util.ConcurrentModificationException();
            if(!okToremove)
                throw new NoSuchElementException();

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToremove=false;
        }
    }
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMaker;
    private Node<AnyType> endMaker;


}
