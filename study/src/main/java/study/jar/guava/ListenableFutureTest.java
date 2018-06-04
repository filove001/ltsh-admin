package study.jar.guava;

import com.google.common.util.concurrent.*;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/5/28.
 */
public class ListenableFutureTest {
    @Test
    public void test() {

    }

    private ExecutorService executor = Executors.newFixedThreadPool(1);

    private ListeningExecutorService service = MoreExecutors.listeningDecorator(executor);

    public static void main(String[] args){

        ListenableFutureTest test = new ListenableFutureTest();

        ListenableFuture<Student> future = test.service.submit(new Callable<Student>() {

            @Override
            public Student call() throws Exception {
                Thread.sleep(1000*5);
                return new Student("张三", "男");
            }
        });
        Futures.addCallback(future, new FutureCallback<Student>() {

            @Override
            public void onSuccess(Student result) {
                System.out.println("执行结果"+result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("error=============");
            }
        }, test.service);

        System.out.println("abcdd");
    }
    static class Student{
        private String name;
        private String sex;

        public Student(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }
}
