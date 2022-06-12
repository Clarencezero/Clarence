package leetcodeweeklycompetition.no292;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestGoodInteger {
    public static void main(String[] args) {
        LargestGoodInteger go = new LargestGoodInteger();
        String num = "222";
        System.out.println(go.largestGoodInteger(num));
    }
    public String largestGoodInteger(String num) {
        if (num == null || num.length() == 0) return "";
        int index = 1, len = num.length();
        List<String> res = new ArrayList<>();
        char pre = num.charAt(0);
        int preStart = 0;
        while (index < len) {
            if (num.charAt(index) != pre) {
                if (index - preStart >= 3) {
                    res.add(num.substring(preStart, preStart + 3));
                }
                pre = num.charAt(index);
                preStart = index;
            }
            index++;
        }
        if (index - preStart >= 3) {
            res.add(num.substring(preStart, preStart + 3));
        }
        Collections.sort(res);
        return res.size() > 0 ? res.get(res.size() - 1) : "";
    }
}
