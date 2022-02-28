package dev.kyuelin.collections;

/**
 * Created by linken on 12/5/15.
 */
public class SplayTreeTest {
    public SplayTreeTest() {
        root = nullNode;
    }

    private final BinaryNode root;
    private static final BinaryNode nullNode;
    private static final BinaryNode newNode = null;
    private static final BinaryNode header = new BinaryNode(null);
    static
    {
        nullNode=new BinaryNode(null);
        nullNode.left=nullNode.right=nullNode;
    }

    public void insert(Comparable x) {
    }
}
