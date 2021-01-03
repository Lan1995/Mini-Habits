package List;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 *  
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class linked_list_cycle_141 {

    /**
     * 思路：快慢指针
     * fast指针每次走两步，slow指针每次走一步
     * 存在环形，则fast指针会追上slow指针(重合)
     * 不存在，fast指针到末尾
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        //特例
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head,fast = head.next;
        while (fast.next != null && fast.next.next!= null) {
            if(fast.next == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }


     class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
