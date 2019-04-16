package pers.qly.deep.in.java.stage2.lesson7.collection;

import java.util.Arrays;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 20:31 2019/2/23
 */
public class ImmutableArrayDemo {

    public static void main(String[] args) {
        // 假设 values object address 内存地址 : 100
        Integer[] values = of(1, 2, 3);
        // [0] = Integer.valueOf(1)
        // [1] = Integer.valueOf(2)
        // [2] = Integer.valueOf(3)

        // 数组的 Copy 与集合对象的 Clone 类似，是浅克隆（复制）
        Integer[] valuesCopy = Arrays.copyOf(values, values.length);

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i] == valuesCopy[i]);
        }
        // 修改复制后的内容
        valuesCopy[0] = 99;
        // 输出原始的数组
        System.out.println(Arrays.toString(values));

        // 数组的特性，长度不变（特殊的不变性），但是内容可被替换
        Integer[] newValues = new Integer[3]; // 开辟 3 个元素大小的数组空间，不能超过3个，类似 C 中的 malloc
        // [0] = null
        // [1] = null
        // [2] = null

        User[] users = of(1L, 2L, 3L);
        User[] usersCopy = Arrays.copyOf(users, values.length);

        // 假设 userCopy 作为返回值对象的话，那么此时会不会有安全问题
        User user1 = usersCopy[0];
        // 修改 usersCopy 的第一个 User 对象
        user1.setId(99L);
        // 输出 users，检查 users 的第一个对象是否被修改
        System.out.println(Arrays.toString(users)); // 说明 copy 是浅克隆
        // 总结：
        // 1、数组的 Copy 与集合对象的 Clone 类似，是浅克隆（复制）
        // 2、如果需要只读数组的话，需要深度 Clone (复制)

        // 尽可能少用数组，多用集合
        // ConcurrentHashMap 数据结构是线程安全的，内容不一定线程安全，可能会被替换
    }

    private static User[] of(Long... ids) {
        User[] users = new User[ids.length];
        for (int i = 0; i < ids.length; i++) {
            users[i] = new User(ids[i]);
        }

        return users;
    }

    private static class User {
        private Long id;

        public User(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    '}';
        }
    }

    private static Integer[] of(Integer... values) { // Integer... == Integer[]

        return values;
    }
}
