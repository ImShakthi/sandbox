package com.sakthi.collections;

import java.util.function.Consumer;

public class CollectionsHandler {
  public static void main(final String args[]) {
    //    System.out.println("~~~ Collection Handler ~~~");
    //    StreamHandler streamHandler = new StreamHandler();
    //    streamHandler.sumStream();
    //
    Consumer<String> consumer1 =
        (arg) -> {
          System.out.println(arg + "OK");
        };

    consumer1.accept("TestOne - ");

    Consumer<String> consumer2 =
        (x) -> {
          System.out.println(x + "OK!!!");
        };

    consumer1.andThen(consumer2).accept("TestConsumerAfterThen - ");
  }
}
