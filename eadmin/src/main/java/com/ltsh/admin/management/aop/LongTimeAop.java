package com.ltsh.admin.management.aop;

import com.fjz.util.Jsons;
import com.fjz.util.log.Logs;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 统计各个方法的用时
 *
 * Aspectj切入点语法定义
 * 在使用spring框架配置AOP的时候，不管是通过XML配置文件还是注解的方式都需要定义pointcut"切入点"
 * 例如定义切入点表达式  execution (* com.sample.service.impl..*.*(..))
 * execution()是最常用的切点函数，其语法如下所示：
 * 整个表达式可以分为五个部分：
 * 1、execution(): 表达式主体。
 * 2、第一个*号：表示返回类型，*号表示所有的类型。
 * 3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
 * 4、第二个*号：表示类名，*号表示所有的类。
 * 5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
 * Created by Administrator on 2017/6/10.
 */
//@Aspect
//@Component
public class LongTimeAop {
    //匹配com.ltsh.admin.mvc包及其子包下的所有类的所有方法
//    @Pointcut("execution(* com.ltsh.admin.mvc..*.*(..))")
//    public void executeService(){
//
//    }
    public final static Map<String, List<Long>> longTimeMap = new ConcurrentHashMap<>();
    /**
     * 环绕通知：
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around("(execution(* com.ltsh.admin.mvc..*Service.*(..))) || (execution(* com.ltsh.admin.mvc..*Dao.*(..)))")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名
        Set<Object> allParams = new LinkedHashSet<>(); //保存所有请求参数，用于输出到日志中
        Object[] args = proceedingJoinPoint.getArgs();
        List<Class<?>> cs = new ArrayList<>();
        for(Object arg : args){
            cs.add(arg.getClass());
            if (arg instanceof Map<?, ?>) {
                //提取方法中的MAP参数，用于记录进日志中
                @SuppressWarnings("unchecked")
                Map<String, Object> map = (Map<String, Object>) arg;
                allParams.add(map);
            }else if(arg instanceof HttpServletRequest){
                HttpServletRequest request = (HttpServletRequest) arg;
                //获取query string 或 posted form data参数
                Map<String, String[]> paramMap = request.getParameterMap();
                if(paramMap!=null && paramMap.size()>0){
                    allParams.add(paramMap);
                }
            }else if(arg instanceof HttpServletResponse){
                //do nothing...
            }else{
                allParams.add(arg);
            }
        }
        Logs.info("环绕通知的目标类和方法名：{}.{}({}) 类 {}  参数：{}",signature.getDeclaringTypeName() ,signature.getName(),Arrays.toString(signature.getParameterTypes()),Arrays.toString(signature.getDeclaringType().getInterfaces()), Jsons.toJsonString(allParams));

        try {//obj之前可以写目标方法执行前的逻辑
            Object obj = proceedingJoinPoint.proceed();//调用执行目标方法
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            long costMs = System.currentTimeMillis() - beginTime;
            Logs.info("{}请求结束，耗时：{}ms", methodName, costMs);
            String classMethodName=signature.getDeclaringTypeName()+"."+signature.getName()+"("+cs.toString()+")";
            if(!longTimeMap.containsKey(classMethodName)){
                longTimeMap.put(classMethodName, Collections.synchronizedList(new ArrayList()));
            }
            longTimeMap.get(classMethodName).add(costMs);
        }
        return null;
    }
}
