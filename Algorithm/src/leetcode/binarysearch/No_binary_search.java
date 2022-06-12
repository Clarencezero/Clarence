package leetcode.binarysearch;

public class No_binary_search {
    public static void main(String[] args) {
        testLeftBound_1();
    }

    /**
     * ① 元素分别小于或大于数组中最小、最大元素，则会返回 0 和 4。对于 4 需要判断一下边界即可
     * ② 对于在中间不存在的，我们需要判断left指针指向的元素是否为target
     * ③ 根据搜索区间来定义下一个搜索区间的范围
     * ④ 为什么返回的是 left，其实都是一样的，最主要看 while(left < right) 的条件，当 left == right 相等时，
     * 就返回。因为是左闭右开区间，所以当两者相等时搜索区间就没有元素了，换名话说，数组中的元素都已经被遍历过
     * while 里面使用 < 还是 <= 取决于搜索区间，如果是左闭右闭区间，则两者相等即可退出 while，所以应该使用 <=。
     * 而如果是左闭右开区间，那么当且仅当 left = right + 1 时才不会漏掉数组里的任何元素，所以应该使用 <
     */
    private static void testLeftBound_1() {
        int[] nums = {2, 3, 5, 7};
        No_binary_search go = new No_binary_search();
        // System.out.println(go.leftBound_1(nums, 8)); // 返回值：4，表示数组中小于 8 的有 4 个。left 下标越界
        // System.out.println(go.leftBound_1(nums, 7)); // 返回值：3，表示数组中目标值
        // System.out.println(go.leftBound_1(nums, 1)); // 返回值：0，表示数组中小于 1 的有 0 个
        // System.out.println(go.leftBound_1(nums, 4)); // 返回值：2，表示数组中小于 4 的元素有 2 个

        // 求距离最近的index
        int[] nums2 = {1, 3, 7, 9}; // 3,4,5,6,7
        System.out.println(go.getMinGap(nums2, 3)); // 情况一：有确切值，可以返回对应的index，结果：1
        System.out.println(go.getMinGap(nums2, 0)); // 情况二：最左边，结果：0
        System.out.println(go.getMinGap(nums2, 10)); // 情况三：最右边，结果：3
        System.out.println(go.getMinGap(nums2, 5)); // 情况四：正中间，结果：1
        System.out.println(go.getMinGap(nums2, 4)); // 情况四：偏左，结果：1
        System.out.println(go.getMinGap(nums2, 6)); // 情况四：偏右，结果：2
    }

    private int leftBound_1(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }

    private int getMinGap(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left == 0) {
            return left;
        } else if (left == nums.length) {
            return left - 1;
        } else {
            int a = Math.abs(nums[left - 1] - target);
            int b = Math.abs(nums[left] - target);
            return a > b ? left : left - 1;
        }
    }

    /**
     * ① 当目标值大于数组中的所有元素时，则得到的 left 会越界，所以返回的时候需要判断一下
     */
    private static void testLeftBound2() {
        int[] nums = {2, 3, 5, 7};
        No_binary_search go = new No_binary_search();
        System.out.println(go.leftBound_2(nums, 8)); // 返回值：4，表示数组中小于 8 的有 4 个
        System.out.println(go.leftBound_2(nums, 7)); // 返回值：3，表示数组中目标值
        System.out.println(go.leftBound_2(nums, 1)); // 返回值：0，表示数组中小于 1 的有 0 个
        System.out.println(go.leftBound_2(nums, 4)); // 返回值：2，表示数组中小于 4 的元素有 2 个
    }

    /**
     * 左闭右闭并寻找最左侧
     * ① 由于退出 while 的条件是 left == right + 1，当
     *
     * @param nums
     * @param target
     * @return
     */
    private int leftBound_2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 检查出界情况
        // if (left >= nums.length || nums[left] != target)
        //     return -1;
        return left;
    }

    public static void testRightBound1() {
        int[] nums = {2, 3, 5, 7};
        No_binary_search go = new No_binary_search();
        System.out.println(go.rightBound_1(nums, 8)); // 返回值：3，表示数组中小于 8 的有 4 个
        System.out.println(go.rightBound_1(nums, 7)); // 返回值：3，表示数组中目标值
        System.out.println(go.rightBound_1(nums, 1)); // 返回值：-1，表示数组中小于 1 的有 0 个
        System.out.println(go.rightBound_1(nums, 4)); // 返回值：1，表示数组中小于 4 的元素有 2 个
        System.out.println(go.rightBound_1(nums, 2)); // 返回值：0
        System.out.println(go.rightBound_1(nums, 3)); // 返回值：1
        System.out.println(go.rightBound_1(nums, 5)); // 返回值：2
    }

    /**
     * ① 为什么返回值 left - 1，终止条件为 left == right，而且当等于目标值时，left = mid + 1，所以 mid = left - 1 有可能是目标值，但 left 一定不是
     *
     * @param nums
     * @param target
     * @return
     */
    private int rightBound_1(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        if (left == 0) return -1;
        return nums[left - 1] == target ? (left - 1) : -1;
        // return left - 1; // 注意
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    private int rightBound_2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 这里改为检查 right 越界的情况，见下图
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
}
