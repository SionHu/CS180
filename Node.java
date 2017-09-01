/**
 * Created by apple on 21/04/2017.
 */
public class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> next;

    public Node(T value, Node<T> next){
        this.value = value;
        this.next = next;
    }

    public Node(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setValue(T value){
        this.value = value;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }
}
