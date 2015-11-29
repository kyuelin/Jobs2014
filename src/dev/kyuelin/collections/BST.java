package dev.kyuelin.collections;

import java.util.Comparator;

/**
 * Created by linken on 11/26/15.
 */
public class BST {
    private BN root;
    public void insert(Comparable x) {
        root = insert(x, root);
    }

    public BN insert(Comparable x, BN root) {
        if (root == null) {
            root = new BN(x, null, null);
        }
        if (x.compareTo(root.element) > 0 ) {
            insert(x, root.right);
        }
        else if (x.compareTo(root.element) < 0 ) {
            insert(x, root.left);
        }
        else ;//duplicated

        return root;
    }

    public class BN {
        Comparable element;
        BN left;
        BN right;

        BN(Comparable e, BN l, BN r) {
            element=e;
            left=l;
            right=r;
        }
    }
}
