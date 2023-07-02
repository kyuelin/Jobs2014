package dev.kyuelin.progcreek;

/**
 * Created by kennethlin on 4/28/16.
 */
public class CountAndSay {
    public static void cas(String input, int loop) {
        if(input == null || input.length() == 0) return;
        String result = String.valueOf(input.charAt(0));
        while(loop>=0) {
            int count=1;
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<result.length(); i++) {
                if (result.charAt(i) != result.charAt(i-1)) {
                    sb.append(count);
                    sb.append(result.charAt(i-1));
                    count=1;
                }
                else {
                    count++;
                }
            }
            sb.append(count);
            sb.append(result.charAt(result.length()-1));
            result = sb.toString();
            System.out.format("%3d:%s\n", loop, result);
            loop--;
        }
    }
    public static void main(String[] args) {
        String input = "4";
        cas(input, 5);

    }
}
