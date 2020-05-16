package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _359_Logger_Rate_Limiter {

    public static class Logger {
        /** Initialize your data structure here. */

        Map<String, Integer> data = new HashMap<>();

        public Logger() {
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (data.get(message) != null) {
                int previousTime = data.get(message);
                data.put(message, timestamp);
                if (timestamp - 10 <= previousTime) {
                    return true;
                }else {
                    return false;
                }
            }
            data.put(message, timestamp);
            return true;
        }
    }
}
