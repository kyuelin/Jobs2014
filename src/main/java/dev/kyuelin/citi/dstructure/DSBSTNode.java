package dev.kyuelin.citi.dstructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DSBSTNode {

    private Integer ikey;
    private DSBSTNode left, right;

    public DSBSTNode(Integer ikey) {
        this.ikey = ikey;
    }

    public int compare(DSBSTNode inode) {
        return this.ikey.compareTo(inode.ikey);
    }

    public void insert(DSBSTNode inode) {
        if (compare(inode) < 0) {
            if (null == right)
                right = inode;
            else
                right.insert(inode);
        } else {
            if (null == left)
                left = inode;
            else
                left.insert(inode);
        }
    }

    public static String toString(DSBSTNode node) {
        if (null != node)
            return Integer.toString(node.ikey);
        else
            return "NULL";
    }

    public static void inOrder(DSBSTNode root) {
        if (null != root) {
            inOrder(root.left);
            System.out.println(root.ikey);
            inOrder(root.right);
        }
    }

    public static void preOrder(DSBSTNode root) {
        if (null != root) {
            System.out.println(root.ikey);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void postOrder(DSBSTNode root) {
        if (null != root) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.ikey);
        }
    }

    public static DSBSTNode search(DSBSTNode root, Integer ikey) {
        if (null == root || root.ikey.compareTo(ikey) == 0) {
            return root;
        } else if (root.ikey.compareTo(ikey) > 0) {
            search(root.right, ikey);
        } else {
            search(root.left, ikey);
        }
        return null;
    }

    public static void main(String[] args) {
       int range = 10;
        int[] input = new int[range];

        for (int i = 0; i < range; i++) {
            input[i] = (int) (Math.random() * range);
        }

        DSBSTNode root = new DSBSTNode((int) (Math.random() * range));

        for (int i = 0; i < range; i++) {
            root.insert(new DSBSTNode(input[i]));
        }

        System.out.println(Arrays.toString(input));
        DSBSTNode.inOrder(root);

    }
}
