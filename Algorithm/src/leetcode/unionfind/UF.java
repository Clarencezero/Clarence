package leetcode.unionfind;

/**
 * 算法复杂度，主要取决于 {@link #find(int)} 函数的，最坏的情况是退化成链表结构，所以复杂度为 O(N)
 */
public class UF {
    // 连通分量
    private int count;

    // 节点 x 的父节点是 parent[x]
    private int[] parent;

    // 构建函数，n为图的节点总数
    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 将p、q连通
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootq = find(q);

        if (rootq == rootP) return;

        parent[rootP] = rootq;

        count--;
    }

    /**
     * 返回节点 x 的根节点
     *
     * @param x
     * @return
     */
    private int find(int x) {
        // 直到找到和自己相等的节点，就表示遇到根节点了
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
    }

   public int count() {
        return count;
   }
}
