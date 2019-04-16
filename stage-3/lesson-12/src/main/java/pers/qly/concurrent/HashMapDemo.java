package pers.qly.concurrent;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 23:09 2019/4/11
 */
public class HashMapDemo {

    public static void main(String[] args) {

        String strValue = "Hello,World";

        Integer intValue = new Integer(strValue.hashCode());

        Map<Object, Object> map = new HashMap<>();

        map.put(strValue, 1);
        map.put(intValue, 2);
        // 两者的 HashCode 是一样的，会落到一个桶中
        // 但是 equals() 比较是不一样的，这就是为什么 String#equals() 要用 Object，如果是 Integer，直接返回 false
    }
}
