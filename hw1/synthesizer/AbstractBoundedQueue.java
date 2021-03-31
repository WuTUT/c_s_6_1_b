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
}
