package chapter3;

import model.ListNode;

/**
 * 删除排序链表中值重复的节点
 */
public class P122_deleteDuplicatedNode {
    public static ListNode deleteDuplicatedNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tempHead = head;
        ListNode cmpNode = tempHead;
        ListNode lastCmpNode = null;

        //取到一点开始遍历
        while (cmpNode != null && cmpNode.next != null) {
            ListNode temp = cmpNode;
            int cmpValue = temp.value;
            boolean hasDelete = false;
            //先删除后面节点中所有重复的部分
            while (temp.next != null) {
                if (temp.next.value == cmpValue) {
                    //需要删除
                    hasDelete = true;
                    if (temp.next.next == null) {
                        temp.next = null;
                    } else {
                        temp.next = temp.next.next;
                    }
                } else {
                    temp = temp.next;
                }
            }
            //如果发生了删除，就回头来看当前的节点
            if (hasDelete) {    //如果发生了删除，就需要把自己删除掉
                //如果当前的节点是头结点
                if (cmpValue == tempHead.value) {
                    //删除头节点
                    if (tempHead.next != null) {
                        tempHead = tempHead.next;
                        lastCmpNode = null;
                        cmpNode =tempHead;
                    } else {
                        return null;
                    }
                } else { //如果不是头结点。只要删除自己就可以了
                    if (lastCmpNode != null) {
                        lastCmpNode.next = cmpNode.next;
                        cmpNode = cmpNode.next;
                    }
                }
            } else {
                //正常进行往后移动一位
                lastCmpNode = cmpNode;
                cmpNode = cmpNode.next;
            }
        }
        return tempHead;
    }
}
