package synthesizer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer>(10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        for (Integer i : arb) {
            System.out.println(i);
        }
        for (int i = 4; i <= 10; i++) {
            arb.enqueue(i);
        }
        for (Integer i : arb) {
            System.out.println(i);
        }
        assertTrue(arb.isFull());
        assertFalse(arb.isEmpty());
        for (int i = 0; i < 10; i++) {
            arb.dequeue();
        }
        assertTrue(arb.isEmpty());
        assertFalse(arb.isFull());
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }
        for (int i = 0; i < 200; i++) {
            arb.dequeue();
            arb.enqueue(i);
        }
    }

    /**
     * Calls tests for ArrayRingBuffer.
     */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
