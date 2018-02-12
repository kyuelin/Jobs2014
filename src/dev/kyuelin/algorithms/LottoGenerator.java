package dev.kyuelin.algorithms;

import dev.kyuelin.utility.IntGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by linken on 5/5/16.
 */
public class LottoGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(LottoGenerator.class);

    private static int[] genWhiteBalls(int size, int numrange) {
        int s; // to get the
        s = size + 1;
        int r = numrange + 1;
        int[] wbs = IntGenerator.genUniqIntArray(s, r);
        while (size != wbs.length) {
            wbs = IntGenerator.genUniqIntArray(s, r);
        }
        Arrays.sort(wbs);
        return wbs;
    }

    public static int genPowerBall(int numrange) {
        return new Random(System.nanoTime()).nextInt(numrange + 1);
    }

    public static void main(String[] args) {
        int group = 3;

        for (int i=0; i<group; i++) {
            int[] wbs = genWhiteBalls(5,69);

            LOGGER.info("%s  %d", Arrays.toString(wbs), (new Random(System.nanoTime())).nextInt(27));
        }
    }
}
