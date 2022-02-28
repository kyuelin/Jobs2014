package dev.kyuelin.progcreek;

/**
 * Created by linken on 4/13/16.
 */
public class AddBinary {
    public static String addBinary(String s1, String s2) {
        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();
        int len = s1.length()<s2.length()?s1.length():s2.length();
        StringBuilder sb = new StringBuilder();
        int esflag=0;
        for (int i=0; i<len; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == '1' && c2 == '1') {
                if (esflag == 0) {
                    sb.append('0');
                }
                else {
                    sb.append('1');
                }
                esflag=1;
            }
            else if (c1 == '0' && c2 == '0') {
                if (esflag==0) {
                    sb.append('0');
                }
                else {
                    sb.append('1');
                }
                esflag=0;
            }
            else {
                sb.append('1');
                esflag=0;
            }
        }
        int gap=s1.length()-s2.length();

        String s=null;

        if (gap > 0) {
           s = s1;
        }
        else {
            s = s2;
        }

        for (int i=Math.abs(gap); i<s.length(); i++ ) {
            if (s.charAt(i)== '1')  {
                if (esflag==0) {
                    sb.append('1');
                    esflag=0;
                }
                else {
                    sb.append('0');
                    esflag=1;
                }
            }
        }
        if (esflag==1) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    public static String addBinary2(String s1, String s2) {
        int l1=s1.length()-1;
        int l2=s2.length()-1;

        int eflag=0;
        StringBuilder sb = new StringBuilder();
        while(l1>=0 || l2>=0) {
            int v1=0;
            int v2=0;
            int sum=0;

            if (l1>=0) {
                v1=s1.charAt(l1) == '1' ? 1 : 0;
                l1--;
            }
            if (l2 >=0) {
                v2 = s2.charAt(l2) == '1'?1:0;
                l2--;
            }
            sum = v1+v2+eflag;
            if (sum >= 2) {
                eflag=1;
                sum -= 2;
            }
            else {
                eflag=0;
            }

            sb.append(sum);

        }
        if (eflag==1) {
            sb.append('1');
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        String s1 = "100100111";
        String s2 = "1100101";
        //System.out.println(AddBinary.addBinary(s1,s2));
        System.out.println(AddBinary.addBinary2(s1,s2));
    }
}
