package com.sakthi.java.basics;

public class BaseHandler {
  public static void main(String[] args) {
    //    BaseHandler baseHandler = new BaseHandler();
    AbsHandler absHandler = new AbsHandler();
    AnotherAbsHandler anotherAbsHandler = new AnotherAbsHandler();
    InterfaceHandler interfaceHandler = new InterfaceHandler();

    System.out.println(interfaceHandler.sayHello());

    System.out.println(absHandler.sayHello());
    System.out.println(anotherAbsHandler.sayHello());
    System.out.println(absHandler.sayHi());
  }
}
