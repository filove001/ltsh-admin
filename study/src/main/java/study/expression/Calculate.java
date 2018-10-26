package study.expression;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by fengjianzhong on 2018/1/9.
 */
public class Calculate {
    private Hashtable<String, Object> 堆栈值 = new Hashtable<>();
    private int 表达式游标 = 0;

    public static List<String> 成对处理(String code, String start, String end) {
        List<String> subResult = new ArrayList<>();

        String temp = "";
        String nextLevelCode = "";
        int level = 0;
        for (char codeChar : code.toCharArray()) {
            temp += codeChar;

            if (temp.endsWith(end)) {
                level--;
                if (level == 0) {
                    subResult.add(nextLevelCode.toString());
                    nextLevelCode = "";
                }
            }

            if (level != 0) {
                nextLevelCode += codeChar;
            }

            if (temp.endsWith(start)) {
                level++;
            }
        }

        return subResult;
    }

    public static List<String> 前置处理(String code, String front) {
        front = front.replace("+", "\\+").replace("-", "\\-");
        return getMatchList(code, front + "[_a-zA-Z\\u4E00-\\u9FA5]+[0-9]*");
    }

    public static List<String> 后置处理(String code, String back) {
        back = back.replace("+", "\\+").replace("-", "\\-");
        return getMatchList(code, "[_a-zA-Z\\u4E00-\\u9FA5]+[0-9]*" + back);
    }

    public static List<String> 运算处理(String code, String calc) {
        calc = calc.replace("+", "\\+").replace("*", "\\*").replace("-", "\\-");
        return getMatchList(code,
                "[_a-zA-Z0-9\\u4E00-\\u9FA5]+[\\.]*[0-9]*" + calc + "[_a-zA-Z\\u4E00-\\u9FA5]*[0-9]*[\\.]*[0-9]*");
    }

    public Object 处理表达式(String 表达式) throws Exception {

        List<String> 子表达式列表 = new ArrayList();

        // 先运算括号中的内容
        子表达式列表 = 成对处理(表达式, "(", ")");
        if (子表达式列表.size() != 0) {
            for (String 子表达式 : 子表达式列表) {
                Object 子表达式值 = 处理表达式(子表达式);
                String 游标键 = "_V" + (表达式游标++);
                堆栈值.put(游标键, 子表达式值);
                表达式 = 表达式.replace("(" + 子表达式 + ")", 游标键);
            }
            return 处理表达式(表达式);
        }

        表达式 = 表达式.replace(" ", "");

        // 运算乘法
        if (表达式.contains("*"))
            子表达式列表 = 运算处理(表达式, "*");
        if (子表达式列表.size() != 0) {
            for (String 子表达式 : 子表达式列表) {
                String 乘数 = 子表达式.split("\\*")[0];
                String 被乘数 = 子表达式.split("\\*")[1];
                if (乘数.startsWith("_V"))
                    乘数 = 堆栈值.get(乘数).toString();
                if (被乘数.startsWith("_V"))
                    被乘数 = 堆栈值.get(被乘数).toString();
                Object 子表达式值 = Double.parseDouble(乘数) * Double.parseDouble(被乘数);
                String 游标键 = "_V" + (表达式游标++);
                堆栈值.put(游标键, 子表达式值);
                表达式 = 表达式.replace(子表达式, 游标键);
            }
            return 处理表达式(表达式);
        }

        // 运算除法
        if (表达式.contains("/"))
            子表达式列表 = 运算处理(表达式, "/");
        if (子表达式列表.size() != 0) {
            for (String 子表达式 : 子表达式列表) {
                String 乘数 = 子表达式.split("/")[0];
                String 被乘数 = 子表达式.split("/")[1];
                if (乘数.startsWith("_V"))
                    乘数 = 堆栈值.get(乘数).toString();
                if (被乘数.startsWith("_V"))
                    被乘数 = 堆栈值.get(被乘数).toString();
                Object 子表达式值 = Double.parseDouble(乘数) / Double.parseDouble(被乘数);
                String 游标键 = "_V" + (表达式游标++);
                堆栈值.put(游标键, 子表达式值);
                表达式 = 表达式.replace(子表达式, 游标键);
            }
            return 处理表达式(表达式);
        }

        // 运算加法
        if (表达式.contains("+"))
            子表达式列表 = 运算处理(表达式, "+");
        if (子表达式列表.size() != 0) {
            for (String 子表达式 : 子表达式列表) {
                String 乘数 = 子表达式.split("\\+")[0];
                String 被乘数 = 子表达式.split("\\+")[1];
                if (乘数.startsWith("_V"))
                    乘数 = 堆栈值.get(乘数).toString();
                if (被乘数.startsWith("_V"))
                    被乘数 = 堆栈值.get(被乘数).toString();
                Object 子表达式值 = Double.parseDouble(乘数) + Double.parseDouble(被乘数);
                String 游标键 = "_V" + (表达式游标++);
                堆栈值.put(游标键, 子表达式值);
                表达式 = 表达式.replace(子表达式, 游标键);
            }
            return 处理表达式(表达式);
        }

        // 运算加法
        if (表达式.contains("-"))
            子表达式列表 = 运算处理(表达式, "-");
        if (子表达式列表.size() != 0) {
            for (String 子表达式 : 子表达式列表) {
                String 乘数 = 子表达式.split("\\-")[0];
                String 被乘数 = 子表达式.split("\\-")[1];
                if (乘数.startsWith("_V"))
                    乘数 = 堆栈值.get(乘数).toString();
                if (被乘数.startsWith("_V"))
                    被乘数 = 堆栈值.get(被乘数).toString();
                Object 子表达式值 = Double.parseDouble(乘数) - Double.parseDouble(被乘数);
                String 游标键 = "_V" + (表达式游标++);
                堆栈值.put(游标键, 子表达式值);
                表达式 = 表达式.replace(子表达式, 游标键);
            }
            return 处理表达式(表达式);
        }

        // 如果到最后是一个变量，则直接返回变量值
        if (表达式.matches("_V[0-9]+")) {
            return 堆栈值.get(表达式).toString();
        }

        throw new Exception("无法处理的表达式:" + 表达式);
    }

    public static List<String> getMatchList(String managers, String match) {
        List<String> ls = new ArrayList<String>();
        Pattern pattern = Pattern.compile(match);
        Matcher matcher = pattern.matcher(managers);
        while (matcher.find())
            ls.add(matcher.group());
        return ls;
    }
    public static void main(String[] args) throws Exception {
//        calc = calc.replace("+", "\\+").replace("*", "\\*").replace("-", "\\-");
//        System.out.println(成对处理("{123{432}}","{","}"));
//
//        System.out.println(运算处理("12*12+24*24","*"));
        String 表达式="100.25+ (100 /( 25+ 12.5*2))+50/(23+(1+1))";
        System.out.println(new Calculate().处理表达式(表达式));
        表达式="12*12+(3+3+(12*12)/12)";
        System.out.println(new Calculate().处理表达式(表达式));
    }
}
