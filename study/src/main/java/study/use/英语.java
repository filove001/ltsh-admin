package study.use;

import cn.hutool.core.util.RandomUtil;
import com.fjz.util.Empty;
import com.fjz.util.Files;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2019/3/10.
 */
public class 英语 {
    @Test
    public void cut(){
//        this.getClass().get

        List<String> list = Files.readLines(new File(this.getClass().getResource("/e.txt").getFile()));
        int size=list.size();
        for (int i = 0; i < size; i++) {
            int random = RandomUtil.randomInt(0, list.size());
            String str = list.get(random);
            if (Empty.not(str)) {
                System.out.println(str);
            }
            list.remove(str);
        }
    }
}
