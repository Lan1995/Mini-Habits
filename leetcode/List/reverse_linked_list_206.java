package List;

/**
 * 反转一个单链表。
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class reverse_linked_list_206 {

    /**
     * 思路：
     * 1. 从head开始转变方向
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head,pre = null;
        while (cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }


    /**
     * 递归：
     * 从尾巴开始转换方向
     * 1->2->3->4->5->null
     * 1->2->3<-4<-5
     * cur = 3时
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //梦开始的地方head = 4, p = 5
        ListNode p = reverseList2(head.next);
        // head.next.next => 4->3
        head.next.next = head;
        // head.next = null => 3->4 断开,避免循环
        head.next = null;
        return p;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
        reverseList(listNode);
    }
}
