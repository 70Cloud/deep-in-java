package deep.in.java;

import java.util.concurrent.*;

/**
 * @Author: NoNo
 * @Description: 背压：当生产者产生的数据大于消费者消费的数据时，会背压，可以通过限制个数或者取消来解决
 * @Date: Create in 23:32 2019/4/11
 */
public class Java9FlowDemo {

    public static void main(String[] args) throws InterruptedException {

        // Java 7 try-catch 语法

        try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>()) {

            // 订阅
            publisher.subscribe(new Flow.Subscriber<String>() {

                private Flow.Subscription subscription;

                @Override
                public void onSubscribe(Flow.Subscription subscription) {
                    this.subscription = subscription;
                    println("已订阅");
                    // 订阅无限(Long.MAX_VALUE)数据
                    subscription.request(Long.MAX_VALUE);
                }

                @Override
                public void onNext(String item) {
                    if ("exit".equalsIgnoreCase(item)) {
                        // 取消订阅
                        subscription.cancel();
                        return;
                    } else if ("exception".equalsIgnoreCase(item)) {
                        throw new RuntimeException("Throw an exception...");
                    }
                    println("得到数据：" + item);
                }

                @Override
                public void onError(Throwable throwable) {
                    println("得到异常：" + throwable);
                }

                @Override
                public void onComplete() {
                    println("操作完成");
                }
            });

            // 发布者发布数据
            publisher.submit("Hello,World");
            publisher.submit("2019");

            // 故意抛出异常
            publisher.submit("exception");

            // exit 是退出命令
            publisher.submit("exit");
            // 当 exit 出现时，忽略后续提交
            publisher.submit("ABCDEFG");
            publisher.submit("HIGKLMN");

            ExecutorService executor = (ExecutorService) publisher.getExecutor();

            executor.awaitTermination(100, TimeUnit.MILLISECONDS);

        }
    }

    private static void println(Object object) {
        System.out.printf("[线程: %s] - %s\n", Thread.currentThread().getName(), object);
    }
}
