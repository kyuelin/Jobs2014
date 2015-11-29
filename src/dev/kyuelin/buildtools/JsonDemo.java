package dev.kyuelin.buildtools;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by linken on 5/4/15.
 */
public class JsonDemo {
    public static void main(String[] args) {
        GeoLocRecord rec = new GeoLocRecord();
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("glrec.json"), rec);
            System.out.println(mapper.writeValueAsString(rec));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
