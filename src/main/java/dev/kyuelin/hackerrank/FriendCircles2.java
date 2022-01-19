package dev.kyuelin.hackerrank;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by linken on 6/15/16.
 */
public class FriendCircles2 {

    static int friendCircles(String[] friends) {
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

        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        int[] root = new int[N*N];
        int count=0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(fs[i][j]=='Y'){
                    root[i*N+j] = i*N+j;
                    count++;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(fs[i][j]=='Y'){
                    for(int k=0; k<4; k++){
                        int x = i+dx[k];
                        int y = j+dy[k];

                        if(x>=0&&x<N&&y>=0&&y<N&&fs[x][y]=='Y'){
                            int cRoot = getRoot(root, i*N+j);
                            int nRoot = getRoot(root, x*N+y);
                            if(nRoot!=cRoot){
                                root[cRoot]=nRoot; //update previous node's root to be current
                                count--;
                            }

                        }
                    }
                }
            }
        }

        return count;
    }

    public static int getRoot(int[] arr , int i){
        while(arr[i]!=i){
            i = arr[arr[i]];
        }
        return i;
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
