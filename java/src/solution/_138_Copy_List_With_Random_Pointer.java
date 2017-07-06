package solution;

import java.util.HashMap;
import java.util.Map;

import ds.RandomListNode;

/**
 * @author sanguan.tangsicheng on 2017/7/2 下午4:57
 */
public class _138_Copy_List_With_Random_Pointer {

    /**
     * 用 hash map 来存对应的关系。
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            //更新 next
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }
}
