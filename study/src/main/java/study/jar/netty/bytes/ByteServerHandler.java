package study.jar.netty.bytes;


import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Created by fengjianbo on 2018/5/24 0024.
 */
public class ByteServerHandler extends SimpleChannelInboundHandler<byte[]> {
    private static Logger logger = LoggerFactory.getLogger(ByteServerHandler.class);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, byte[] obj)
        throws Exception {
        try {
//            obj = getServerContext().getCompress().uncompress(obj);
            String s = new String(obj, Constant.CHARSET_NAME);
            JSONObject jsonObject = JSONObject.parseObject(s);

    //            logger.info("服务器收到,耗时:{}, 内容:{}", System.currentTimeMillis() - Long.parseLong(map.get("requestTime") + ""), JSONObject.toJSONString(obj));
            // 收到消息直接打印输出
            String interfaceName = (String)jsonObject.get("interface");
            String method = (String)jsonObject.get("method");
            String parameterTypesString = (String)jsonObject.get("parameterTypesString");
            String parameter = (String)jsonObject.get("parameter");
            long receiveTime = System.currentTimeMillis();
//            getServerContext().getRpcClient().invoke(interfaceName, method, parameterTypesString, parameter, new ResultCallback() {
//                @Override
//                public void callback(Object result) {
//                    String requestId = (String) jsonObject.get(Constant.REQUEST_ID_KEY);
//                    Map<String, Object> resultMap = new HashMap<>();
////                    ObjectResp objectResp = new ObjectResp();
//                    resultMap.put("receiveTime", receiveTime);
//                    resultMap.put("requestId", requestId);
//                    resultMap.put("responseTime", System.currentTimeMillis());
//
//                    try {
//                        resultMap.put("result", new String((byte[])result, Constant.CHARSET_NAME));
//                        byte[] bytes = getServerContext().getCompress().compress(resultMap);
//                        ctx.writeAndFlush(bytes);
//                    } catch (Exception e) {
//                        logger.error(e.getMessage(), e);
//                    }
//                }
//            });
        } catch (Exception e) {
            logger.error(e.getMessage() ,e);
            throw e;
        }
    }

    @Override
     public void channelActive(ChannelHandlerContext ctx) throws Exception {
         logger.info("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");
         super.channelActive(ctx);
     }
}