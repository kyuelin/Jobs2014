package dev.kyuelin.collections;

/**
 * Created by linken on 11/29/15.
 */
public class AvlTreeTest {

    class AvlNode {
        Comparable element;
        AvlNode left;
        AvlNode right;
        int height;

        AvlNode(Comparable theElement) {
            this(theElement, null, null);
        }

        AvlNode(Comparable theElement, AvlNode left_, AvlNode right_) {
            this.element=theElement;
            this.left=left_;
            this.right=right_;
            this.height=0;
        }
    }

    class AvlTree {
        private AvlNode root;
        public AvlTree() {
            root = null;
        }
        public void insert(Comparable x) {
            root = insert(x, root);
        }
        public AvlNode insert(Comparable x, AvlNode t) {
            if (t == null) {
                t = new AvlNode(x,null,null);
            }
            else if (x.compareTo(t.element) < 0) {
                t.left=insert(x, t.left);
                if (height(t.left) - height(t.right) == 2) {
                    if (x.compareTo(t.left.element) < 0) {
                        t = rotateWithLeftChild(t);
                    }
                    else
                        t = doubleRotateWithLeftChild(t);
                }
            }
            else if (x.compareTo(t.element) > 0 ) {
                t.right = insert(x, t.right);
                if (height(t.right) - height(t.left) == 2) {
                    if (x.compareTo(t.right.element) > 0) {
                        t = rotateWithRightChild(t);
                    }
                    else {
                        t = doubleRotateWithRightChild(t);
                   }
                }
            }
            else ;
            t.height = max(height(t.left), height(t.right)) + 1;
            return t;
        }

        public AvlNode rotateWithLeftChild(AvlNode n2) {
            AvlNode n1 = n2.left;
            n2.left = n1.right;
            n1.right = n2;
            n2.height = max(height(n2.left), height(n2.right))+1;
            n1.height = max(height(n1.left), n2.height)+1;
            return n1;
        }

        public AvlNode rotateWithRightChild(AvlNode n2) {
            AvlNode n1 = n2.right;
            n2.right=n1.left;
            n1.left=n2;
            n2.height = max(height(n2.left), height(n2.right))+1;
            n1.height = max(height(n1.right), n2.height) +1;
            return n1;
        }

        public AvlNode doubleRotateWithLeftChild(AvlNode n3) {
            n3.left = rotateWithRightChild(n3.left);
            return rotateWithLeftChild(n3);
        }

        public AvlNode doubleRotateWithRightChild(AvlNode n3) {
            n3.right = rotateWithLeftChild(n3.right);
            return rotateWithRightChild(n3);
        }

        public void remove(Comparable x) {

        }
        public AvlNode search(Comparable x) {
            return null;
        }

        public int height(AvlNode root) {
            return root==null?-1:root.height;
        }

        private int max(int h1, int h2) {
            return (h1 >= h2) ? h1 : h2;
        }
    }
}
