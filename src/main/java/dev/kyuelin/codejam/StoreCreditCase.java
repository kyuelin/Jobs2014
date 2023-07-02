package dev.kyuelin.codejam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StoreCreditCase {

    private final int items;
    private final int credit;
    private final int[] itemsPrices;
    private int[] itemsFound;

    StoreCreditCase(int items_, int credit_, int[] prices_) {
        this.items=items_;
        this.credit=credit_;
        this.itemsPrices=prices_;
    }

    public void findItems() {
        for(int i=0; i<items; i++) {
            for (int j=i+1; j<items;j++) {
                if((itemsPrices[i]+itemsPrices[j]) == credit) {
                    itemsFound=new int[2];
                    itemsFound[0]=i;
                    itemsFound[1]=j;
                    return;
                }// if
            } //for j
        }//for
    }//finditems

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int case_counts = scan.nextInt();

        List<StoreCreditCase> cases = new ArrayList<StoreCreditCase>();

        for (int i=0;i<case_counts; i++) {
            int credit=scan.nextInt();
            int item_count=scan.nextInt();
            int[] items=new int[item_count];
            String itemsList = scan.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(itemsList);
            int j=0;
            while(tokenizer.hasMoreTokens()){
                String price = tokenizer.nextToken();
                items[j++]=Integer.parseInt(price);
            }//while
            StoreCreditCase sccase = new StoreCreditCase(item_count, credit, items);
            sccase.findItems();
            cases.add(sccase);
        }//for
    }//main

} // StoreCreditCase


