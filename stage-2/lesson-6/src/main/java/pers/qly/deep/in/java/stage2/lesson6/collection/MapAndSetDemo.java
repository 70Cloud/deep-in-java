package pers.qly.deep.in.java.stage2.lesson6.collection;

import java.util.*;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 21:52 2019/2/16
 */
public class MapAndSetDemo {

    public static void main(String[] args) {
        // 通常 Set 是 Map 中 key 的实现，Set 底层运用 Map 实现
        // 比如 HashSet 底层运用了 HashMap
        // 数据库索引：散列(Hash)索引
        Map<String,Object> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        // TreeSet 底层运用了 TreeMap
        // 二叉树索引
        map = new TreeMap<>();
        set = new TreeSet<>();
        // Integer,String implements Comparable
        // 一致性 Hash https://en.wikipedia.org/wiki/Consistent_hashing
        // 分布式中用的非常多，比如 Redis

        // 负载均衡算法：Spring Cloud 负载均衡不成熟的点 - 缺少一致性Hash算法
        // 服务节点： A B C 可以均衡服务
        // 3000 请求，平均1000个请求
        // 尽可能平均、支持动态扩缩容 D E -> 平均600请求

        // TreeMap 实现 一致性 Hash
        // 参考 https://github.com/Jaskey/ConsistentHash/blob/master/src/com/github/jaskey/consistenthash/ConsistentHashRouter.java
        // 更为公平的实现
        // 参考 https://github.com/clohfink/RendezvousHash

        // LinkedHashMap 构造中有个顺序 accessOrder
        // 插入顺序（默认）、访问顺序（构造器调整）

        // RandomAccess 标记接口 表示可以随机访问 ArrayList 中有继承

    }
}
