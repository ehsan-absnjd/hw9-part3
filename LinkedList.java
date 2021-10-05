package third;

import java.util.Iterator;

public class LinkedList <T> implements Iterable<T> {
    private int size=0;
    private Node<T> first;
    private Node<T> last;

    public void printValues(){
        System.out.print("{ ");
        Node<T> node = first;
        while(node !=null){
            System.out.print(node.value + " ");
            node=node.next;
        }
        System.out.println("}");
    }


    public void removeByValue(T value){
        Node<T> node = first;
        while(node !=null){
            if(node.value.equals(value))
                remove(node);
            node=node.next;
        }
    }

    public void removeByIndex(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        Node<T> node = getNodeByIndex(index);
        remove(node);
    }

    private void remove(Node<T> node){
        if(size==1){
            first=last=null;
            size--;
            return;
        }
        Node<T> prev = node.previous;
        Node<T> next = node.next;
        if(prev !=null && next !=null){
            prev.next = next;
            next.previous=prev;
            size--;
        }else if(prev == null){
            next.previous=null;
            size--;
        }else{
            prev.next=null;
            size--;
        }
    }


    private Node<T> getNodeByIndex(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException();
        if (index >= size / 2) {
            int diff = size - index;
            Node<T> node = last;
            for (int i = 1; i < diff; i++){
                node= node.previous;
            }
            return node;
        }else{
            Node<T> node = first;
            for (int i = 0; i < index; i++){
                node= node.next;
            }
            return node;
        }

    }

    private boolean contains(T value){
        if(getIndexOf(value)==-1)
            return false;
        return true;
    }

    public int getIndexOf(T value){
        Node<T> node = first;
        int index = 0;
        while(node !=null){
            if(node.value.equals(value))
                return index;
            node=node.next;
            index++;
        }
        return -1;
    }

    public T getByIndex(int index) {
        return getNodeByIndex(index).value;
    }


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

    public void addAtIndex(int index , T value){
        if(index<0 || index>size ){
            throw new IllegalArgumentException();
        }
        if (index==0) {
            addFirst(value);
            return;
        }
        if ( index == size){
            addLast(value);
            return;
        }
        Node<T> node = new Node<>(value);
        Node<T> atIndex = getNodeByIndex(index);
        node.previous = atIndex.previous;
        node.next=atIndex;
        atIndex.previous=node;
        size++;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> node = first;
            @Override
            public boolean hasNext() {
                if(node!=null)
                    return true;
                else
                    return false;
            }

            @Override
            public T next() {
                T value = node.value;
                node=node.next;
                return value;
            }
        };
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
