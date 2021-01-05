package List;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class reverse_nodes_in_k_group_25 {

    /**
     * 思路:
     * 1. 判断终止索引位置
     * 2. 开始反转
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode step = head;
        while (step != null) {
            step = step.next;
            length++;
        }
        if(length < k) {
            return null;
        }
        int cycle = length/k;
        int count = 0;
        ListNode dumpNode = new ListNode(0,head);

        ListNode cur = dumpNode.next;
        ListNode pre = dumpNode;
        while (count < cycle) {
            reversList(pre,cur,k);
            count = count + k;
        }
        return dumpNode.next;
    }


    public static  ListNode reversList(ListNode pre,ListNode cur,int k){
        int count = 0;
        ListNode oldPre = null;
        ListNode oldCur = cur;
        while (count < k) {
            ListNode tmp = oldCur.next;
            oldCur.next = oldPre;
            oldPre = oldCur;
            oldCur = tmp;
            count++;
        }
        pre.next = oldPre;
        return pre;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        reverseKGroup(listNode,2);
    }
}
