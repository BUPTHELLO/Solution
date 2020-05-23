public class Solution_19 {

public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public static ListNode initial(){
    ListNode head = new ListNode(1);
    ListNode Cur = head;
    for(int i=2;i<6;i++){
        Cur.next=new ListNode(i);
        Cur = Cur.next;
    }
    return head;
}

//     遍历两次单链表
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode Cur = dummy;
    int length = 0;
    while (Cur.next != null){
        length++;
        Cur = Cur.next;
    }
    length = length - n;
    Cur = dummy;
    while (length>0){
        Cur = Cur.next;
        length--;
    }
    Cur.next = Cur.next.next;
    return dummy.next;
    }

//    遍历一次单链表
    public static ListNode removeNthFromEnd1(ListNode head, int n){
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode Cur = dummy;
    ListNode Pre = dummy;

    while (n>=0){
        Cur = Cur.next;
        n--;
    }

    while (Cur != null){
        Pre = Pre.next;
        Cur = Cur.next;
    }

    Pre.next = Pre.next.next;
    return dummy.next;
    }

    //    遍历一次单链表，一开始的想法
    public static ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode Cur = dummy;
        ListNode Pre = dummy;

        while (n>0){
            Cur = Cur.next;
            n--;
        }

        while (Cur.next != null){
            Pre = Pre.next;
            Cur = Cur.next;
        }



//        删除头尾节点时会产生问题
//        Pre.next = Cur;

        //Important
        Pre.next = Pre.next.next;
        return dummy.next;
    }

    public static void main(String[] arg){
    ListNode head = initial();
    head = removeNthFromEnd2(head,5);
    int i=0;

    }
}
