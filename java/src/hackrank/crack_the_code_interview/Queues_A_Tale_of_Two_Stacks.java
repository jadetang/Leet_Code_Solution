package hackrank.crack_the_code_interview;

import java.util.ArrayDeque;

/**
 * @author jade on 2017/7/10 上午7:09
 */
public class Queues_A_Tale_of_Two_Stacks {


  public static class MyQueue<E> {


    ArrayDeque<E> input = new ArrayDeque<>();

    ArrayDeque<E> output = new ArrayDeque<>();


    public void enqueue(E e) {
      input.push(e);
    }

    public E dequeue() {
      if (output.isEmpty()) {
        while (!input.isEmpty()) {
          output.push(input.pop());
        }

      }
      return output.pop();
    }

    public E peek() {
      if (output.isEmpty()) {
        while (!input.isEmpty()) {
          output.push(input.pop());
        }
      }
      return output.peek();

    }


  }

}
