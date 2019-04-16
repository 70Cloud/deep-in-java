package pers.qly.deep.in.java.stage1.lesson2;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 21:57 2019/1/17
 */
public class CloneableDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        String desc = "Hello World";
        Data data = new Data();
        data.setValue(1);
        data.setDesc(desc);

        Data copy = data.clone();

        System.out.println("data == copy:"+(data == copy));

        System.out.println(copy.hashCode() == desc.hashCode());

        // 必须实现 Cloneable 标记接口，否则会报 CloneNotSupportedException
        // 输出1
        // 浅拷贝
        // 深浅主要在于对象类型
        System.out.println(copy.getValue());
        // desc -> data.desc -> clone -> copy.desc ==desc
        System.out.println(copy.getDesc() == desc);
        // 如果是深拷贝的话,equals相等
        System.out.println(copy.getDesc().equals(desc));

    }
}

class Data extends Object implements Cloneable{
    private int value;

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 通常把 protected 访问性提升为 public
     * 强制转换成Data类型
     * clone的带价比new小，new对象是需要ClassLoader的
     * @return
     * @throws CloneNotSupportedException
     */
    public Data clone() throws CloneNotSupportedException{
        Data copy = (Data) super.clone();
        // 原生类型没有深浅关系
        // 对象类型需要复制
        copy.desc = new String(this.desc);
        return copy;
    }

//    @Override
//    public int hashCode() {
//        return value;
//    }
}
