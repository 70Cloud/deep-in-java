package pers.qly.deep.in.java.stage1.lesson3.generic;

import org.springframework.core.ResolvableType;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author: NoNo
 * @Description:
 * Q:泛型在运行时被擦写，那通过反射是否可以得到泛型真实参数类型？
 *   例如：List<Map<String,List<Object>>>这种复杂对象如何通过反射获取它泛型中的真实参数类型
 * A: 如果泛型参数是在属性上，可以通过字节码的方式获取字符描述，然后反推
 *    如果泛型参数在类型上面，那么可以通过反射获取
 * <p> ParameterizedType parameterizedType = (ParameterizedType) declaredClass.getGenericSuperclass();
 * Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
 * return (Class<T>) actualTypeArguments[0];<p/>
 * @Date: Create in 13:46 2019/2/16
 */
public class QuestionAndAnswer<T extends Serializable> {

    private List<Map<String, List<Object>>> value = Collections.emptyList();

    public static void main(String[] args) throws Exception {

        question1();
    }

    private static void question1() throws Exception {
        // 获取成员泛型参数类型
        Field field = QuestionAndAnswer.class.getDeclaredField("value");

        ResolvableType resolvableType = ResolvableType.forField(field);

        System.out.println(resolvableType.getGeneric(0));

        // 获取类泛型参数类型
        TypeVariable[] parameters = QuestionAndAnswer.class.getTypeParameters();

        for (TypeVariable typeVariable : parameters) {
            System.out.println(typeVariable);
        }

        // 具体参数类型
        QuestionAndAnswer<String> a = new QuestionAndAnswer<String>();

        parameters = a.getClass().getTypeParameters();

        for (TypeVariable typeVariable : parameters) {
            System.out.println(typeVariable);
        }
    }
}
