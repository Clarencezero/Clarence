package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No_93_restoreIpAddresses {
    public static void main(String[] args) {
        No_93_restoreIpAddresses go = new No_93_restoreIpAddresses();
        List<String> list = go.restoreIpAddresses("25525511135");
        for (String s : list) {
            System.out.println(s);
        }
    }

    List<String> path = new ArrayList<>();
    List<String> res = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len > 12 || len < 4) return res;
        backTracking(s, len, 0, 0);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割
    private void backTracking(String s, int len, int startIndex, int dotNum) {
        if (dotNum > 4) return;
        // 终止条件：到达末尾且dotNum=4
        if (startIndex == len) {
            if (dotNum == 4) {
                res.add(String.join(".", path));
            }
            return;
        }

        // startIndex +3 表示每个结点最多有3个截取方式：截取1位、截取2位、截取3位
        // 大剪枝
        for (int i = startIndex; i < startIndex + 3; i++) {

            if (i >= len) {
                break;
            }

            // 大剪枝
            // System.out.println("dotNum: " + dotNum + ", least need: " + dotNum + ", most need : " + dotNum * 3 +  ", remain size: " + (len - i + 1));
            System.out.println("good: " + good(dotNum, dotNum * 3, (len - i + 1)));
            if (!good(dotNum, dotNum * 3, len - i + 1)) {
                System.out.println("dotNum: " + dotNum + ", least need: " + dotNum + ", most need : " + dotNum * 3 +  ", remain size: " + (len - i + 1));
            }
            // if (dotNum > (len - i + 1)) {
            //     continue;
            // }

            // 判断区间内（左闭右闭）的字符串是符合IP地址的条件
            if (isValidString(s, startIndex, i)) {
                // 字符串截取操作是左闭右开区间
                // 添加到path中
                String currentIpSegment = s.substring(startIndex, i + 1);
                path.add(currentIpSegment);
                // i+1表示指针向右移动一格，区间增大，
                backTracking(s, len, i + 1, dotNum + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    // 判断左闭右闭区间内的字符串的数字是否合法
    private boolean isValidString(String s, int left, int right) {
        if (left > right) return false;

        // 首位为0的数字不合法
        if (s.charAt(left) == '0' && left != right) return false;

        int nums = 0;
        char c;
        while (left <= right) {
            c = s.charAt(left);
            if (c - '9' > 0 || c - '0' < 0) return false;

            nums = nums * 10 + (c - '0');
            if (nums > 255) return false;
            left++;
        }
        return true;
    }

    private boolean good(int least, int most, int comp) {
        if (least == 0) return true;
        if (comp >= least && comp <= most) return true;
        else return false;
    }
}
