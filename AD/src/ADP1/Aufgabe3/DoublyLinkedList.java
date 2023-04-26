package ADP1.Aufgabe3;

import java.util.AbstractList;
import java.util.Collection;

public class DoublyLinkedList<T> extends AbstractList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = new Node<>(null, null, tail);
        tail = new Node<>(null, head, null);
        head.next=tail;
        size = 0;
    }

    public DoublyLinkedList(Collection<T> c) {
        this();
        addAll(c);
    }

    private class Node<T> {
        private T inhalt;
        Node<T> vor;
        Node<T> next;

        Node(T element, Node<T> vor, Node<T> next) {
            this.inhalt = element;
            this.vor = vor;
            this.next = next;
        }


        public void setInhalt(T inhalt) {
            this.inhalt = inhalt;
        }

        public T getInhalt() {
            return inhalt;


        }
    }


    @Override
    public T get(int index) {
        return (T) getNode(index).getInhalt();
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public void add(int index, T element) {
        checkIndex(index,size);
        Node lNode = getNode(index);
        Node nNode = new Node(element, lNode.vor, lNode);
        //Node lNodeNext = lNode.next;
        lNode.vor = nNode;
        nNode.vor.next = nNode;
        size++;
    }
/*

    @Override
    public void clear() {
        while (size() > 0) {
            remove(size() - 1);
        }
    }
*/

    /*
    @Override
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element, null, null);
        if (size == 0) {
            head.next = newNode;
            tail.vor = newNode;
            newNode.next = tail;
            newNode.vor = head;
            size++;
        } else {
            add(size-1, element);
        }

        return true;
    }
     */


    @Override
    public T remove(int index) {
        checkIndex(index,size-1);
        Node<T> temp = getNode(index);
        temp.vor.next = temp.next;
        temp.next.vor = temp.vor;
        size--;
        return temp.vor.getInhalt();
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index,size-1);
        getNode(index).setInhalt(element);
        return element;
    }

    public void checkIndex(int index, int max){
        if( index <0 || index > max) throw new IndexOutOfBoundsException();

    }

    private Node<T> getNode(int index) {
//        if (index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
//        }
        Node<T> temp;
        if (index <= size / 2) {
            temp = head.next;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size; i > index; i--) {
                temp = temp.vor;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);
        doublyLinkedList.add(6);
        doublyLinkedList.add(2,0);
        doublyLinkedList.remove(4);
        for (int i: doublyLinkedList) {
            System.out.println(i);
        }
    }
}