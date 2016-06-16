package dev.kyuelin.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by linken on 6/15/16.
 */
public class FriendCircles3 {

    static int friendCircles(String[] friends) {

        if (friends == null || friends.length==0)
            return 0;
        //
        int N = friends.length;

        //
        int count=0;
        for (int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(friends[i].charAt(j) == 'Y') {
                    count++;
                    markChecked(friends, i, j);
                }
            }
        }

        return count;
    }

    static void markChecked(String[] friends, int i, int j) {
        int n = friends.length;
        if (i<0||i>=n||j<0||j>=n||friends[i].charAt(j)!='Y')
            return;

        char[] chars = friends[i].toCharArray();
        chars[j]='X';
        friends[i]=String.valueOf(chars);
        markChecked(friends, i-1, j);
        markChecked(friends, i+1, j);
        markChecked(friends, i, j-1);
        markChecked(friends, i, j+1);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _friends_size = 0;
        _friends_size = Integer.parseInt(in.nextLine().trim());
        String[] _friends = new String[_friends_size];
        String _friends_item;
        for(int _friends_i = 0; _friends_i < _friends_size; _friends_i++) {
            try {
                _friends_item = in.nextLine();
            } catch (Exception e) {
                _friends_item = null;
            }
            _friends[_friends_i] = _friends_item;
        }

        res = friendCircles(_friends);
        System.out.println(res);
        //bw.write(String.valueOf(res));
        //bw.newLine();

        //bw.close();
    }

}
