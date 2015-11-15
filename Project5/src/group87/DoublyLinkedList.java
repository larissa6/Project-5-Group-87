package group87;

/**
 * // -------------------------------------------------------------------------
/**
 *  A doubly linked list
 *
 *  @author Simone Stewart (simone5), Larissa Schneider (larissa6),
 * Tara Amruthur (taraa2)
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

    /**
     * Adds a node at a specific index.
     * @param entry The new data being added.
     * @param index The specific index.
     */
    public void addNodeAtIndex(E entry, int index)
    {
        if (entry == null) {
            throw new IllegalArgumentException();
        }
        Node<E> newNode = new Node<E>(entry);
        if (index == 0)
        {
            Node<E> nextNode = first;
            newNode.setNext(nextNode);
            nextNode.setPrevious(newNode);
            first = newNode;
        }
        else if (index == size)
        {
            Node<E> previousNode = last;
            newNode.setPrevious(previousNode);
            previousNode.setNext(newNode);
            last = newNode;
        }
        else
        {
            Node<E> previousNode = getNodeAtIndex(index - 1);
            Node<E> nextNode = getNodeAtIndex(index);
            previousNode.setNext(newNode);
            newNode.setPrevious(previousNode);
            nextNode.setPrevious(newNode);
            newNode.setNext(nextNode);
        }
        size++;
    }

    /**
     * Adds an entry to the end of the list
     * @param entry the new data being added to the list
     */
    public void add(E entry) {
        addNodeAtIndex(entry, size);
    }

    /**
     * removes an entry at a given index
     * @param index the position in the list the entry to remove is located
     * @return the data at the given position
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        return current.getData();
    }

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
