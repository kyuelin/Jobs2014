package dev.kyuelin.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by linken on 6/15/16.
 */
public class LongestChain {

    static int longestChain(String[] words) {

        // input validation
        if (words == null || words.length == 0) return 0;

        // sort the words list by length
        class comp implements Comparator<String> {
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        }
        Arrays.sort(words, new comp());

        // use a Set to store the dictionary
        Set<String> wset = new HashSet<String>(Arrays.asList(words));

        // for each word in the word list,
        // lookup dictionary after each character-removal
        // remove the targeted word from the dictionary if there is no valid removal at all
        for(int i=0; i<words.length;i++) {

            String str = words[i];
            int wlen = str.length();
            int widx = 0;
            if(wlen>1) {
                boolean flag = false;
                while(widx < wlen) {
                    String temp = str;
                    temp = temp.substring(0,widx) + temp.substring(widx+1);
                    if (wset.contains(temp)) {
                        flag = true;
                        break;
                    }
                    widx++;
                }
                if (flag == false) {
                    wset.remove(str);
                }
            }
        }

        // find the longest valid word
        int maxlen = 0;
        for (String s : wset) {
            maxlen = Math.max(maxlen, s.length());
        }

        return maxlen;
    }

    public static void main(String[] args) {
        String[] input = {"ba", "b", "bca", "bda", "kbda", "k", "g"};
        System.out.println(longestChain(input));
    }
}
