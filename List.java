
/**
 * A list holding elements of any reference type.
 *
 * <p>Homework 12 -- Dynamic Data Structures</p>
 *
 * @param <T> any reference type that implements {@code Comparable}.
 */
public class List<T extends Comparable<T>> {
    /**
     * Adds the specified value to the front of the list.
     *
     * @param value the value to be added to the front
     */
    private int numElements;
    private Node<T> start;

    // Constructor
    public List(){}

    public int getNumElements(){
        return this.numElements;
    }
    public void addFront(T value){
        if (this.start == null) {
            this.start = new Node<>(value);
        } else {
            this.start = new Node<>(value, this.start);
        } //end if

        this.numElements++;
    } //addFront

    /**
     * Adds the specified value to the end of the list.
     *
     * @param value the value to be added to the end
     */
    public void addEnd(T value) {
        if (this.start == null) {
            this.start = new Node<>(value);
        } else {
            Node<T> currentNode = this.start;

            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            } //end while

            currentNode.setNext(new Node<>(value));
        } //end if

        this.numElements++;
    } //addEnd

    public boolean addAfter(int index, T value){
        Node newNode = new Node(value);
        if (this.start == null || index > numElements || index < 1){
            return false;
        }else {
            Node prev = this.start;
            int count = 0;
            while (count < index - 1){
                prev = prev.getNext();
                count++;
            }
            Node curr = prev.getNext();
            newNode.setNext(curr);
            prev.setNext(newNode);
            this.numElements++;
            return true;
        }
    }

    public boolean deleteNode(T value){
        // added final, change input to `searchValue`
            Node tmpNode = this.start;
            Node prevNode = null;
            boolean deletedANode = false;

            while (tmpNode != null) {
                if (tmpNode.getValue() == value) {
                    if (tmpNode == this.start) {
                        this.start = this.start.getNext();
                    } else { // fixed indenting/newline
                        prevNode.setNext(tmpNode.getNext());
                    }
                    // fixed indenting
                    this.numElements--;
                    deletedANode = true;
                } else {
                    // only advance the prevNode when there's no match.
                    prevNode = tmpNode;
                }
                tmpNode = tmpNode.getNext();
            }

            return deletedANode;

    }

    public int insertInPlace(T value){
        Node n = new Node(value);
        Node p = this.start;
        int index = 1;
        // Find the insertion point
        if(this.start == null){
            this.start.setValue(value);
            return -1;
        }else if (this.start.getValue().compareTo(value) < 0){
            n.setNext(p.getNext());
            p.setNext(n);
            return index;
        }else {
                while ((p.getNext() != null) && (p.getNext().getValue().compareTo(value) < 0)) {
                    p = p.getNext();
                    index++;
                }
                // Insert the node
                n.setNext(p.getNext());
                p.setNext(n);

                // Update the list length
                this.numElements++;
                return index;
        }
    }

    public String toString(){
        String result = "";
        Node current = this.start;
        while(current != null){
            result += current.getValue() + "->";
            current = current.getNext();
        }
        return result;
    }


    public static void main(String[] args) {
        List list = new List();
        list.addEnd(1);
        list.addEnd(2);
        list.addEnd(4);
        list.addEnd(5);
        System.out.println(list.insertInPlace(-1));
        System.out.println(list.toString());
        System.out.println(list.getNumElements());
    }
}