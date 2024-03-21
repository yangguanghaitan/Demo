package algorithm.linklist;

/**
 * @Auther d
 * @Date 2024/3/20 10:54
 * @Describe BM6判断链表中是否有环 简单
 **/
public class HasCycleListNode03 {

    public static void main(String[] args) {
        ListNode a1=new ListNode(3);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(0);
        ListNode a4=new ListNode(-4);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;

        a4.next=a2;//有环
        HasCycleListNode03 hasCycleListNode03=new HasCycleListNode03();
        System.out.println(hasCycleListNode03.hasCycle(a1));
    }


    /**
     * @param head
     * @return boolean
     * @Description
     * 1.通过快慢指针实现，如果有环快的一定会追上慢的
     **/
    public boolean hasCycle(ListNode head) {
        // 用快慢指针判断
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
