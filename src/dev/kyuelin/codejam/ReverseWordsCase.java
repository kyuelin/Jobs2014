package dev.kyuelin.codejam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by linken on 12/13/15.
 */
public class ReverseWordsCase {

    private int case_num;
    private List<String> words;

    ReverseWordsCase(int num_, List<String> words_){
        this.case_num=num_;
        this.words=words_;
    }//const
    public List<String> reverse() {
        int count=words.size();
        List<String> rwords=new ArrayList<String>(count);
        for (int i=count-1; i>=0;i--) {
            rwords.add(words.get(i));
        }//for
        return rwords;
    }//reverse

    public static void reverse(List<String> words, int index) {
        if (index==0) return;
        reverse(words, index-1);
        System.out.println(words.get(index));
    }//reverse

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int case_count=scan.nextInt();
        scan.nextLine();
        List<ReverseWordsCase> cases = new ArrayList<ReverseWordsCase>(case_count);
        for(int i=0;i<case_count;i++) {
            String sentence = scan.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(sentence);
            List<String> ws = new ArrayList<String>();
            while(tokenizer.hasMoreTokens()) {
                ws.add(tokenizer.nextToken());
            }//while
            ReverseWordsCase rwcase = new ReverseWordsCase(i+1,ws);
            cases.add(rwcase);
        }//for

        for(ReverseWordsCase rwc : cases) {
            reverse(rwc.words, rwc.words.size()-1);
        }
    }//main
}//class


