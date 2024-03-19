package algorithm.linklist;

/**
 * @Auther d
 * @Date 2024/3/18 14:12
 * @Describe BM1反转链表
 **/
public class ReverseListNode01 {
    public static void main(String[] args) {
        ReverseListNode01 reverseListNode01=new ReverseListNode01();
        ListNode a=new ListNode(3);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(1);
        a.next=b;
        b.next=c;
        reverseListNode01.ReverseList(a);
        System.out.println(c);
    }




    /**
     * @param head ListNode类
     * @return ListNode类
     *
     * 1.先断开,把后面的保存给next
     * 2.断开后把前面的给连接到后面，变成后面的next
     * 3.第二步把pre连接到了后面，所以第三步pre向前移动一个
     * 4.把后面的断开的变成原先链表的头结点进行下一次循环
     */
    public ListNode ReverseList (ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }









    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
