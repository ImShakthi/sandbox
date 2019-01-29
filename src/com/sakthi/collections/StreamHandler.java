package com.sakthi.collections;

import java.util.ArrayList;
import java.util.List;

public class StreamHandler {

  public void sumStream() {
    List<Integer> list = new ArrayList<>();

    for (int i = 1; i <= 10; i++) {
      list.add(i);
    }
    int sum = list.stream().filter(i -> (i % 2 == 0)).mapToInt(i -> i).sum();
    System.out.println(sum);
  }
}
