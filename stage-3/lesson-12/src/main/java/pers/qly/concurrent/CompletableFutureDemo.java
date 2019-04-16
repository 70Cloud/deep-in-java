package pers.qly.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * @Author: NoNo
 * @Description:
 * @Date: Create in 23:31 2019/4/11
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {
        //  CompletableFuture

        CompletableFuture.supplyAsync(() -> {
            return 1;
        }).thenApply(String::valueOf)
                // 异常的方式结束
                .completeExceptionally(new RuntimeException())
        ;
    }
}
