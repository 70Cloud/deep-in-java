package deep.in.java;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @Author: NoNo
 * @Description: 如何将一个 HashMap 的值 +1（Entry#setValue）
 * @Date: Create in 22:04 2019/4/9
 */
public class MapEntryDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        demoMap(map);

        System.out.println(map);

        //注意：Java Concurrent Map 可能未实现 Map.Entry#setValue(Object) 方法
        Map<String, Integer> skipListMap = new ConcurrentSkipListMap<>();

        skipListMap.put("A", 1);
        skipListMap.put("B", 2);
        skipListMap.put("C", 3);

        // ConcurrentSkipListMap 可能未实现 Map.Entry#setValue(Object) 方法
        demoMap(skipListMap);

        System.out.println(skipListMap);
    }

    private static void demoMap(Map<String, Integer> map) {

        // 问题：如何让所有的成员值 +1
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            slowApproach(entry, map);
            fastApproach(entry);
        }
    }

    private static void fastApproach(Map.Entry<String, Integer> entry) {
        entry.setValue(entry.getValue() + 1);
    }

    /**
     * 慢实现（有 key 的计算，消耗时间）
     * @param entry
     * @param map
     */
    private static void slowApproach(Map.Entry<String, Integer> entry, Map<String, Integer> map) {
        String key = entry.getKey();
        Integer value = entry.getValue();
        // Key 的计算消耗时间
        // +1
        value += 1;
        map.put(key, value);
    }
}
