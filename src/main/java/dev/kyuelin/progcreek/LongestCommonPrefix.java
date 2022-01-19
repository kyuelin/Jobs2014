package dev.kyuelin.progcreek;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kennethlin on 4/25/16.
 */
public class LongestCommonPrefix {
    public static void findLongestPrefix(String[] input) {
        // find shortest string
        //
        Map<Character, Integer> mapByFirstChar = new HashMap<>();
        Map<Character, String> mapByShortestString = new HashMap<>();
        for (String s : input) {
            char c = s.charAt(0);
            if (mapByFirstChar.containsKey(c)) {
                mapByFirstChar.put(c, mapByFirstChar.get(c) + 1);
            } else {
                mapByFirstChar.put(c, 1);
            }
            if (mapByShortestString.containsKey(c)) {
                if (s.length() < mapByShortestString.get(c).length()) {
                    mapByShortestString.put(c, s);
                } else {
                    mapByShortestString.put(c, s);
                }
            }
        }
        int mostCommCharCount = 0;
        String mostCommonShortestString = null;
        for (Map.Entry entry : mapByFirstChar.entrySet()) {
            if ((Integer) entry.getValue() > mostCommCharCount) {
                mostCommCharCount = (Integer) entry.getValue();
                mostCommonShortestString = mapByShortestString.get(entry.getKey());
            }
        }

        Map<String, Integer> prefixCountMap = new HashMap<>();
        for (int i = 1; i <= mostCommonShortestString.length(); i++) {
            String prefix = mostCommonShortestString.substring(0, i);
            prefixCountMap.put(prefix, 1);
        }

        for (String s : input) {
            for (int i = 1; i <= s.length(); i++) {
                String prefixSub = s.substring(0, i);
                if (prefixCountMap.containsKey(prefixSub)) {
                    prefixCountMap.put(prefixSub, prefixCountMap.get(prefixSub) + 1);
                }
            }
        }

        int longcount = 0;
        String longsubstr = null;
        for (Map.Entry<String, Integer> entry : prefixCountMap.entrySet()) {
            if (entry.getValue() > longcount) {
                longcount = entry.getValue();
                longsubstr = entry.getKey();
            }
        }
        System.out.format("longcount = %d, longsubstr=%s", longcount, longsubstr);
    }


}

