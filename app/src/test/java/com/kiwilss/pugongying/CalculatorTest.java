package com.kiwilss.pugongying;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


/**
 * FileName: CalculatorTest
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/10/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class CalculatorTest {

    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @Test
    public void sum() {
        assertEquals(6d, mCalculator.sum(1d, 5d), 0);
    }

    @Test
    public void substract() {
        assertEquals(1d, mCalculator.substract(5d, 4d), 0);
    }

    @Test
    public void divide() {
        assertEquals(4d, mCalculator.divide(20d, 5d), 0);
    }

    @Test
    public void multiply() {
        double multiply = mCalculator.multiply(2d, 5d);
        System.out.println(multiply);
        assertEquals(10d, mCalculator.multiply(2d, 5d), 0);
    }
}