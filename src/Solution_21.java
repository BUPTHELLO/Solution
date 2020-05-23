public class Solution_21 {
    public static class ListNode{
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    //初始化list
    public static ListNode List_1(){
        ListNode head = new ListNode(1);
        ListNode Cur = head;
        Cur.next = new ListNode(2);
        Cur = Cur.next;
        Cur.next = new ListNode(4);
        return head;
    }
    public static ListNode List_2(){
        ListNode head = new ListNode(1);
        ListNode Cur = head;
        Cur.next = new ListNode(3);
        Cur = Cur.next;
        Cur.next = new ListNode(4);
        return head;
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode cur_1 = l1;
        ListNode cur_2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (cur_1 != null && cur_2 != null){
            if (cur_1.val<cur_2.val){
                cur.next = cur_1;
                cur = cur.next;
                cur_1 = cur_1.next;
            }else {
                cur.next = cur_2;
                cur = cur.next;
                cur_2 = cur_2.next;
            }
        }

        cur.next = (cur_1==null)?cur_2:cur_1;
        return dummy.next;
    }

//    使用递归的方案
    public static ListNode mergeTwoLists_1(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists_1(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists_1(l1,l2.next);
            return l2;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = List_1();
        ListNode l2 = List_2();

        ListNode head = mergeTwoLists_1(l1,l2);

    }


}
