package fr.inria.bench;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by marodrig on 04/12/2015.
 */
public class Example1Test {

    @org.junit.Test
    public void testAppendSorted() throws Exception {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(100);
        al.add(8);
        Example1 ex = new Example1();
        ex.appendSorted(al, 99);
        assertEquals(4, al.size());
        assertEquals(1, (int) al.get(0));
    }

    @org.junit.Test
    public void testAccumulateAbsUntil3Pi() throws Exception {
        Example1 ex = new Example1();
        ex.accumulateAbsUntil3Pi(Math.PI / 4);
        assertEquals("Incorrect", 0.8604245230772071, ex.getSinSum(), 0.0001);
    }

    @org.junit.Test
    public void testDefaultMultiplication() throws Exception {
        Example1 ex = new Example1();
        double c = ex.defaultMultiplication(4, 5);
        assertEquals("Incorrect", c, 20, 0.00001);
    }
}