package dev.kyuelin.leetcode;

public class AddString {
    public static String stringReverse(final String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=input.length()-1; i >= 0; i--) {
            stringBuilder.append(input.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String addStrings(String num1, String num2) {
        num1 = stringReverse(num1);
        num2 = stringReverse(num2);

        StringBuilder stringBuilder = new StringBuilder();

        String largeNum = num1;
        String smallNum = num2;
        int largeLen = num1.length();
        int smallLen = num2.length();

        if (largeLen < smallLen) {
            largeNum = num2;
            smallNum = num1;
            int temp = largeLen;
            largeLen = smallLen;
            smallLen = temp;
        }

        // 456 + 17
        // 654, 71

        // 3, 2

        // i1: 0, 1
        // ten : false, true, false
        // temp: 13 (3), 7
        // sb: 3, 7, 4
        // 5+1+1
        // i2: 2,3
        // lchar: 4
        // temp : 4
        //473
        boolean ten = false;
        char schar;
        char lchar;
        int i1=0;
        while (i1 < smallLen) {
            schar = smallNum.charAt(i1);
            lchar = largeNum.charAt(i1);

            int temp = Character.getNumericValue(schar) + Character.getNumericValue(lchar);
            if (true == ten) {
                ++temp;
            }
            if(temp >= 10) {
                ten = true;
                temp -= 10;
            }
            else {
                ten = false;
            }
            stringBuilder.append(temp);
            i1++;
        }
        int i2=smallLen;
        while(i2 < largeLen) {
            lchar = largeNum.charAt(i2);
            int temp = Character.getNumericValue(lchar);
            if (true == ten) {
                temp++;
            }
            if (temp >= 10) {
                ten = true;
                temp -= 10;
            }
            else {
                ten = false;
            }
            stringBuilder.append(temp);
            i2++;
        }
        if (true == ten) {
            stringBuilder.append(1);
        }

        String result = stringReverse(stringBuilder.toString());
        return result;
    }

    public static void main (String[] args) {
        System.out.println(AddString.addStrings("456", "77"));
    }
}
