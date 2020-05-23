import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


//比较器这里总结：
//Java默认是升序排列
//o1-o2符号与返回值符号相同，升序排列
//o1-o2符号与返回值符号相反，降序排列

//K路整体合并
//把所有的不为空的头结点都放到一个最小堆中。
//弹出堆顶元素，接到新链表的尾部，若该节点还有next，把其放进堆中（堆中永远维持着最小的k个节点）。直到堆空为止。


public class Solution_23 {
public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

    public static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;

    Queue<ListNode> PriorityQuene = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//        升序排列
        @Override
        public int compare(ListNode o1, ListNode o2) {
            if (o1.val > o2.val){
                return 1;
            }else return -1;
        }
    });
    ListNode dummy = new ListNode(0);
    ListNode Cur = dummy;

    for (int i=0;i<lists.length;i++){
        if (lists[i] == null) continue;
        PriorityQuene.add(lists[i]);
    }

    while (!PriorityQuene.isEmpty()){
        ListNode NextNode = PriorityQuene.poll();
        Cur.next = NextNode;
        Cur = Cur.next;
        if (NextNode.next != null){
            PriorityQuene.add(NextNode.next);
        }
    }
    return dummy.next;
    }

    public static ListNode Initial_1(){
    ListNode head = new ListNode(1);
    ListNode cur = head;
    cur.next = new ListNode(4);
    cur = cur.next;
    cur.next = new ListNode(5);
    return head;
    }
    public static ListNode Initial_2(){
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        return head;
    }
    public static ListNode Initial_3(){
        ListNode head = new ListNode(2);
        ListNode cur = head;
        cur.next = new ListNode(6);
        return head;
    }
    public static void main(String[] args) {
    ListNode[] listNodes = {Initial_1(),Initial_2(),Initial_3()};
    ListNode res = mergeKLists(listNodes);

    }
}
