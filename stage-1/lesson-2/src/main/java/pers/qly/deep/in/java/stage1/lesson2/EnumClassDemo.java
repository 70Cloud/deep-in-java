package pers.qly.deep.in.java.stage1.lesson2;

import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 22:25 2019/1/17
 */
public class EnumClassDemo {

    public static void main(String[] args) {

        // Q1:ONE 到底是第几个定义的
        // Q2:能否输出所有成员
//        println(Counting.ONE);
//        println(Counting.FIVE);
//
//        // Q3:为什么枚举会输出成员名称
//        println(CountingEnum.ONE);
//        println(CountingEnum.FIVE);
//
//
//        printEnumMeta(CountingEnum.ONE);
//        printEnumMeta(CountingEnum.FIVE);

//        // 自定义实现 values()
        printAllMembers();
//        // Java 枚举字节码提升实现 values()
        printCountingMembers();
    }


    public static void println(Counting counting) {
        System.out.println(counting);
    }

    public static void println(CountingEnum countingEnum) {
        System.out.println(countingEnum);
    }

    public static void printEnumMeta(Enum enumeration) {
        System.out.println("Enumeration type: " + enumeration.getClass());// 说明任何枚举都扩展了 Enum 类
        System.out.println("member : " + enumeration.name());// Enum#name() 成员名称
        System.out.println("ordinal : " + enumeration.ordinal());// Enum#ordinal() 成员定义位置
        // values() 方法是 Java 编译器给枚举提升的方式(类似于字节码提升)
    }

    public static void printAllMembers() {
        Stream.of(CountingEnum.values())
                .forEach(System.out::println);
    }

    public static void printCountingMembers() {
        Stream.of(Counting.values())
                .forEach(System.out::println);
    }
}

/**
 * 枚举类实际上是 final class
 * 枚举成员的修饰符实际上是 public static final
 * values() 是 Java 编译器做的提升
 */
enum CountingEnum {

//    ONE,
//    TWO,
//    THREE,
//    FOUR,
//    FIVE;

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    private int value;

    /* private */ CountingEnum(int value) {
        this.value = value;
    }

//    public abstract String valuesAsString();
    // 抽象方法在枚举中的应用，例如 TimeUnit中的秒转换

    @Override
    public String toString() {
        return "CountingEnum : " + value;
    }
}

/**
 * 枚举类 : 计数
 * 强类型约束(相对于常量)(常量所表示的类型不能自我表述)
 * 枚举类可以是抽象类，枚举必须是具体类
 */
final class Counting {

    public static final Counting ONE = new Counting(1);
    public static final Counting TWO = new Counting(2);
    public static final Counting THREE = new Counting(3);
    public static final Counting FOUR = new Counting(4);
    public static final Counting FIVE = new Counting(5);

    private int value;// 加一个状态

    private Counting(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Counting : " + value;
    }

    /**
     * 用反射自定义实现 Java 编译器自动生成的 Enum 类中的 values()方法
     * Enum 类会在编译时自动对 values()做一个字节码提升
     *
     * @return
     */
    public static Counting[] values() {
        // Fields -> filter -> public static final fields -> get
        return Stream.of(Counting.class.getDeclaredFields()).filter(field -> {
            int modifiers = field.getModifiers();
            return Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)
                    && Modifier.isFinal(modifiers);
        }).map(field -> {
            // Field -> Counting
            try {
                return (Counting) field.get(null);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList()).toArray(new Counting[0]);

    }
}
