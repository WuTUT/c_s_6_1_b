public class LinkedListDeque<T> {
    public static class QueueNode<T> {
        T value;
        QueueNode prev;
        QueueNode next;

        public QueueNode() {
            prev = null;
            next = null;
        }

        public QueueNode(T item) {
            prev = null;
            next = null;
            value = item;
        }
    }

    private int size;
    private QueueNode sentinel;

    public LinkedListDeque() {
        sentinel = new QueueNode();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other) {
        this.size = other.size();
    }


    public void addFirst(T item) {
        QueueNode firstNode = sentinel.next;
        QueueNode tmpNode = new QueueNode(item);

        sentinel.next = tmpNode;
        tmpNode.prev = sentinel;

        tmpNode.next = firstNode;
        firstNode.prev = tmpNode;

        size++;
    }

    public void addLast(T item) {
        QueueNode lastNode = sentinel.prev;
        QueueNode tmpNode = new QueueNode(item);

        tmpNode.next = sentinel;
        sentinel.prev = tmpNode;

        lastNode.next = tmpNode;
        tmpNode.prev = lastNode;

        size++;
    }

    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        QueueNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.value.toString() + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        QueueNode firstNode = sentinel.next;
        QueueNode nextNode = firstNode.next;

        sentinel.next = nextNode;
        nextNode.prev = sentinel;

        size--;

        return (T) firstNode.value;
    }

    public T removeLast() {
        QueueNode lastNode = sentinel.prev;
        QueueNode lastLastNode = lastNode.prev;

        sentinel.prev = lastLastNode;
        lastLastNode.next = sentinel;

        size--;

        return (T) lastNode.value;
    }

    public T get(int index) {
        QueueNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return (T) p.value;
    }

    private T getRecursive(QueueNode p, int index) {
        if (index < 0) {
            return null;
        }
        if (index == 0) {
            return (T) p.value;
        }
        return getRecursive(p.next, index - 1);
    }

    public T getRecursive(int index) {
        return getRecursive(sentinel.next, index);
    }
}
