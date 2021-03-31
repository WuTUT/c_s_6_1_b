package synthesizer;


import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        this.capacity = capacity;
        first = 0;
        last = 0;
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

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (capacity == fillCount) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        fillCount++;
        rb[last] = x;
        last++;
        if (last == capacity) {
            last = 0;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (this.fillCount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        fillCount--;
        T ret = rb[first];
        first++;
        if (first == capacity) {
            first = 0;
        }
        return ret;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (this.fillCount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        return rb[first];
    }

    private class ArrayBufferIterator implements Iterator<T> {
        private int curPos;

        ArrayBufferIterator() {
            curPos = first;
        }

        @Override
        public boolean hasNext() {
            return curPos < last;
        }

        @Override
        public T next() {
            T ret = rb[curPos];
            curPos++;
            if (curPos == capacity) {
                curPos = 0;
            }
            return ret;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayBufferIterator();
    }
}
