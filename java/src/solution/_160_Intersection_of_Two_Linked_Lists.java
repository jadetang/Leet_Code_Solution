package solution;

import ds.ListNode;

/**
 * @author sanguan.tangsicheng on 2017/7/2 下午10:04
 */
public class _160_Intersection_of_Two_Linked_Lists {

    /**
     * 用 hash 来做也可以
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while( a != b){
            if(a == null){ //这个里只会判空一次，下一次的时候，就是 a == null 并且 b == null
                a = headB;
            }else{
                a = a.next;
            }
            if(b == null){
                b = headA;
            }else{
                b = b.next;
            }
        }
        return a;
    }
}
