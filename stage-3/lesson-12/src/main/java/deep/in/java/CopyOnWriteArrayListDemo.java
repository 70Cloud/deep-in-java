package deep.in.java;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 21:52 2019/4/9
 */
public class CopyOnWriteArrayListDemo {

    // CopyOnWrite* 实现
    //• 并发特征：
    //  • 读：无锁（volatile）、快速（O(1) ）、
    //  • 写：同步（synchronized）、复制（较慢、内存消耗）
    //• 代表实现：CopyOnWriteList、CopyOnWriteSet（底层实现为 CopyOnWriteList）

    // ConcurrentSkipList* 实现
    //• 并发特征：无锁
    //• 数据结构：有序（ConcurrentNavigableMap 实现）、跳跃列表（Skip List）变种（时间复杂度：搜索 O(log(n))、插⼊入O(log(n))）
    //• 时间复杂度：平均 log(n) - containsKey、get、put 和 remove 方法
    //• 代表实现：ConcurrentSkipListMap、ConcurrentSkipListSet（底层实现为 ConcurrentSkipListMap）
    //• 特征：空间换时间

    // ConcurrentSkipListMap
    //• 注意事项：
    //  • size() 方法非 O(C) 操作
    //  • 批量操作无法保证原子执行，如 putAll、equals、toArray、containsValue 以及 clear 方法
    //  • Iterator 和 Spliterators：弱一致性、并非 fail-fast
    //  • 非 null 约束：keys 和 values 均不允许为 null

    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(); // Diamond 语法

        // main 线程插入三条数据
        // 安装 Thread ID
        list.add(1);
        // 判断当前线程 ID == main.threadId
        list.add(2);
        list.add(3);
        // Copy
        // JDK 升级两大核心性能提升
        // 1. 数组
        // 2. String

        // ConcurrentModificationException
        int times = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext() && times < 100) {
            iterator.next();
            list.add(2);
            times++;
        }
    }
}
