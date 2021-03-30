public class ArrayDeque<T> {
    private int tail;
    private int head;
    private T[] items;

    public ArrayDeque() {
        tail = 1;
        head = 0;
        items = (T[]) new Object[8];
    }

    public T get(int index) {
        return (T) items[(index + head + 1) % items.length];
    }

    public int size() {
        return (tail + items.length - head - 1) % items.length;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int prevSize = size();
        int copyStart = addOne(head);
        if (head == tail) {
            int len = (items.length - copyStart) % items.length;
            System.arraycopy(items, copyStart, a, 0, len);
            System.arraycopy(items, 0, a, len, prevSize - len);
        } else if (head < tail) {
            System.arraycopy(items, copyStart, a, 0, prevSize);
        } else {
            int len = (items.length - copyStart) % items.length;
            System.arraycopy(items, copyStart, a, 0, len);
            System.arraycopy(items, 0, a, len, prevSize - len);
        }
        items = a;
        head = minusOne(0);
        tail = prevSize;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    private int minusOne(int val) {
        val--;
        if (val == -1) {
            val = items.length - 1;
        }
        return val;
    }

    private int addOne(int val) {
        val++;
        if (val == items.length) {
            val = 0;
        }
        return val;
    }

    public void printDeque() {
        for (int i = addOne(head); i != tail; i = addOne(i)) {
            System.out.print(items[i].toString() + " ");
        }
        System.out.println();
    }

    public void addFirst(T item) {
        if (head == tail) {
            resize(size() * 2);
        }
        items[head] = item;
        head = minusOne(head);
    }

    public void addLast(T item) {
        if (head == tail) {
            resize(size() * 2);
        }
        items[tail] = item;
        tail = addOne(tail);
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        head = addOne(head);
        T ret = items[head];
        int size = size();
        if (items.length >= 16 && (double) size / items.length < 0.25) {
            resize(size * 2);
        }
        return ret;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        tail = minusOne(tail);
        T ret = items[tail];
        int size = size();
        if (items.length >= 16 && (double) size / items.length < 0.25) {
            resize(size * 2);
        }
        return ret;
    }
}
