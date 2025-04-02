import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{
    private class Node{
        Node last;
        Node next;
        T value;

        public Node(){}

        public Node(Node last, Node next, T value){
            this.next = next;
            this.last = last;
            this.value = value;
        }
    }

    private Node sentinel;
    private int size;
    private Node getNode;

    public LinkedListDeque61B(){
        sentinel = new Node();
        sentinel.value = null;
        sentinel.next = sentinel;
        sentinel.last = sentinel;

        getNode = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node(sentinel, sentinel.next, x);

        sentinel.next.last = newNode;
        sentinel.next = newNode;

        size++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(sentinel.last, sentinel, x);

        sentinel.last.next = newNode;
        sentinel.last = newNode;

        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node node = sentinel.next;
        while (node != sentinel){
            returnList.add(node.value);
            node = node.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if(sentinel.next == sentinel){
            return null;
        }

        T temp = sentinel.next.value;
        sentinel.next = sentinel.next.next;
        sentinel.next.last = sentinel;

        size--;
        return temp;
    }

    @Override
    public T removeLast() {
        if(sentinel.next == sentinel){
            return null;
        }

        T temp = sentinel.last.value;
        sentinel.last = sentinel.last.last;
        sentinel.last.next = sentinel;

        size--;
        return temp;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size){
            return null;
        }

        Node node = sentinel.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public T getRecursive(int index) {
        if(index < 0 || index >= size){
            return null;
        }

        if(index == 0){
            return getNode.next.value;
        }else {
            getNode = getNode.next;
        }

        return getRecursive(index-1);
    }
}
