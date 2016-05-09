package dev.kyuelin.progcreek;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linken on 5/6/16.
 */
public class EditDistance {
    public static int distance(String src, String tgt) {
        Map<Character, Integer> cmap = new HashMap<>();
        Map<Character, Integer> imap = new HashMap<>();
        for(Character c:tgt.toCharArray()) {
            if (cmap.containsKey(c)) {
                Integer i = cmap.get(c);
                cmap.put(c, i+1);
            }
            else {
                cmap.put(c,1);
            }
        }

        for (Character c:src.toCharArray()) {
            if(cmap.containsKey(c)) {
                Integer i = cmap.get(c);
                if (i==1) {
                    cmap.remove(c);
                }
                else {
                    cmap.put(c, i-1);
                }
            }
            else {
                if (imap.containsKey(c)) {
                    Integer i = cmap.get(c);
                    imap.put(c, i+1);
                }
                else {
                    imap.put(c,1);
                }
            }
        }

        int ccnt=0;
        for (Map.Entry entry: cmap.entrySet()) {
            ccnt += (Integer)entry.getValue();
        }
        int icnt=0;
        for (Map.Entry entry: imap.entrySet()) {
            icnt += (Integer)entry.getValue();
        }

        return Math.max(ccnt, icnt);
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        //iterate though, and check last char
        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);

                //if last two chars equal
                if (c1 == c2) {
                    //update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {

        /*
        String[] tgtl= new String[]{"insert", "remove", "distance"};
        String[] srcl = new String[]{"firstarg", "secondarg", "thirdarg"};

        for(int i=0; i<tgtl.length; i++) {
            String src=srcl[i];
            String tgt=tgtl[i];
            System.out.format("src=%s, tgt=%s, distance=%d, minDist=%d\n", src, tgt, distance(src, tgt), minDistance(src, tgt));
        }
        */

        String src="distance";
        String tgt="thirdarg";
        System.out.format("src=%s, tgt=%s, distance=%d, minDist=%d\n", src, tgt, distance(src, tgt), minDistance(src, tgt));
    }
}
