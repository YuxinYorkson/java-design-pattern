/*
  严格来说简单工厂不能算作一种设计模式，只是一种编程方式或者习惯
 */
package com.tuling.designpattern.factory;

public class SimpleFactoryPattern {

    public static void main(String[] args) {
        Applcation applcation = new Applcation();
        IProduct product = applcation.getObject("1");
        product.method();
    }
}

class SimpleFactory {

    public static IProduct createProduct(String type) {
        if (type.equals("0")) {
            return new ProductA();
        } else if (type.equals("1")) {
            return new ProductB();
        } else {
            return null;
        }
    }
}

interface IProduct {
    void method();
}

class ProductA implements IProduct {

    public void method() {
        System.out.println("ProductA method is executed.");
    }
}

class ProductB implements IProduct {

    public void method() {
        System.out.println("ProductB method is executed.");
    }
}

class Applcation {

    private IProduct createProduct(String type) {
        return SimpleFactory.createProduct(type);
    }

    IProduct getObject(String type) {
        return createProduct(type);
    }
}
