package dev.kyuelin.progcreek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by linken on 4/29/16.
 */
public class BTreeTraversal {
    public static void preorder(TreeNode root ) {
        if (root == null)  return;
        System.out.println(root.value);
        preorder(root.left);
        preorder(root.right);
    }
    public static void preorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.println(node.value);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
    public static ArrayList<Integer> preorder3(TreeNode root) {
        ArrayList<Integer> retlist = new ArrayList<>();
        if (root == null) return retlist;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            retlist.add(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return retlist;
    }

    public static void breathfirstsearch(TreeNode root, int target) {
        LinkedList<TreeNode> nqueue = new LinkedList<>();

        nqueue.add(root);
        while(!nqueue.isEmpty()) {
            TreeNode node = nqueue.poll();
            if (node.value == target) {
                break;
            }
            else {
                nqueue.add(root.left);
                nqueue.add(root.right);
            }
        }
    }
    public static void kthlargest(TreeNode root, int k) {
        findkthLargest(root, k, 0);
    }
    public static void findkthLargest(TreeNode root, int k, int c) {
        if (root != null || c>=k) {
            return;
        }
        findkthLargest(root.right, k, c);

        c++;

        if (c==k) {
            System.out.println("found kth largest" + root.value);
        }

        findkthLargest(root.left, k,c );

    }
}
