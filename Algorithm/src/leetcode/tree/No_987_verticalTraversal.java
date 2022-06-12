package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Location implements Comparable<Location>{
    int row, col, val;
    public Location(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    // 构造小顶堆，按列排序
    @Override
    public int compareTo(Location that) {
        if (this.col != that.col)
            return Integer.compare(this.col, that.col);
        else if (this.row == that.row)
            return Integer.compare(this.row, that.row);
        else
            return Integer.compare(this.val, that.val);
    }
    @Override
    public String toString() {
        return " " + this.col + " " + this.val;
    }
}


public class No_987_verticalTraversal {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        List<List<Integer>> lists = verticalTraversal(tree);
        System.out.println(lists);

    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Location> queue = new PriorityQueue<>();
        dfs(root, 0, 0, queue);

        int prevCol = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Location local = queue.poll();
            if (local.col != prevCol || prevCol == Integer.MAX_VALUE) {
                prevCol = local.col;
                res.add(new LinkedList<>());
            }
            res.get(res.size() - 1).add(local.val);
        }

        return res;
    }

    private static void dfs(TreeNode root, int col, int row, PriorityQueue<Location> queue) {
        if (root == null) return ;
        Location local = new Location(row, col, root.val);
        queue.add(local);
        dfs(root.left, col-1, row+1, queue);
        dfs(root.right, col+1, row+1, queue);
    }
}
