package dev.kyuelin.crackingcoding;

/**
 * Created by linken on 12/19/15.
 */
public class Question1_3 {
    public static String manipulate(String input) {
        char[] carr = input.toCharArray();
        int toMove = carr.length - 1;
        int firstempty = 0;
        for (int i = toMove; i >= 0; i--) {
            if (carr[i] != ' ') {
                if (toMove != i){
                    carr[toMove] = carr[i];
                    carr[i] = ' ';
                }
                toMove--;
                firstempty = 1;
            }//if
            else if (firstempty == 1) {
                carr[toMove--] = '0';
                carr[toMove--] = '2';
                carr[toMove--] = '%';
                firstempty=0;
                i=i-2;
            }
        }//else
        return String.valueOf(carr);
    }//manipulate

    public static void replaceSpaces(char[] str, int length) {
        int spaceCount=0, newLength, i;
        for(i=0; i<length; i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }
        newLength = length + spaceCount*2;
        str[newLength] = '\0';
        for(i=length-1; i>=0; i--) {
            if(str[i] == ' ') {
                str[newLength-1] = '0';
                str[newLength-2] = '2';
                str[newLength-3] = '%';
                newLength = newLength - 3;
            }
            else {
                str[newLength-1] = str[i];
                newLength=newLength-1;
            }
        }
    }

    public static void main(String[] args) {
        String test="Mr John Smith    ";
        char[] testArray=test.toCharArray();
        //String test="Mr   John   Smith";
        System.out.println(test);
        //System.out.println(manipulate(test));
        replaceSpaces(testArray, testArray.length);
        System.out.println(testArray);
    }
}
