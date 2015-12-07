package dev.kyuelin.collections;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Comparator;

/**
 * Created by linken on 12/5/15.
 */
public class BinaryNode {
    BinaryNode(Comparable theElemen) {
        this(theElemen, null, null);
    }

    BinaryNode(Comparable element, BinaryNode left_, BinaryNode right_) {
        value = element ;
        left  = left_;
        right = right_;

    }

    BinaryNode right;
    BinaryNode left;
    Comparable value;
}
