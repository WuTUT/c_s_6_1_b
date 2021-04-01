package hw3.hash;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class TestComplexOomage {

    @Test
    public void testHashCodeDeterministic() {
        ComplexOomage so = ComplexOomage.randomComplexOomage();
        int hashCode = so.hashCode();
        for (int i = 0; i < 100; i += 1) {
            assertEquals(hashCode, so.hashCode());
        }
    }

    /* This should pass if your OomageTestUtility.haveNiceHashCodeSpread
       is correct. This is true even though our given ComplexOomage class
       has a flawed hashCode. */
    @Test
    public void testRandomOomagesHashCodeSpread() {
        List<Oomage> oomages = new ArrayList<>();
        int N = 10000;

        for (int i = 0; i < N; i += 1) {
            oomages.add(ComplexOomage.randomComplexOomage());
        }

        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(oomages, 10));
    }

    /*  Create a list of Complex Oomages called deadlyList
     * that shows the flaw in the hashCode function.
     */

    @Test
    public void testWithDeadlyParams() {
        List<Oomage> deadlyList = new ArrayList<>();

        // Your code here.
        for (int i = 0; i <= 15; i++) {
            ArrayList<Integer> param1 = new ArrayList<>();
            ArrayList<Integer> param2 = new ArrayList<>();
            for (int j = 0; j <= 10; j++) {
                for (int k = 0; k <= 10; k++) {
                    for (int l = 0; l <= 10; l++) {
                        param1.add(i);
                        param1.add(j);
                        param1.add(k);
                        param1.add(l);
                        param1.add(0);

                        param2.add(0);
                        param2.add(j);
                        param2.add(k);
                        param2.add(l);
                        param2.add(i);
                    }
                }
            }
            deadlyList.add(new ComplexOomage(param1));
            deadlyList.add(new ComplexOomage(param2));
        }
        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(deadlyList, 10));
    }

    /**
     * Calls tests for SimpleOomage.
     */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestComplexOomage.class);
    }
}
