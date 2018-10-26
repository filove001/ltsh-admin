package study.java.future;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ListenableFutureCook {
    // 创建线程池
    final static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        // 任务1   // 第一步 网购厨具
        ListenableFuture<Chuju> booleanTask = service.submit(new Callable<Chuju>() {
            @Override
            public Chuju call() throws Exception {
                System.out.println("第一步：下单");
                System.out.println("第一步：等待送货");
                Thread.sleep(5000);  // 模拟送货时间
                System.out.println("第一步：快递送到");
                return new Chuju();
            }
        });
        Futures.addCallback(booleanTask, new FutureCallback<Chuju>() {
            @Override
            public void onSuccess(Chuju result) {
                System.out.println("第三步：厨具到位，开始展现厨艺");
                System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
            }

            @Override
            public void onFailure(Throwable t) {
            }
        },service);
        // 任务2  第二步 去超市购买食材
        ListenableFuture<Shicai> stringTask = service.submit(new Callable<Shicai>() {
            @Override
            public Shicai call() throws Exception {
                // 第二步 去超市购买食材
                Thread.sleep(2000);  // 模拟购买食材时间
                Shicai shicai = new Shicai();
                return new Shicai();
            }
        });

        Futures.addCallback(stringTask, new FutureCallback<Shicai>() {
            @Override
            public void onSuccess(Shicai result) {
                System.out.println("第二步：食材到位");
            }

            @Override
            public void onFailure(Throwable t) {
            }
        },service);

//        cook(chuju, shicai);

        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }

    //  用厨具烹饪食材
    static void cook(Chuju chuju, Shicai shicai) {}

    // 厨具类
    static class Chuju {}

    // 食材类
    static class Shicai {}

}