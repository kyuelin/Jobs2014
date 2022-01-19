package dev.kyuelin.progcreek;

/**
 * Created by linken on 6/30/16.
 */
public class ReverseWordsInAString {
    public static String reverse(String a) {
        String[] ws = a.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=ws.length-1; i>=0; i--) {
            sb.append(ws[i]).append(" ");
            /*
            if (!ws[i].equals("")) {
                sb.append(ws[i]).append(" ");
            }
            */
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length()-1);
    }
    public static void main(String[] args) {
        System.out.println(reverse("the sky is blue"));
    }
}
