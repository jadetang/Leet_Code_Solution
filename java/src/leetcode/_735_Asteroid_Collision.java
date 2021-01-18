package leetcode;

import java.util.Stack;

public class _735_Asteroid_Collision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            Integer asteroid = asteroids[i];
            while (!stack.isEmpty() && asteroid != null && stack.peek() > 0 && asteroid < 0) {
                int left = stack.pop();
                if (left > -asteroid) {
                    asteroid = left;
                }else if (left == -asteroid) {
                    asteroid = null;
                }
            }
            if (asteroid != null) {
                stack.push(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        for (Integer asteroid : stack) {
            ans[i++] = asteroid;
        }
        return ans;
    }
}
