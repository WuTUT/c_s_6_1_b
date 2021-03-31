package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;

    /**
     * return the capacity of the Bounded Queue
     *
     * @return
     */
    public int capacity() {
        return capacity;
    }

    /**
     * return the fill Count of the Bounded Queue
     *
     * @return
     */
    public int fillCount() {
        return fillCount;
    }

    /**
     * return the queue is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return fillCount == 0;
    }

    /**
     * return the queue is full
     *
     * @return
     */
    public boolean isFull() {
        return fillCount == capacity;
    }

    public abstract T peek();

    public abstract T dequeue();

    public abstract void enqueue(T x);
}
