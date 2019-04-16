package pers.qly.deep.in.java.stage1.lesson1;

import java.util.logging.Logger;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 19:46 2019/1/17
 */
public class FunctionMain {

    /**
     * < Java 9
     * public : all
     * protected : 继承 + 同包
     * (default) : 同包
     * private   : 当前类
     * <p>
     * >= Java 9
     * 模块化增加了封装性
     */

    private static final Logger logger = Logger.getLogger("abc");


    public static void main(String[] args) {
        // byte(8) char(16) short(16) int(32) long(64)

        try {
            execute();
        } catch (Throwable e) {
            logger.warning(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    private static void execute() throws Throwable {

    }
}
