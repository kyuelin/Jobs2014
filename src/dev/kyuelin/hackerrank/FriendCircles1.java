package dev.kyuelin.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by linken on 6/15/16.
 */
public class FriendCircles1 {

    static int friendCircles(String[] friends) {
        // input validation
        if (friends == null || friends.length==0)
            return 0;

        // loop through friends list using DFS
        int count=0;
        for (int i=0; i<friends.length; i++) {
            for(int j=0; j<=i; j++) {
                if(friends[i].charAt(j) == 'Y') {
                    count++;
                    markChecked(friends, i, j);
                }
            }
        }

        return count;
    }

    // recursively find and marked relationship visited
    static void markChecked(String[] friends, int i, int j) {
        int n = friends.length;
        if (i < 0 || i >= n || j < 0 || j >= n || friends[i].charAt(j) != 'Y')
            return;
        char[] fs = friends[i].toCharArray();
        fs[j] = 'X';
        friends[i] = String.valueOf(fs);
        for (int k = 0; k < n; k++) {
            markChecked(friends, j, k);
        }
    }

    /*    static int friendCircles(String[] friends) {

        if (friends == null || friends.length==0)
            return 0;
        //
        int N = friends.length;
        char[][] fs = new char[N][N];
        for (int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                fs[i][j] = friends[i].charAt(j);
            }
        }

        //
        int count=0;
        for (int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(fs[i][j] == 'Y') {
                    count++;
                    markChecked(fs, i, j);
                }
            }
        }

        return count;
    }


    static void markChecked(char[][] friends, int i, int j) {
        int n = friends.length;
        if (i<0||i>=n||j<0||j>=n||friends[i][j]!='Y')
            return;
        friends[i][j]='X';
        markChecked(friends, i-1, j);
        markChecked(friends, i+1, j);
        markChecked(friends, i, j-1);
        markChecked(friends, i, j+1);
    }
    */

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
