package group87;

/**
 * // -------------------------------------------------------------------------
/**
 *  A doubly linked list
 *
 *  @author Simone Stewart (simone5)
 *  @version 2015.11.15
 *  @param <E> the data type for the list
 */
public class DoublyLinkedList<E>
{
    //Fields ------------------------------------------------------------------
    private int size;
    private Node<E> first;
    private Node<E> last;

    //Constructor -------------------------------------------------------------
    /**
     * Create a new DLList object.
     */
    public DoublyLinkedList() {
        first = new DoublyLinkedList.Node<E>(null);
        last = new DoublyLinkedList.Node<E>(null);
        first.setNext(last);
        last.setPrevious(first);
        size = 0;
    }

    //Methods -----------------------------------------------------------------
    /**
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Empties the list
     */
    public void clear() {
        first = new DoublyLinkedList.Node<E>(null);
        last = new DoublyLinkedList.Node<E>(null);
        first.setNext(last);
        last.setPrevious(first);
        size = 0;
    }

    /**
     * Checks the list for an object
     * @param object the entry being searched for
     * @return true if it is found in the lsit
     */
    public boolean contains(E object) {
        Node<E> current = first;
        for (int i = 0; i < size(); i++) {
            if (current.getData().equals(object)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Adds an entry to the end of the list
     * @param entry the new data being added to the list
     */
    public void add(E entry) {
        if (entry == null) {
            throw new IllegalArgumentException();
        }
        //TODO I think there are some issues here
        Node<E> newNode = new Node<E>(entry);
        newNode.setPrevious(last);
        newNode.setNext(new DoublyLinkedList.Node<E>(null));
        last.setNext(newNode);
        size++;
    }

    /**
     * Gets a node at a specified position in the list
     * @param index the position in the list to get a node
     * @return the node at that position
     */
    private Node<E> getNodeAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = first.getNext();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }

    /**
     * Returns the data at a specific index
     * @param index the position in the list to get the data from
     * @return the data at that position
     */
    public E get(int index) {
        return getNodeAtIndex(index).getData();
    }

    //I didn't add a remove function because I don't think we'll be removing
    //anything but I can add one pretty easily if we need one

    /**
     * // -------------------------------------------------------------------------
    /**
     *  Nodes store data in the list and have pointers to the previous and
     *  next nodes
     *  @param <E>
     *
     *  @author Simone Stewart (simone5)
     *  @version Nov 15, 2015
     */
    private static class Node<E> {
        //Fields --------------------------------------------------------------
        private Node<E> next;
        private Node<E> previous;
        private E data;

        //Constructor ---------------------------------------------------------
        /**
         * Creates a new Node
         * @param data the data stored in the node
         */
        public Node(E data) {
            this.data = data;
        }

        //Methods -------------------------------------------------------------
        /**
         * Sets the next node
         * @param node the node set as next
         */
        public void setNext(Node<E> node) {
            next = node;
        }

        /**
         * Sets the previous node
         * @param node the node set as previous
         */
        public void setPrevious(Node<E> node) {
            previous = node;
        }

        /**
         * @return the next node
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * @return the previous node
         */
        public Node<E> getPrevious() {
            return previous;
        }

        /**
         * @return the data in a node
         */
        public E getData() {
            return data;
        }
    }
}
