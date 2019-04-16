package pers.qly.deep.in.java.stage2.lesson7.collection;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:21 2019/2/23
 */
public class IdentityHashMapDemo {

    // IdentityHashMap 和 WeakHashMap 都没有把 红黑树 放进去

    public static void main(String[] args) {

        // 普通的 HashMap 是通过 key 的 hashCode 和 equals 来实现的

        // Q：如果类覆盖了 Object 的 equals(Objects) 方法，那么 hashCode() 方法需不需要覆盖？
        // A：不强制覆盖，建议实现，注意不要将 hashCode() 作为 equals 方法的实现，可参考
        // Objects.hash(Object...) 以及 Arrays.hashCode(Object[])，hashCode() 是一个计算较重的实现
        // equals 通常是做对象属性的比较

        // Q：如果类覆盖了 Object 的 hashCode() 方法，那么 equals(Objects) 方法需不需要覆盖？
        // A：必须实现，hashCode() 是用于 Hash 计算，比如普通的 HashMap ，由于不同对象的 hashCode() 方法可能返回相同的数据
        // 原因一：int 数据访问范围 2^31-1
        // 原因二：hashCode() 方法计算的问题可能产生 hash 冲突
        // 当不同对象 hashCode() 相同时，再做对象 equals(Object) 方法比较

//        demoHashMap();

        // 场景：需要对 对象 本身做鉴别
//        demoIdentityHashMap();

        // System.identityHashCode() 与覆盖 hashCode() 方法的差异
        Object a = new Object();
        demoIdentityHashCodeAndHashCode(a, a);

        Object b = new Object();
        demoIdentityHashCodeAndHashCode(a, b);

        String str1 = "1";
//        String str2 = "2"; // 输出 false
        String str2 = "1";
        // System.identityHashCode(1) == 2034688500
        // 1.hashCode() == 49
        demoIdentityHashCodeAndHashCode(str1, str2);

        // 不同对象
        str2 = new String("1");
        // 不同对象如果用 System.identityHashCode(1) 会发现 hashCode 值不同
        // 不同对象如果用 1.hashCode() 会发现 hashCode 值相同
        demoIdentityHashCodeAndHashCode(str1, str2);

        // MethodHandler JDK 7 实现，可以取到父类的值
    }

    private static void demoIdentityHashCodeAndHashCode(Object a, Object b) {
        System.out.printf("System.identityHashCode(%s) == %d\n", a, System.identityHashCode(a));
        System.out.printf("%s.hashCode() == %d\n", a, a.hashCode());
        System.out.printf("System.identityHashCode(%s) == System.identityHashCode(%s) -> %s\n", a, b,
                System.identityHashCode(a) == System.identityHashCode(b));
        System.out.printf("%s.hashCode() == %s.hashCode() -> %s\n", a, b, a.hashCode() == b.hashCode());
    }

    private static void demoMap(Map<String, Integer> map) {

        System.out.println("A".equals(new String("A")));
        System.out.println("A" == new String("A"));
        System.out.println("A".hashCode() == new String("A").hashCode());

        map.put("A", 1);
        map.put(new String("A"), 1);

        System.out.println(map.size());
    }

    private static void demoIdentityHashMap() {
        Map<String, Integer> map = new IdentityHashMap<>();

        demoMap(map);
    }

    private static void demoHashMap() {
        Map<String, Integer> map = new HashMap<>();

        demoMap(map);
    }

    private String name;

    private int age;

    // JDK 7 实现
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdentityHashMapDemo that = (IdentityHashMapDemo) o;
        return age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
