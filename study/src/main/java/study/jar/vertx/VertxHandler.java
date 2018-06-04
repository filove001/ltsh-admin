package study.jar.vertx;


import com.google.common.util.concurrent.*;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;


/**
 * Created by Administrator on 2018/6/3.
 */
public class VertxHandler implements Handler<RoutingContext> {
    private Logger logger = LoggerFactory.getLogger(VertxHandler.class);
    // 创建线程池
    final static ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

    @Override
    public void handle(RoutingContext routingContext) {
        String interfaceName = routingContext.request().getParam("interface");
        String method= routingContext.request().getParam("method");
        String parameterTypesString= routingContext.request().getParam("parameterTypesString");
        String parameter= routingContext.request().getParam("parameter");
        long startTime = System.nanoTime();
        ListenableFuture<Boolean> booleanTask = service.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Thread.sleep(1000);
                return true;
            }
        });

        Futures.addCallback(booleanTask, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                logger.info("" + (System.nanoTime() - startTime)/1000000);
                routingContext.response().end((System.nanoTime() - startTime)/1000000+"");
            }
            @Override
            public void onFailure(Throwable t) {
            }
        },service);
    }

}
