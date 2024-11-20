package com.example.productservice.testdemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    /*
    1. syntax we need to follow for method name is
        when---then---
    2. when we write unit test we need to follow three A's
        Arrange
        Act
        Assert
    3. we need to test
        a. positive test case
        b. negative test case
        c. edge case
     */
    @Test
    void whenAddingTwoIntegersThenRightResultExcepted() {
        //1. Arrange
        int a=20;
        int b=20;
        Calculator c = new Calculator();

        // 2. Act
        int results=c.add(a,b);

        //3. Assert
        Assertions.assertEquals( 40,  results);


    }

    @Test
    void whenDivingTwoIntegersThenExceptionExcepted() {
        // 1. Arrange
        int a=30;
        int b=0;
        Calculator c = new Calculator();

        // 2. Act and assert
        Assertions.assertThrows(ArithmeticException.class, ()->c.div(a,b));

    }
}