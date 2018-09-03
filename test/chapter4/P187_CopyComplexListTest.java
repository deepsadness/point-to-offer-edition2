package chapter4;

import model.ComplexListNode;
import org.junit.Assert;
import org.junit.Test;

public class P187_CopyComplexListTest {

    @Test
    public void copy0() {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.sibling = node3;
        node2.sibling = node5;
        node4.sibling = node2;
        String result = node1.toString();
        ComplexListNode copyNode = P187_CopyComplexList.copy0(node1);
        Assert.assertEquals(result,copyNode.toString());
    }

    @Test
    public void copy1() {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.sibling = node3;
        node2.sibling = node5;
        node4.sibling = node2;
        String result = node1.toString();
        ComplexListNode copyNode = P187_CopyComplexList.copy1(node1);
        Assert.assertEquals(result,copyNode.toString());
    }

    @Test
    public void copy2() {
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        ComplexListNode node5 = new ComplexListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.sibling = node3;
        node2.sibling = node5;
        node4.sibling = node2;
        String result = node1.toString();
        ComplexListNode copyNode = P187_CopyComplexList.copy2(node1);
        Assert.assertEquals(result,copyNode.toString());
    }
}