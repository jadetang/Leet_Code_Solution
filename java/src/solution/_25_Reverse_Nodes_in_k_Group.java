package solution;

import ds.ListNode;

/**
 * @author sanguan.tangsicheng on 16/7/16 下午8:05
 */
public class _25_Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if( head == null ){
            return null;
        }
        ListNode temp = head;
        int length = 1;
        while(temp.next != null ){
            length++;
            temp = temp.next;
        }
        int group = length / k;
        if( group < 1 ){
            return head;
        }
        //System.out.println("group:"+group);
        ListNode[] groups = new ListNode[group];
        temp = head;
        for( int i=0 ;i< group;i++){
            for(int j=0; j< k; j++){
                if( j == 0 ){
                    groups[i] = temp;

                    if( j == k - 1 && temp != null   ){
                        ListNode t = temp;
                        temp = temp.next;
                        t.next = null;
                    }else {
                        temp = temp.next;
                    }
                    continue;
                }
                if( j == k - 1 ){
                    ListNode t = temp;
                    temp = temp.next;
                    t.next = null;
                    continue;
                }
                temp = temp.next;
            }
        }
        for( int i= 0; i< groups.length ; i++){
            groups[i ] = reverse(groups[i]);
        }
        for( int i= 0; i <  groups.length - 1; i++){
            concat(groups[i],groups[i+1]);
        }
        concat(groups[group-1],temp);
        return groups[0];
    }

    public void concat(ListNode head,ListNode tail){
        ListNode temp = head;
        while(temp.next != null ){
            temp = temp.next;
        }
        temp.next = tail;
    }


    public   ListNode reverse(ListNode head) {
        if(head==null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        p.next=null; //这个必须的~~~，否则链表就成有环的了。
        while(q!=null) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode l  = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l.next = l2;
        _25_Reverse_Nodes_in_k_Group s = new _25_Reverse_Nodes_in_k_Group();
        s.reverseKGroup(l,2);
    }



}
