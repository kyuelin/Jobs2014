package dev.kyuelin.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kennethlin on 6/24/17.
 */
public class FileIODemo {
    private static final String inputfile = "/Users/kennethlin/Downloads/NYPD_Motor_Vehicle_Collisions.csv";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            String line = null;
            FileReader fileReader = new FileReader(inputfile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line=bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Time taken: " + (System.currentTimeMillis()-start)/1000 + "s");
    }

}
