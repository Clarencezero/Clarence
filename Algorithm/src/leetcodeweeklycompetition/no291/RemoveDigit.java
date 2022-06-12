package leetcodeweeklycompetition.no291;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveDigit {
    public static void main(String[] args) {
        RemoveDigit go = new RemoveDigit();
        String s = "1231";
        char c = '1';
        System.out.println(go.removeDigit(s, c));
    }
    public String removeDigit(String number, char digit) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String s = number.substring(0, i) + number.substring(i + 1);
                res.add(s);
            }
        }
        Collections.sort(res);
        return String.valueOf(res.get(res.size() - 1));
    }
}
