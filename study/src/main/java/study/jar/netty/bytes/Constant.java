package study.jar.netty.bytes;

/**
 * Created by fengjianbo on 2018/5/24 0024.
 */
public class Constant {
    public static final String REQUEST_ID_KEY = "req_id";
    /**
     * dubbo最大线程数
     */
    public static final Integer DUBBO_MAX_THREAD_COUNT = Math.min(Runtime.getRuntime().availableProcessors() + 1, 32);
    /**
     * 服务器netty处理线程数
     */
    public static final Integer SERVICE_MAX_THREAD_COUNT = Math.min(Runtime.getRuntime().availableProcessors() + 1, 32);
    /**
     * 客户端最大线程数
     */
    public static final Integer CLIENT_MAX_THREAD_COUNT = 32;
//    public static final String DELIMITER_STR = "$$_##";
    /**
     * netty 传输分隔符
     */
    public static final String DELIMITER_STR = "\r\n";
    public static final byte[] DELIMITER = DELIMITER_STR.getBytes();
    /**
     * 传输编码
     */
    public static final String CHARSET_NAME = "UTF-8";
    /**
     * 模式
     */
    public static final int MODEL_TYPE = 3;
    /**
     * 最大传输数据大小 8M
     */
    public final static int MAX_OBJECT_SIZE = 8 * 1024 * 1024;
    /**
     * handler 线程处理数量
     */
    public final static int HANDLER_THREAD_COUNT = 16;


}
