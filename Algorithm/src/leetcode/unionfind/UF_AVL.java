package leetcode.unionfind;

/**
 * 平衡性优化的并查集
 * 通过加入一个size[] 数组的优化，可以保证树的生长相对平衡，高度大致在 logN 这个数量级
 */
public class UF_AVL {
    private int count;
    private int[] parent;
    /**
     * 额外使用一个size数组每棵树包含的节点数，称为「重量」
     */
    private int[] size;

    public UF_AVL(int count) {
        this.count = count;
        parent = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            // 初始化为1
            size[i] = 1;
        }
    }

    /**
     * 旧版本这个方法会导致树的不平衡
     * 我们的目标是希望小一些的树接到大一些的树下面，这样就能避免头重脚轻，更平衡一些
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (size[rootP] > size[rootQ]) {
            // 小树接到大树下面，可以有效避免链表结构
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    /**
     * 判断节点p和节点q是否连通
     *
     * @param p
     * @param q
     * @return
     */
    public boolean connect(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        return rootP == rootQ;
    }

    private int find(int x) {
        while(parent[x] != x) {
            x = parent[x];
        }

        return x;
    }

    public int count() {
        return count;
    }
}
