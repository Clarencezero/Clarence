package leetcode.unionfind;

/**
 * 路径压缩：这一步优化也特别简单，所以非常巧妙
 * 只需要在 {@link #find(int)} 中加一行代码即可
 *
 */
public class UF_PATH_COMPRESSION {
    private int count;
    private int[] parent;
    private int[] size;

    public UF_PATH_COMPRESSION(int count) {
        this.count = count;
        parent = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        
        count--;
    }

    private int find(int x) {
        if (parent[x] != x) {
            // 进行路径压缩
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean connect(int p, int q) {
        return parent[p] == parent[q];
    }

    public int count() {
        return count;
    }

}
