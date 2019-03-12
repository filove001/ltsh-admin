package study.jar.hutool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.text.StrBuilder;
import com.fjz.util.Times;
import org.junit.Test;

/**
 * Created by Administrator on 2019/3/2.
 */
public class HutoolTest {
    @Test
    public void test(){

        int count=100000000;


        //StrBuilder
        TimeInterval timer1 = DateUtil.timer();
        StrBuilder builder = StrBuilder.create();
        for(int i =0; i< count; i++) {
            builder.append(i+"");
            builder.reset();
        }
        Console.log("StrBuilder:"+timer1.interval());
        //StringBuilder
        TimeInterval timer = DateUtil.timer();
        StringBuilder b2 = new StringBuilder();
        for(int i =0; i< count; i++) {
            b2.append(i+"");
            b2 = new StringBuilder();
        }
        Console.log("StringBuilder:"+timer.interval());

    }
}
