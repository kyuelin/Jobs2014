package dev.kyuelin.citi.interviews;

public class BSTree {

    public class BSTreeNode {
        Integer i;
        BSTreeNode left;
        BSTreeNode right;

        BSTreeNode(Integer i) {
            this.i = i;
        }
    }

    public static void preorder(BSTreeNode bsTreeNode) {
/*
        if (bsTreeNode != null) {
            System.out.println(bsTreeNode.i);
        }
        else {
            return;
        }
*/
        if (bsTreeNode == null) {
            return;
        }
        System.out.println(bsTreeNode.i);
        preorder(bsTreeNode.left);
        preorder(bsTreeNode.right);
    }

    public static void inorder(BSTreeNode bsTreeNode) {
        if (bsTreeNode == null) {
            return;
        }
        inorder(bsTreeNode.left);
        System.out.println(bsTreeNode.i);
        inorder(bsTreeNode.right);
    }

    public static void postorder(BSTreeNode bsTreeNode) {
        if (bsTreeNode == null) {
            return;
        }
        postorder(bsTreeNode.left);
        postorder(bsTreeNode.right);
        System.out.println(bsTreeNode.i);
    }

    public static void main(String[] args) {

    }
}
