package dev.kyuelin.progcreek;

import java.util.Arrays;

/**
 * Created by linken on 5/8/16.
 */
public class BestTimeBuyStock {
    public static int[] best(float[] prices) {
        int[] times = new int[2];
        times[0]=-1;
        times[1]=-1;
        float low=prices[0], high=-1,maxp=0;
        int li=0, hi=-1;
        for(int i=1; i<prices.length;i++) {
            if(prices[i-1] < prices[i]) {
                high=prices[i];
                hi=i;
            }
            if(prices[i-1] > prices[i]) {
                if(high>0 && low>0) {
                    float p = high-low;
                    if(p>maxp) {
                        maxp=p;
                        times[0]=li;
                        times[1]=hi;
                    }
                    li=i;
                    hi=-1;
                    low=prices[i];
                    high=-1;
                }
                if(high < 0) {
                    low=prices[i];
                    li=i;
                }
            }
        }
        return times;
    }

    public static float maxProfit(float[] prices) {
        float profit = 0;
        float minElement = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            profit = Math.max(profit, prices[i]-minElement);
            minElement = Math.min(minElement, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) throws IOException {
        //int[] prices = IntGenerator.genFixedSizeIntArray(30,100);
        FileReader pfile = new FileReader("/Users/linken/Downloads/ms.2k16");
        BufferedReader bread = new BufferedReader(pfile);
        String line = null;
        float[] prices=new float[100];
        int i=0;
        while((line=bread.readLine()) != null)  {
            prices[i++]=Float.parseFloat(line);
        }


        int[] times = best(prices);
        System.out.println(Arrays.toString(prices));
        System.out.format("times[%d,%d] : prices[%f,%f]\n" , times[0], times[1], prices[times[0]], prices[times[1]]);
        System.out.println(maxProfit(prices));
    }
}
