import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    static ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

    @Test
    public void testAdd() {
        arrayDeque.addFirst(1);
        arrayDeque.addFirst(2);
        arrayDeque.addFirst(3);
        arrayDeque.addFirst(4);
        arrayDeque.addFirst(5);
        arrayDeque.printDeque();
        arrayDeque.addLast(6);
        arrayDeque.addLast(7);
        assertEquals(Integer.valueOf(5), arrayDeque.removeFirst());
        assertEquals(Integer.valueOf(7), arrayDeque.removeLast());
        assertEquals(Integer.valueOf(4), arrayDeque.removeFirst());
        assertEquals(Integer.valueOf(3), arrayDeque.removeFirst());
        assertEquals(Integer.valueOf(6), arrayDeque.removeLast());
        arrayDeque.printDeque();
    }

    @Test
    public void testMoveOne() {
        for (int i = 0; i < 20; i++) {
            arrayDeque.addLast(i);
            assertEquals(1, arrayDeque.size());
            assertEquals(Integer.valueOf(i), arrayDeque.get(0));
            arrayDeque.removeFirst();
            assertEquals(0, arrayDeque.size());
        }
    }

    @Test
    public void testMoveTwo() {
        for (int i = 0; i < 20; i++) {
            arrayDeque.addLast(i);
            arrayDeque.addFirst(i - 1);
            assertEquals(2, arrayDeque.size());
            assertEquals(Integer.valueOf(i - 1), arrayDeque.get(0));
            assertEquals(false, arrayDeque.isEmpty());
            assertEquals(Integer.valueOf(i), arrayDeque.get(1));
            //arrayDeque.printDeque();
            arrayDeque.removeFirst();
            arrayDeque.removeFirst();
            assertEquals(0, arrayDeque.size());
            assertEquals(true, arrayDeque.isEmpty());
        }
    }

    @Test
    public void testResize() {
        for (int i = 0; i < 15; i++) {
            arrayDeque.addFirst(i);
            arrayDeque.addFirst(i);
            arrayDeque.removeLast();
            arrayDeque.removeLast();
            arrayDeque.addFirst(i);
        }
        arrayDeque.printDeque();
    }

    @Test
    public void testResize2() {
        for (int i = 0; i < 40; i++) {
            arrayDeque.addFirst(i);
        }
        for (int i = 0; i < 35; i++) {
            arrayDeque.removeLast();
        }
        arrayDeque.printDeque();
    }
}
