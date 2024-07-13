package com.itheima.d3_util;

import java.util.Random;

public class MyUtil {

   private MyUtil() {

    }//私有构造方法 防止被实例化

    //验证码生成工具
    public static String createCode(int n) {
        String code = "";
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random r = new Random();

        for (int i = 0; i < n; i++) {
            int index = r.nextInt(data.length());
            //返回index下表字符
            code += data.charAt(index);
        }

        return code;
    }
}
