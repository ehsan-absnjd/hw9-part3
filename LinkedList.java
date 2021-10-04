package third;

public class LinkedList <T> {
    private int size=0;
    private Node<T> first;
    private Node<T> last;


    public void addLast(T value){
        Node<T> node = new Node<>(value);
        if(isEmpty()){
            first=node;
            last=node;
            size++;
            return;
        }
        last.next=node;
        Node<T> tmp = last;
        last=node;
        node.previous = tmp;
        size++;
    }

    public void addFirst(T value){
        Node<T> node = new Node<>(value);
        if(isEmpty()){
            first=node;
            last=node;
            size++;
            return;
        }
        first.previous=node;
        Node<T> tmp = first;
        first=node;
        node.next=tmp;
        size++;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    private static class Node<T>{
        T value;
        Node<T> previous;
        Node<T> next;
        Node(T value){
            this.value = value;
        }
    }
}
