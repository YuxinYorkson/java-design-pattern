/**
 * 要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。门面模式提供一个高层次的接口，使得子系统更易于使用。
 *
 *
 * ● Facade门面角色
 * 客户端可以调用这个角色的方法。此角色知晓子系统的所有功能和责任。一般情况下，本角色会将所有从客户端发来的请求委派到相应的子系统去，也就说该角色没有实际的业务逻辑，只是一个委托类。
 * ● subsystem子系统角色
 * 可以同时有一个或者多个子系统。每一个子系统都不是一个单独的类，而是一个类的集合。子系统并不知道门面的存在。对于子系统而言，门面仅仅是另外一个客户端而已。
 *
 *
 * 使用场景：
 * ● 为一个复杂的模块或子系统提供一个供外界访问的接口
 * ● 子系统相对独立——外界对子系统的访问只要黑箱操作即可
 * ● 预防低水平人员带来的风险扩散
 *
 *
 * 注意：
 * ●一个子系统可以有多个门面
 * ●门面不参与子系统内的业务逻辑
 */
package com.tuling.designpattern.facade;

public class FacadePattern {

    public static void main(String[] args) {

        Client1 client1 = new Client1();
        Client2 client2 = new Client2();
        client1.doSomthing1();
        client2.doSomthing2();
    }
}

class Facade {

    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();

    public void doSomthingFacade() {
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}

class Client1 {

    /*SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();*/

    Facade facade = new Facade();

    public void doSomthing1() {
        /*subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();*/
        facade.doSomthingFacade();
    }
}

class Client2 {

    /*SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();*/

    Facade facade = new Facade();

    public void doSomthing2() {
        /*subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();*/
        facade.doSomthingFacade();
    }
}

class SubSystem1 {
    public void method1() {
        System.out.println("SubSystem1 method1 executed.");
    }
}

class SubSystem2 {
    public void method2() {
        System.out.println("SubSystem2 method2 executed.");
    }
}

class SubSystem3 {
    public void method3() {
        System.out.println("SubSystem3 method3 executed.");
    }
}