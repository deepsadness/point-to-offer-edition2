package chapter4;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 打印二叉树
 */
public class P176_printTree {
    public static String printNormal(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.value).append(",");
        if (root.left != null) {
            stringBuilder.append(printUpDown(root.left));
        }
        if (root.right != null) {
            stringBuilder.append(printUpDown(root.right));
        }
        return stringBuilder.toString();
    }

    //从上到下
    public static String printUpDown(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.poll();
            stringBuilder.append(pop.value).append(",");
            TreeNode popLeft = pop.left;
            TreeNode popRight = pop.right;
            if (popLeft != null) {
                queue.offer(popLeft);
            }
            if (popRight != null) {
                queue.offer(popRight);
            }

        }
        return stringBuilder.toString();
    }


    //层次打印
    public static String printInLine(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        queue.offer(root);
        TreeNode temp;

        while (!queue.isEmpty()) {
//            Queue<TreeNode> innerQueue = new LinkedList<>();
            //因为这个size是外部决定的，所以可以这样
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                temp = queue.poll();
                stringBuilder.append(temp.value);
                if (i != 1) {
                    stringBuilder.append(",");
                }
                TreeNode popLeft = temp.left;
                TreeNode popRight = temp.right;
                if (popLeft != null) {
                    queue.offer(popLeft);
                }
                if (popRight != null) {
                    queue.offer(popRight);
                }
            }

            if (!queue.isEmpty()) {
                stringBuilder.append("\n");
            }
//            queue = innerQueue;
        }
        return stringBuilder.toString();

    }

    //层次打印
    public static String printInLineRecursive(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        queue.offer(root);
        whileInQueue(queue, stringBuilder);
        return stringBuilder.toString();

    }

    private static void whileInQueue(Queue<TreeNode> queue, StringBuilder stringBuilder) {
        if (queue.isEmpty()) {
            return;
        }
        Queue<TreeNode> innerQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode pop = queue.poll();
            stringBuilder.append(pop.value);
            if (!queue.isEmpty()) {
                stringBuilder.append(",");
            }
            TreeNode popLeft = pop.left;
            TreeNode popRight = pop.right;
            if (popLeft != null) {
                innerQueue.offer(popLeft);
            }
            if (popRight != null) {
                innerQueue.offer(popRight);
            }
        }
        if (!innerQueue.isEmpty()) {
            stringBuilder.append("\n");
        }
        whileInQueue(innerQueue, stringBuilder);
    }

    //之字
    public static String printInSpecialRecursive(TreeNode root) {
        if (root == null) {
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        stack.push(root);
        whileInQueueSpecial(stack, stringBuilder, 0);
        return stringBuilder.toString();

    }

    private static void whileInQueueSpecial(Stack<TreeNode> stack, StringBuilder stringBuilder, int index) {
        if (stack.isEmpty()) {
            return;
        }
        Stack<TreeNode> innerStack = new Stack<>();
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            stringBuilder.append(pop.value);
            if (!stack.isEmpty()) {
                stringBuilder.append(",");
            }
            TreeNode popLeft = pop.left;
            TreeNode popRight = pop.right;
            if ((index & 1) == 0) { //even
                if (popLeft != null) {
                    innerStack.push(popLeft);
                }

                if (popRight != null) {
                    innerStack.push(popRight);
                }

            } else {//odd

                if (popRight != null) {
                    innerStack.push(popRight);
                }

                if (popLeft != null) {
                    innerStack.push(popLeft);
                }
            }
        }
        if (!innerStack.isEmpty()) {
            stringBuilder.append("\n");
        }
        whileInQueueSpecial(innerStack, stringBuilder, index + 1);
    }

    //层次打印
    public static String printInSpecial(TreeNode root) {
        if (root == null) {
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        stack.push(root);
        TreeNode temp;
        int lineIndex = 0;
        while (!stack.isEmpty()) {
            lineIndex++;
            Stack<TreeNode> innerStack = new Stack<>();
            //因为这个size是外部决定的，所以可以这样
            int size = stack.size();
            for (int i = size; i > 0; i--) {
                temp = stack.pop();
                stringBuilder.append(temp.value);
                if (i != 1) {
                    stringBuilder.append(",");
                }
                TreeNode popLeft = temp.left;
                TreeNode popRight = temp.right;
                if ((lineIndex & 1) == 0) {//even left right
                    if (popRight != null) {
                        innerStack.push(popRight);
                    }
                    if (popLeft != null) {
                        innerStack.push(popLeft);
                    }

                } else {//even right left
                    if (popLeft != null) {
                        innerStack.push(popLeft);
                    }

                    if (popRight != null) {
                        innerStack.push(popRight);
                    }

                }

            }
            if (!innerStack.isEmpty()) {
                stringBuilder.append("\n");
            }
            stack = innerStack;
        }
        return stringBuilder.toString();

    }

    //层次打印
    public static String printInSpecial0(TreeNode root) {
        if (root == null) {
            return "";
        }
        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        stackLeft.push(root);
        while (!stackLeft.isEmpty() || !stackRight.isEmpty()) {
            while (!stackLeft.isEmpty()) {
                //因为这个size是外部决定的，所以可以这样
                int size = stackLeft.size();
                for (int i = size; i > 0; i--) {
                    TreeNode temp = stackLeft.pop();
                    stringBuilder.append(temp.value);
                    if (i != 1) {
                        stringBuilder.append(",");
                    }
                    TreeNode popLeft = temp.left;
                    TreeNode popRight = temp.right;
                    if (popLeft != null) {
                        stackRight.push(popLeft);
                    }
                    if (popRight != null) {
                        stackRight.push(popRight);
                    }
                }
            }
            if (!stackRight.isEmpty()) {
                stringBuilder.append("\n");
            }

            while (!stackRight.isEmpty()) {
                //因为这个size是外部决定的，所以可以这样
                int size = stackRight.size();
                for (int i = size; i > 0; i--) {
                    TreeNode temp = stackRight.pop();
                    stringBuilder.append(temp.value);
                    if (i != 1) {
                        stringBuilder.append(",");
                    }
                    TreeNode popLeft = temp.left;
                    TreeNode popRight = temp.right;
                    if (popRight != null) {
                        stackLeft.push(popRight);
                    }
                    if (popLeft != null) {
                        stackLeft.push(popLeft);
                    }

                }
            }
            if (!stackLeft.isEmpty()) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();

    }
}
