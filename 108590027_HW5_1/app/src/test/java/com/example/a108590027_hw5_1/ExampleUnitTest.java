package com.example.a108590027_hw5_1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Calculator mCalc = new Calculator();
    @Test
    public void add_isCorrect() {
        //assertEquals(4, 2 + 2);
        double result = mCalc.add(1.111f, 1.111d);
        assertEquals(result, 2.222d, 0.005);
    }
    @Test
    public void sub_isCorrect() {
        double result = mCalc.sub(1.5f, 0.9d);
        assertEquals(result, 0.6d, 0.005);
    }
    @Test
    public void div_isCorrect() {
        double result = mCalc.div(50d, 25d);
        assertEquals(result, 2d, 0.005);
    }
    @Test
    public void mul_isCorrect() {
        double result = mCalc.mul(1.5f, 1.5d);
        assertEquals(result, 2.25d, 0.005);
    }
    @Test
    public void power_isCorrect() {
        double result = mCalc.power(2, 5);
        assertEquals(result, 32d, 0.005);
    }
    @Test
    public void power_isCorrect_2() {
        double result = mCalc.power(625, 0.5d);
        assertEquals(result, 25d, 0.005);
    }

    @Test
    public void power_isCorrect_3() {
        double result = mCalc.power(625, -1d);
        assertEquals(result, (1/625), 0.005);
    }
    //----------------------------------------------------
    @Test
    public void powTest_posInteger() {
        double a = 10, b = 2;
        double result = mCalc.power(a, b);
        assertEquals(result, 100d, 0.005);
    }
    @Test
    public void powTest_negInteger_1() {
        double a = -10, b = 3;
        double result = mCalc.power(a, b);
        assertEquals(result, -1000d, 0.005);
    }
    @Test
    public void powTest_negInteger_2() {
        double a = 10, b = -3;
        double result = mCalc.power(a, b);
        assertEquals(result, (1/1000), 0.005);
    }
    @Test
    public void powTest_zero_1() {
        double a = 0, b = 3;
        double result = mCalc.power(a, b);
        assertEquals(result, 0d, 0.005);
    }
    @Test
    public void powTest_zero_2() {
        double a = 3, b = 0;
        double result = mCalc.power(a, b);
        assertEquals(result, 1d, 0.005);
    }
    @Test
    public void powTest_zero_3() {
        double a = 0, b = -1;
        double result = mCalc.power(a, b);
        assertEquals(result, Double.POSITIVE_INFINITY, 0.005);
    }
    @Test
    public void powTest_negZero() {
        double a = -0, b = -2;
        double result = mCalc.power(a, b);
        assertEquals(result, Double.POSITIVE_INFINITY, 0.005);
    }
}