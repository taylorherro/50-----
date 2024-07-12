package com.itheima.d3_util;

import java.util.Random;

public class MyUtil {

   private MyUtil() {

    }

    //验证码生成工具
    public static String createCode(int n) {
        String code = "";
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random r = new Random();

        for (int i = 0; i < n; i++) {
            int index = r.nextInt(data.length());
            code += data.charAt(index);
        }

        return code;
    }
}
