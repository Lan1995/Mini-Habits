package List;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 *
 * 你是否可以使用 O(1) 空间解决此题？
 *

 */
public class linked_list_cycle_ii_142 {

    /**
     * floyd判圈算法
     * 领域：有限状态机、链表
     * 1. 环的长度
     * 2. 环的起点
     * 如果存在环,起点未S
     * 设环的起点未P，两指针相遇在O点
     * S - > P 距离为m,P -> O的距离为c, 环内行走的距离为 M = （P->O）c + nR(为圈长)
     * 慢指针slow走过的路 step = m + M = m + c + a*R
     * 快指针fast走过的路 2*step = m + c * b*R(b>a)
     * 两式相减  step = (b-a)*R = m + c + a*R
     * m + c = (b-2a)*R
     * S -> O 的距离为 R的倍数
     * 1. 环的长度，相遇在O点之后，fast不动，slow+1
     * 2. 环的起点，相遇O点之后，P -> fast 距离为c , slow从头开始走，fast一步一步走，slow和fast必定相互在起点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head,fast = head;
        while (fast != null) {
            if(fast.next == null ){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
