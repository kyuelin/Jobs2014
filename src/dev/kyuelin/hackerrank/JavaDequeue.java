package dev.kyuelin.hackerrank;

/**
 * Created by kennethlin on 6/19/16.
 */
public class JavaDequeue {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
        }
        System.out.println(checkMaxUnique(deque, m));
    }

    private static int checkMaxUnique(Deque deque, int m) {
        Map<Integer, Integer> imap = new HashMap<>();

        Deque<Integer> tdeq = new LinkedList<>();

        Integer first = (Integer)deque.removeFirst();
        tdeq.add(first);
        addUniqueInt(first, imap);

        Integer second = (Integer)deque.removeFirst();
        tdeq.add(second);
        addUniqueInt(second, imap);

        Integer third = (Integer)deque.removeFirst();
        tdeq.add(third);
        addUniqueInt(third, imap);

        int max_unique = imap.keySet().size();
        while(!deque.isEmpty()) {
            first = tdeq.removeFirst();
            removeUniqueInt(first, imap);
            third = (Integer) deque.removeFirst();
            tdeq.add(third);
            addUniqueInt(third, imap);
            max_unique = Math.max(max_unique, imap.keySet().size());
        }
        return max_unique;
    }

    public static void addUniqueInt(Integer unint, Map<Integer, Integer> imap) {
        if (imap.containsKey(unint)) {
            imap.put(unint, imap.get(unint)+1);
        }
        else {
            imap.put(unint, 1);
        }
    }

    public static void removeUniqueInt(Integer unint, Map<Integer, Integer> imap) {
        if(imap.get(unint) > 1) {
            imap.put(unint, imap.get(unint)-1);
        }
        else {
            imap.remove(unint);
        }
    }
}
