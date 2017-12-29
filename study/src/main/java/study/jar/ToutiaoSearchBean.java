package study.jar;

import java.util.List;
import java.util.Map;

/**
 * Created by fengjianzhong on 2017/12/28.
 */
public class ToutiaoSearchBean {
    private int count;
    private int return_count;
    private List<Map<String,Object>> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getReturn_count() {
        return return_count;
    }

    public void setReturn_count(int return_count) {
        this.return_count = return_count;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }
}

