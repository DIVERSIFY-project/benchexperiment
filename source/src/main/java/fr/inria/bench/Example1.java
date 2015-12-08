package fr.inria.bench;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.regex.Matcher;

/**
 * Example class to use as source for experiments with AutoJMH.
 * <p/>
 * Created by marodrig on 04/12/2015.
 */
public class Example1 {

    double sinSum = 0;

    public double getSinSum() {
        return sinSum;
    }

    public void setSinSum(int sinSum) {
        this.sinSum = sinSum;
    }

    /**
     * A addition for a function
     * <p/>
     * @param c
     */
    public void addFunction(MyFunction c) {
        if (c == null) c = new FunA();

        /** @bench-this */
        for (int i = 0; i < 100; i++) {
            sinSum += c.calc(i);
        }
        /** @until-here */

        final double w = PI;

        /** @bench-this */
        MyFunction f = new MyFunction() {
            public double calc(double x) {
                return Math.log(w) * x;
            }
        };
        sinSum += f.calc(sinSum);
        /** @until-here */


    }

    /**
     * A method that appends an integer to the array and then returns the array sorted.
     *
     * @param a
     */
    public void appendSorted(ArrayList<Integer> a, int value) {

        //Here we want to know the time it takes to add one value

        /** @bench-this */
        a.add(value);
        /** @until-here */


        //Here we want to know the time it takes to sort the list.

        /** @bench-this */
        a.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        /** @until-here */
    }

    private static double PI = Math.PI * 3;

    private static double SIN_PI = Math.sin(PI);

    /**
     * This method receives an angle and accumulates the result in sumResult
     * until it goes reaches out the first quadrant.
     */
    public void accumulateAbsUntil3Pi(double angle) {
        if (sinSum >= SIN_PI) return;
        else {
            double y = angle;
            angle = angle + sinSum * 0.0000001;

            /** @bench-this */
            angle += Math.abs(Math.sin(y)) / PI;
            /** @until-here */

            sinSum = angle;
        }
    }

    /**
     * A multiplication with default parameters
     *
     * @param x
     * @param y
     * @return
     */
    public double defaultMultiplication(double x, double y) {
        x = Math.abs(x) < 0.0000001 ? 1.00 : x;
        y = Math.abs(y) < 0.0000001 ? 1.00 : y;

        /** @bench-this */
        double c = x * y;
        /** @until-here */

        if (c > 0) return c;
        else return 0.0;
    }
}
