package pers.qly.deep.in.java.stage2.lesson6.collection;

import java.util.Map;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 23:28 2019/2/16
 */
public class MapDemo {

    public static void main(String[] args) {

        Map<Integer, String> map = Map.of(1, "A");

        System.out.println(map.get(1));
        System.out.println(map.get(1L));
        System.out.println(map.get(1.0));
        System.out.println(map.get(Long.valueOf(1L).intValue()));// Long 也有缓存
        System.out.println(map.get(new Key(1)));
        System.out.println(map.containsKey(new Key(1)));
    }

    // SortedMap 最好用 Integer 来做 key，比较的时候好
    private static class Key {
        private final int value;

        private Key(int value) {
            this.value = value;
        }

        // FIXME 理解下
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj instanceof Integer) {
                return this.value == ((Integer) obj).intValue();
            }

            Key key = (Key) obj;
            return value == key.value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }
}
