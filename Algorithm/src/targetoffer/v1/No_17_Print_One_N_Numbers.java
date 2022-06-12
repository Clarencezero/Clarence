package jianzhioffer;

public class No_17_Print_One_N_Numbers {
    public static void main(String[] args) {

    }

    public int[] printNumbers(int n) {
        char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int finalNum = (int) (Math.pow(10, n) - 1);

        int[] result = new int[finalNum];

        // doRecursive(n, loop, result);

        return result;
    }


}

/**
 * 这里主要是考查大数问题，因为使用int、long、double 最终都会有最大值，所以，使用字符串拼接是一种不错的解题思路。
 * 这里使用递归方式循环遍历，当位数相等时可以输出拼接值并写入数组中
 */
class Soluction_2 {
    static int count = 0;
    static char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static int k;

    public int[] printNumbers(int n) {
        int maxNumber = (int) (Math.pow(10, n) - 1);
        int[] res = new int[maxNumber];
        k = n;
        char[] temp = new char[n];
        doRecursion(0, temp, res);
        return res;
    }

    public void doRecursion(int poi, char[] temp, int[] res) {
        if (poi == k) {
            int i = Integer.parseInt(String.valueOf(temp));
            if (i < 1) {
                return;
            }

            res[count++] = i;
            return;
        }

        // 在 for 循环里面实现递归
        for (char c : loop) {
            // 记录当前位置的值
            temp[poi] = c;
            // 递归下一个位置
            doRecursion(poi + 1, temp, res);
        }
    }

    public static void main(String[] args) {
        Soluction_2 solution = new Soluction_2();
        int[] ints = solution.printNumbers(2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        // Stream.of(ints).forEach(System.out::print);
    }
}

class Soluction_1 {
    StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        return res.toString(); // 转化为字符串并返回
    }

    void dfs(int x) {
        if (x == n) { // 终止条件：已固定完所有位
            res.append(Integer.valueOf(String.valueOf(num))).append(","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for (char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // 开启固定第 x + 1 位
        }
    }

    public static void main(String[] args) {
        Soluction_1 one = new Soluction_1();
        System.out.println(one.printNumbers(2));
        // System.out.println(one.printNumbers(3));
    }
}