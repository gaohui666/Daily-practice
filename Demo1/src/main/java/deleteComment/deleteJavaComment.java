package deleteComment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * title: 清除注释
 */
public class deleteJavaComment {

    public static void main(String[] args) throws FileNotFoundException {
        String rootDir = "E:\\projects\\eip-event\\interfaceInvok-service\\src\\main\\java\\com\\cic\\irc\\eip\\event\\interfaceInvok\\adaptor\\rest\\InterfaceInvokController.java";
        deepDir(rootDir);
    }

    private static void deepDir(String rootDir) throws FileNotFoundException {
        File folder = new File(rootDir);
        if (folder.isDirectory()) {
            String[] files = folder.list();
            if (files != null) {
                for (String file1 : files) {
                    File file = new File(folder, file1);
                    if (file.isDirectory() && !file.isHidden()) {
                        deepDir(file.getPath());
                    } else if (file.isFile() && file.getName().endsWith(".java")) {
                        clearComment(file.getPath());
                    }
                }
            }
        } else if (folder.isFile() && folder.getName().endsWith(".java")) {
            clearComment(folder.getPath());
        }
    }

    private static void clearComment(String filePathAndName)
            throws FileNotFoundException {
        StringBuilder buffer = new StringBuilder();
        String line = null; // 用来保存每行读取的内容
        InputStream is = new FileInputStream(filePathAndName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,
                StandardCharsets.UTF_8));
        try {
            line = reader.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\r\n"); // 添加换行符
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            } // 读取下一行
        }
        // 1、清除单行的注释，如： //某某，正则为 ：\/\/.*
        // 2、清除单行的注释，如：/** 某某 */，正则为：\/\*\*.*\*\/
        // 3、清除单行的注释，如：/* 某某 */，正则为：\/\*.*\*\/
        // 4、清除多行的注释，如:
        // /* 某某1
        // 某某2
        // */
        // 正则为：.*/\*(.*)\*/.*
        // 5、清除多行的注释，如：
        // /** 某某1
        // 某某2
        // */
        // 正则为：/\*\*(\s*\*\s*.*\s*?)*
        String filecontent = buffer.toString();

        Map<String, String> patterns = new HashMap<String, String>();
        patterns.put("([^:])\\/\\/.*", "$1");// 匹配在非冒号后面的注释，此时就不到再遇到http://
        patterns.put("\\s+\\/\\/.*", "");// 匹配“//”前是空白符的注释
        patterns.put("^\\/\\/.*", "");
        patterns.put("^\\/\\*\\*.*\\*\\/$", "");
        patterns.put("\\/\\*.*\\*\\/", "");
        patterns.put("/\\*(\\s*\\*\\s*.*\\s*?)*\\*\\/", "");
        //patterns.put("/\\*(\\s*\\*?\\s*.*\\s*?)*", "");
        Iterator<String> keys = patterns.keySet().iterator();
        String key, value;
        while (keys.hasNext()) {
            // 经过多次替换
            key = keys.next();
            value = patterns.get(key);
            filecontent = replaceAll(filecontent, key, value);
        }
        // 再输出到原文件
        try {
            File f = new File(filePathAndName);
            if (!f.getParentFile().exists()) {
                final boolean mkdirs = f.getParentFile().mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filePathAndName);
            byte[] bytes = filecontent.getBytes(StandardCharsets.UTF_8);
            out.write(bytes);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param fileContent   内容
     * @param patternString 匹配的正则表达式
     * @param replace       替换的内容
     */
    public static String replaceAll(String fileContent, String patternString, String replace) {
        String str = "";
        Matcher m;
        Pattern p;
        try {
            p = Pattern.compile(patternString);
            m = p.matcher(fileContent);
            str = m.replaceAll(replace);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}