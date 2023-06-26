package com.example.helloservlet;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class ReflectionTests {

    @Test
    void objectCreateMethodCall() throws Exception {
        // given
        Duck duck = new Duck();
        duck.quack();

        Class<?> duckClass = Class.forName("com.example.helloservlet.ReflectionTests$Duck");
        Object duckObject = duckClass.getDeclaredConstructor().newInstance();
        Method quack = duckObject.getClass().getDeclaredMethod("quack", new Class<?>[0]);
        quack.invoke(duckObject);
    }

    static class Duck {

        void quack() {
            System.out.println("꽥꽥!");
        }
    }
}
