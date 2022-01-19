package dev.kyuelin.hackerrank;

/**
 * Created by linken on 6/30/16.
 */
public class Bloomberg {
    public static void isPalindrome() {
        String input = "121221";
        int i = 0;
        int j = input.length() - 1;
        while (i < j && input.charAt(i) == input.charAt(j)) {
            i++;
            j--;
        }
        if (i < j) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    public static void isSymmetric() {
        int[] tree = new int[]{1, 2, 2, 3, 4, 4, 3};
        if (!isSymmetric(tree, 1, 2)) {
            System.out.println("N");
        } else {
            System.out.printf("Y");
        }
    }

    public static boolean isSymmetric(int[] tree, int l, int r) {
        System.out.format("(%d,%d)\n",l, r);
        if (l >= tree.length && r >= tree.length) return true;
        if (l < tree.length && r < tree.length && tree[l] == tree[r]) {
            return (isSymmetric(tree, 2 * l + 1, 2 * r + 2) && isSymmetric(tree, 2 * l + 2, 2 * r + 1));
        }
        return false;
    }

    public static void reverseInt() {
        int test = 4321;
        int result=0;
        while(test>0) {
            result = result*10 + test%10;
            test = test/10;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        //isSymmetric();
        reverseInt();
    }
}
