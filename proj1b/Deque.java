public interface Deque<T> {
    public void addFirst(T item);

    public void addLast(T item);

    public boolean isEmpty();

    public int size();

    public void printDeque();

    public T removeLast();

    public T removeFirst();

    public T get(int index);
}