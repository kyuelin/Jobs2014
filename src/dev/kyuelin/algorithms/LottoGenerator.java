package dev.kyuelin.algorithms;

import dev.kyuelin.utilities.IntGenerator;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by linken on 5/5/16.
 */
public class LottoGenerator {
    public static int[] genWhiteBalls(int size, int num_range) {
        int s = size+1; // to get the
        int r = num_range+1;
        int[] wbs = IntGenerator.genUniqIntArray(s, r);
        while (wbs.length != size) {
            wbs = IntGenerator.genUniqIntArray(s, r);
        }
        Arrays.sort(wbs);
        return wbs;
    }

    public static int genPowerBall(int num_range) {
        int pb = new Random(System.nanoTime()).nextInt(num_range+1);
        return  pb;
    }

    public static void main(String[] args) {
        int group = 3;

        for (int i=0; i<group; i++) {
            int[] wbs = genWhiteBalls(5,69);
            Arrays.sort(wbs);
            System.out.format("%s  %d\n", Arrays.toString(wbs),(new Random(System.nanoTime())).nextInt(27));
        }
    }
}
