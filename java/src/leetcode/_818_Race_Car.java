package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class _818_Race_Car {

    public int racecar(int target) {
        Queue<State> queue = new LinkedList<>();
        State start = new State(0, 1);
        queue.offer(start);
        int ans = 0;
        Set<State> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State current = queue.poll();
                if (current.pos == target) {
                    return ans;
                }
                State next = current.accelerate();
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
                next = current.reverse();
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
            ans++;
        }
        return -1;
    }

    public static class State {
        int pos;
        int speed;

        public State(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        public State accelerate() {
            return new State(pos + speed, speed * 2);
        }

        public State reverse() {
            if (speed > 0) {
                return new State(pos, -1);
            }
            return new State(pos, 1);
        }


        @Override
        public int hashCode() {
            return Objects.hash(pos, speed);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return pos == state.pos &&
                    speed == state.speed;
        }
    }

}
