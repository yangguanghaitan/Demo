package algorithm.linklist;

/**
 * @Auther d
 * @Date 2024/3/19 14:54
 * @Describe BM4合并两个排序的链表 简单
 **/
public class MergeListNode02 {
    public static void main(String[] args) {
        //链表{1,3,5}和{2,4,6}
        ListNode a1=new ListNode(1);
        ListNode a2=new ListNode(3);
        ListNode a3=new ListNode(5);
        a1.next=a2;
        a2.next=a3;

        ListNode b1=new ListNode(2);
        ListNode b2=new ListNode(4);
        ListNode b3=new ListNode(6);
        b1.next=b2;
        b2.next=b3;



        MergeListNode02 mergeListNode02=new MergeListNode02();
        ListNode merge = mergeListNode02.Merge(a1, b1);
        System.out.println(merge.toString());
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     * 对象a的地址传给对象b,后面对象b的地址修改为对象c的地址，对象a的地址不会变
     * 1.第一步创建对象vHead，用来保存合并后的新链表的头结点
     * 2.第二步vHead头节点不变，声明cur对象,用来保存较小值的地址即把较小值连接到vHead节点的尾节点
     * 3.第三部cur对象的地址向后移动一次即一直使它指向vHead链表的尾节点，往后继续循环往vHead节点的尾节点增添节点
     * 4.当遍历到其中一个链表的尾节点后，不在比较大小，把未遍历完的链表直接添加到cur对象的next节点位置
     */
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return pHead1 == null ? pHead2 : pHead1;
        ListNode vHead = new ListNode(-1);
        ListNode cur = vHead;
        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                cur.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                cur.next = pHead2;
                pHead2 = pHead2.next;
            }
            cur = cur.next;
        }

        if (pHead1 != null)
            cur.next = pHead1;
        if (pHead2 != null)
            cur.next = pHead2;
        return vHead.next;
    }


    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
