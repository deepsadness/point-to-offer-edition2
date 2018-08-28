package chapter2;

import chapter2.model.ParentTreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 1
 * 2     3
 * 4  5   6
 * 8  7
 */
public class P65_NodeUnderTreeTest {


    /**
     *          1
     *      2       3
     *    4   5   6
     *     8   7
     *
     */
    @Test
    public void testWithRightAndRightLeft() {
        ParentTreeNode root = ParentTreeNode.just(1);
        root.left(2).left(4).right(8);
        root.right(3).left(6);
        root.left.right(5).right(7);

        //1.有右节点。右节点，有左节点
        Assert.assertEquals(root.right.left, P65_NodeUnderTree.getNextByInOrder(root));


    }

    @Test
    public void testWithRightAndRight() {
        ParentTreeNode root = ParentTreeNode.just(1);
        root.left(2).left(4).right(8);
        root.right(3).left(6);
        root.left.right(5).right(7);


        //2.有右节点。右节点，无左节点，有右节点
        Assert.assertEquals(root.left.right.right, P65_NodeUnderTree.getNextByInOrder(root.left));

    }

    @Test
    public void testWitRightNoChild() {
        ParentTreeNode root = ParentTreeNode.just(1);
        root.left(2).left(4).right(8);
        root.right(3).left(6);
        root.left.right(5).right(7);

        //3.有右节点，右节点。没有孩子
        Assert.assertEquals(root.left.right.right, P65_NodeUnderTree.getNextByInOrder(root.left.right));

    }

    @Test
    public void testLeftWithoutRight() {
        ParentTreeNode root = ParentTreeNode.just(1);
        root.left(2).left(4).right(8);
        root.right(3).left(6);
        root.left.right(5).right(7);


        //4.没有右节点。自己是左节点。
        ParentTreeNode node = root.right.left;
        Assert.assertEquals(node.parent, P65_NodeUnderTree.getNextByInOrder(node));

    }

    /**
     *          1
     *      2       3
     *     4  5   6
     *
     *
     */
    @Test
    public void testWithoutRightAndParentLeft() {
        ParentTreeNode root = ParentTreeNode.just(1);
        ParentTreeNode node2 = root.left(2);
        root.right(3).left(6);
        node2.right(5);
        node2.left(4);


        //5.没有右节点。自己是右节点。父节点是左节点.而且父亲有左节点
        ParentTreeNode node = root.left.right;
        Assert.assertEquals(node.parent.parent, P65_NodeUnderTree.getNextByInOrder(node));
    }

    /**
     *          1
     *      2       3
     *       5     4  6
     *
     *
     */
    @Test
    public void testWithoutRightAndParentRight() {
        ParentTreeNode root = ParentTreeNode.just(1);
        root.left(2).left(4).right(8);
        ParentTreeNode node3 = root.right(3);
        node3.right(6);
        node3.left(4);
        root.left.right(5).right(7);

        //5.没有右节点。自己是右节点。父节点是右节点。而且父节点有左节点
        Assert.assertEquals(null, P65_NodeUnderTree.getNextByInOrder(root.right.right));

    }
}