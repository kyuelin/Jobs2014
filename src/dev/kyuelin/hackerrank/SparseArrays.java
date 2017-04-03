package dev.kyuelin.hackerrank;

/**
 * Created by linken on 6/18/16.
 */
public class SparseArrays {
    public static void main(String[] args) {
        Map<String, Integer> smap = new HashMap<String, Integer>();
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        while(N>0) {
            String in = scan.nextLine();
            //System.out.println(N + ":" + in);
            if(smap.containsKey(in)) {
                smap.put(in, smap.get(in).intValue()+1);
            }
            else {
                smap.put(in, 1);
            }
            N--;
        }

        List<Integer> results = new ArrayList<>();
        int Q = scan.nextInt();
        scan.nextLine();
        while(Q>0) {
            String in = scan.nextLine();
            if(!smap.containsKey(in)) results.add(0);
            else results.add(smap.get(in));
            Q--;
        }

        for(Integer i:results) {
            System.out.println(i);
        }
    }
}
