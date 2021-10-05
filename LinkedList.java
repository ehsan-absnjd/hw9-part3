package third;

public class LinkedList <T> {
    private int size=0;
    private Node<T> first;
    private Node<T> last;

    public void printValues(){
        System.out.print("{ ");
        Node<T> node = first;
        while(node !=null){
            System.out.print(node.value);
            node=node.next;
        }
        System.out.println(" }");
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
