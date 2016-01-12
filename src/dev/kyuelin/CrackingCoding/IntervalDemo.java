package dev.kyuelin.CrackingCoding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linken on 1/10/16.
 */
public class IntervalDemo {

    public static class Interval {
        private int low;
        private int high;

        public int getHigh() {
            return this.high;
        }

        public int getLow() {
            return this.low;
        }

        public Interval(int low, int high) {
            this.high = high;
            this.low = low;
        }

        public String toString() {
            return "(" + low + "," + high + ")";
        }
    }

    public static class IntervalList {
        private List<Interval> list = new ArrayList<>();

        public List<Interval> getList() {
            return this.list;
        }

        public void add(Interval intvl) {
            this.list.add(intvl);
        }

        public IntervalList intercept(IntervalList list2) {
            IntervalList outList = new IntervalList();
            List<Boolean> tmplist = new ArrayList<Boolean>();
            int index = 0;
            for (Interval i : this.list) {
                while (index <= i.high) {
                    if (index < i.low) {
                        tmplist.add(false);
                    }
                    else {
                        tmplist.add(true);
                    }
                    index++;
                }
            }//for

            int index2 = 0;
            int high2 = 0;
            for (Interval v : list2.getList()) {
                while (index2 <= v.getHigh()) {
                    if (index2 < v.getLow()) {
                        tmplist.set(index2, false);
                    }
                    else if (index2 >= tmplist.size()) {
                        tmplist.add(index2, false);
                    }
                    else {
                        tmplist.set(index2, true && tmplist.get(index2));
                    }
                    index2++;
                }//for
                high2 = v.getHigh();
            }
            if (high2 < tmplist.size()) {
                while (index2 < tmplist.size()) {
                    tmplist.set(index2++, false);
                }
            }

            int tmplow = 0;
            int tmphigh = 0;
            int ind = 0;
            boolean lowFlag = false;
            while (ind < tmplist.size()) {
                if (tmplist.get(ind) == true && lowFlag == false) {
                    tmplow = ind;
                    lowFlag = true;
                }
                if (tmplist.get(ind) == false && lowFlag == true) {
                    tmphigh = ind - 1;
                    lowFlag = false;
                    outList.add(new Interval(tmplow, tmphigh));
                }
                ind++;
            } //while
            return outList;
        } // intercept

        public String toString() {
            StringBuffer buff = new StringBuffer();
            buff.append("{");
            for (Interval n : this.list) {
                buff.append(n.toString());
                buff.append(",");
            }
            buff.deleteCharAt(buff.length()-1);
            buff.append("}");

            return buff.toString();
        }
    }//IntervalList

    public static void main(String[] args) {
        IntervalList list1 = new IntervalList();
        //list1.add(new Interval(9, 13));
        list1.add(new Interval(1, 13));
        list1.add(new Interval(16, 19));

        IntervalList list2 = new IntervalList();
        list2.add(new Interval(1, 5));
        list2.add(new Interval(6, 10));

        IntervalList listOut = list1.intercept(list2);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        System.out.println(listOut.toString());
    }


}
