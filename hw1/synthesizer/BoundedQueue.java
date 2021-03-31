package synthesizer;

public interface BoundedQueue<T> extends Iterable<T> {
    int capacity();     // return size of the buffer

    int fillCount();    // return number of items currently in the buffer

    void enqueue(T x);  // add item x to the end

    T dequeue();        // delete and return item from the front

    T peek();           // return (but do not delete) item from the front

    /**
     * return true if the bounded queue is empty or false
     *
     * @return
     */
    default boolean isEmpty() {
        return true;
    }

    /**
     * return true if the bounded queue is full or false
     *
     * @return
     */
    default boolean isFull() {
        return false;
    }
}
