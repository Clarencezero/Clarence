package util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static void printArray(int[] arr, String info) {
        System.out.print(info + ": ");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        if (arr.length == 0) return;
        StringBuilder sb = new StringBuilder("[");
        int j = 0;
        for (int i : arr) {
            sb.append(i).append("(").append(j++).append(")").append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        System.out.println(sb);
    }

    public static void printTwoDimensionalArray(int[][] arr, String info) {
        System.out.println(info);
        printTwoDimensionalArray(arr);
    }
    public static void printTwoDimensionalArray(boolean[][] arr, String info) {
        System.out.println(info);
        printTwoDimensionalArray(arr);
    }

    public static void printTwoDimensionalArray(boolean[][] arr) {
        for (boolean[] ints : arr) {
            for (boolean i : ints) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }

    public static void printTwoDimensionalArray(int[][] arr) {
        for (int[] ints : arr) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }

    public static void print(List<? extends Object> data, Object ... arg) {
        StringBuilder sb = new StringBuilder("[");
        for (Object o : data) {
            sb.append(o.toString()).append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("] ");
        System.out.print(sb);
        for (Object o : arg) {
            System.out.print(o + " ");
        }
        System.out.println("");
    }

    public static void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("h");

        List<Integer> data = new ArrayList<>();
        data.add(1);
        print(data);
    }

    public static String getMD5Str(String str) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest  = md5.digest(str.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        return md5Str;
    }
}
