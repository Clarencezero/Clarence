package leetcode.map;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class No_207_canFinish {
    public static void main(String[] args) {
        No_207_canFinish go = new No_207_canFinish();
        // 2
        // [[1,0]] 完成课程1必须先完成课程0 0->1
        int[][] pre = {{1, 0}};
        System.out.println(go.canFinish(2, pre));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建邻接表
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        // 创建入度数组, indeg[0] 表示课程0（节点）的入度数
        int[] indeg = new int[numCourses];

        // 初始化入度数组和邻接表
        //
        for (int[] courses : prerequisites) {
            edges.get(courses[1]).add(courses[0]);
            indeg[courses[0]]++;
        }
        printArr(indeg);

        // 将入度数为 0 的节点(int表示)放入队列中
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.addLast(i);
            }
        }

        // 弹出队列，然后将该节点所有的出度方向的节点-1，并判断是否为 0
        // 如果为0，放入队列，重复以上步骤，直到队列为空或没有0的入度节点
        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int k = queue.pollLast();
            // 获取 k 的邻接连（指向下一个的节点）
            for (int i : edges.get(k)) {
                indeg[i]--;
                System.out.println("i: " + i);
                if (indeg[i] == 0) {
                    queue.addFirst(i);
                }
            }
        }
        System.out.println("visited: " + visited);
        return visited == numCourses;
    }

    private void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
