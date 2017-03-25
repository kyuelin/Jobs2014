package dev.kyuelin.checksum;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.zip.Adler32;

/**
 * Created by kennethlin on 3/25/17.
 */
public class Adler32Demo {

    public static void main(String[] args) {

        byte[] bytes = new byte[2000];

        Adler32 adler = new Adler32();

        IntStream.range(1, 10).forEach(
                npr -> {
                    try {
                        SecureRandom.getInstanceStrong().nextBytes(bytes);
                    } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                    }
                    adler.reset();
                    adler.update(bytes);
                    System.out.println("befor rs - " + adler.getValue() + ":" + Arrays.toString(bytes));
                }
        );
    }

    public static String byteToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        //Arrays.asList(bytes).stream().forEach(b -> builder.append(Integer.toHexString(b & 0xFF)));
        return builder.toString();
    }
}
