package leetcode;

import java.util.ArrayDeque;

/**
 * @author jade on 2017/7/10 上午7:21
 */
public class _232_Implement_Queue_using_Stacks {


  public class MyQueue {


    ArrayDeque<Integer> input = new ArrayDeque<>();


    ArrayDeque<Integer> output = new ArrayDeque<>();


    public void enqueue(Integer e) {
      input.push(e);
    }

    public Integer dequeue() {
      if (output.isEmpty()) {
        while (!input.isEmpty()) {
          output.push(input.pop());
        }

      }
      return output.pop();
    }

    public Integer peek() {
      if (output.isEmpty()) {
        while (!input.isEmpty()) {
          output.push(input.pop());
        }
      }
      return output.peek();

    }


  }

}
