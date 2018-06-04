package study.jar.vertx;


import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Administrator on 2018/6/3.
 */
public class VertxHandler implements Handler<RoutingContext> {
    private Logger logger = LoggerFactory.getLogger(VertxHandler.class);
    private String type = System.getProperty("type");   // 获取type参数
    private boolean isConsumer = "consumer".equals(type);
    private Object lock = new Object();

    @Override
    public void handle(RoutingContext routingContext) {
        String interfaceName = routingContext.request().getParam("interface");
        String method= routingContext.request().getParam("method");
        String parameterTypesString= routingContext.request().getParam("parameterTypesString");
        String parameter= routingContext.request().getParam("parameter");

    }

}
