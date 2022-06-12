package jianzhioffer;

/**
 * 递增数组->截取一部分放置原数组后面。
 * 要点: 二分法判断。让中间数值与最右边比较，如果中间值较大，则表示最小值在右边，如果中间值较小，则表示最小值在左边。如果相等，则右值-1，继续二分法查找。
 */
public class No_11_ArrayTheminNumber {
    public static void main(String[] args) {
        int[] data = {3,4,5,1};
        System.out.println(minArray_1(data));
    }
    public static int minArray_1(int[] numbers) {
        if (numbers.length == 0)
            return -1;
        if (numbers.length == 1)
            return numbers[0];
        int i =0, j = numbers.length - 1;
        while (j > i) {
            int mid = (i + j)/2; // 取小值
            if (numbers[mid] > numbers[j]) {
                // 在右边,+1不要忘记了
                i = mid + 1;
            } else if (numbers[mid] < numbers[j]) {
                // 在右边
                j = mid;
            } else {
                // 相等
                j--;
            }
        }
        return numbers[i];

    }
}

