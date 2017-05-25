package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        logger.debug("settint values in constructor");
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args) {

    }

    public void calculateAndSetValue3(long value) {
        logger.trace("creating Solution object with values {value1 = " + value1 + ", value2 = " + value2 + ", value3 = " + value3 + "}");
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("value1 chaning to value / Integer.MAX_VALUE = " + value1);
        } else {
            value1 = (int) value;
            logger.debug("value1 changing to value " + value1);
        }
    }

    public void printString() {
        logger.trace("printing string " + value2);
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("printing date " + value3);
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("dividing " + number1 + " / " + number2 + " & printing result");
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("ERROR " + e.getMessage());
        }
    }

    public void setValue1(int value1) {
        this.value1 = value1;
        logger.debug("value1 seting as " + value1);
    }

    public void setValue2(String value2) {
        this.value2 = value2;
        logger.debug("value2 seting as " + value2);
    }

    public void setValue3(Date value3) {
        this.value3 = value3;
        logger.debug("value3 seting as " + value3);
    }
}