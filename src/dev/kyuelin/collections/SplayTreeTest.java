package dev.kyuelin.collections;

/**
 * Created by linken on 12/5/15.
 */
public class SplayTreeTest {
    public SplayTreeTest() {
        root = nullNode;
    }

    private BinaryNode root;
    private static BinaryNode nullNode;
    private static BinaryNode newNode = null;
    private static BinaryNode header = new BinaryNode(null);
    static
    {
        nullNode=new BinaryNode(null);
        nullNode.left=nullNode.right=nullNode;
    }

    public void insert(Comparable x) {
    }
}
