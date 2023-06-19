package com.example.helloservlet.expert001_01;

public class Driver {
    public static void main(String[] args) {
        Car car = new Car(new AmericaTire());
        System.out.println(car.getTireBrand());
    }
}
