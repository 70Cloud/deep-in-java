package deep.in.java;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:12 2019/4/9
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        // ConcurrentHashMap 主要用于读多写少场景
        // 并发特征：
        //  1.5-1.6 读锁（部分锁），写锁 -> 1.7 读无锁（Segment），写锁 -> 1.8 读无锁（红黑树——更好地解决 Hash 冲突），写锁
        // 数据结构：
        //  <1.8:桶（bucket）
        //  1.8:桶（bucket）、平衡树（红黑树）
        // ConcurrentSkipListMap 读多写多场景（如果内存足够时）

        //  ConcurrentHashMap
        // table 2^n ->
        //  n = 1 -> size = 2
        //  n = 2 -> size = 2^2 = 4
        //  n = 3 -> size = 2^3 = 8 TREEIFY_THRESHOLD
        // log2(8) = 3
        // 数组
        // [0] -> [1] -> [2]
        // 树
        // [0] -> [1]
        //     -> [2]
        // n = 4 -> size = 2^4 = 16 > TREEIFY_THRESHOLD
    }
}
