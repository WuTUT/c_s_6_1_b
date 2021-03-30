public class ArrayDeque<T> implements Deque<T> {
    private int tail;
    private int head;
    private T[] items;

    public ArrayDeque() {
        tail = 1;
        head = 0;
        items = (T[]) new Object[8];
    }

    public ArrayDeque(ArrayDeque other) {

    }

    @Override
    public T get(int index) {
        return (T) items[(index + head + 1) % items.length];
    }

    @Override
    public int size() {
        return (tail + items.length - head - 1) % items.length;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (tail > head) {
            System.arraycopy(items, addOne(head), a, 0, size());
        } else {
            System.arraycopy(items, addOne(head), a, 0, items.length - head - 1);
            // if(minusOne(tail)<items.length)
            // System.arraycopy(items,minusOne(tail),a,items.length-head);
        }
        items = a;
    }

    @Override
    public boolean isEmpty() {
        if (head < tail && (tail - head == 1)) {
            return true;
        }
        return false;
    }

    private int minusOne(int head) {
        head--;
        if (head == -1) {
            head = items.length - 1;
        }
        return head;
    }

    private int addOne(int tail) {
        tail++;
        if (tail == items.length) {
            tail = 0;
        }
        return tail;
    }

    @Override
    public void printDeque() {
        for (int i = addOne(head); i != tail; i = addOne(i)) {
            System.out.println(items[i].toString() + " ");
        }
    }

    @Override
    public void addFirst(T item) {
        items[head] = item;
        head = minusOne(head);
    }

    @Override
    public void addLast(T item) {
        items[tail] = item;
        tail = addOne(tail);
    }

    @Override
    public T removeFirst() {
        head = addOne(head);
        T ret = items[head];
        return ret;
    }

    @Override
    public T removeLast() {
        tail = minusOne(tail);
        T ret = items[tail];
        return ret;
    }
}
