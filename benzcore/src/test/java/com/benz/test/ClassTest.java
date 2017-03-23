package com.benz.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zfg on 2017/3/23.
 */
public class ClassTest {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    public static void main(String[] args) {
        System.out.println("生活就是个炒蛋");
        ClassTest ct = new ClassTest();
        ct.printLog();
    }

    public void printLog() {
        logger.info("这是个Log");
    }
}
